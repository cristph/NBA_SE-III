package businesslogic.playerbl;

import java.util.ArrayList;

import vo.PlayerInfoVO;

public class InTimeUPSort {
	public static final int CUTOFF = 11;
	
	public void quicksort( ArrayList<PlayerInfoVO> arr ) {
		quickSort( arr, 0, arr.size() - 1 ); 
	}
	
	public PlayerInfoVO median( ArrayList<PlayerInfoVO> arr, int left, int right ) {
		int center = ( left + right ) / 2;
		
		if ( arr.get(left).getInTime()>arr.get(center).getInTime() )
			swapRef( arr, left, center );
		if ( arr.get(left).getInTime()>arr.get(right).getInTime() )
			swapRef( arr, left, right );
		if ( arr.get(center).getInTime()>arr.get(right).getInTime() )
			swapRef( arr, center, right );
 
		swapRef( arr, center, right - 1 );
		return arr.get( right - 1 );
      }
	
	private void quickSort( ArrayList<PlayerInfoVO> arr, int left, int right ) {
		
		if ( left + CUTOFF <= right  ) {
			//find the pivot
			PlayerInfoVO pivot = median( arr, left, right );
			//start partitioning
			int i = left, j = right - 1;
			for ( ; ; ) {
				while ( arr.get(++i).getInTime()< pivot.getInTime() ) ;
				while ( arr.get(--j).getInTime()> pivot.getInTime() ) ;
				if ( i < j )
					swapRef( arr, i, j );
				else
					break;
			}
			
			//swap the pivot reference back to the small collection.
			swapRef( arr, i, right - 1 );
			
			quickSort( arr, left, i - 1 );		//sort the small collection.
			quickSort( arr, i + 1, right );		//sort the large collection.
			
		}else{
			//if the total number is less than CUTOFF we use insertion sort instead (cause it much more efficient).
			insertionSort( arr, left, right );
		}
	}
	
	public void swapRef( ArrayList<PlayerInfoVO> arr, int idx1, int idx2 ) {  
		PlayerInfoVO tmp = arr.get(idx1);
		arr.set(idx1, arr.get(idx2));
		arr.set(idx2, tmp);
      }
	
	public void insertionSort( ArrayList<PlayerInfoVO> arr, int start, int end ) {
		int i;
		for ( int j = start + 1; j <= end; j++ ) {
			PlayerInfoVO tmp = arr.get(j);
			for ( i = j; i > start && tmp.getInTime()<arr.get(i - 1).getInTime(); i-- ) {
				arr.set(i, arr.get(i-1));
			}
			arr.set(i, tmp);
			}
	}
}
