package businesslogic.playerbl;

import java.util.ArrayList;

import test.data.PlayerHighInfo;
import test.data.PlayerNormalInfo;

public class RebTotalNumUPSort {
	public static final int CUTOFF = 11;
	
	public void quicksort( ArrayList<PlayerNormalInfo> arr ) {
		quickSort( arr, 0, arr.size() - 1 ); 
	}
	
	public void mulSort(ArrayList<PlayerNormalInfo> arr,int beg,int end){
		quickSort( arr, beg, end );
	}
	
	public PlayerNormalInfo median( ArrayList<PlayerNormalInfo> arr, int left, int right ) {
		int center = ( left + right ) / 2;
		
		if ( arr.get(left).getRebound()>arr.get(center).getRebound() )
			swapRef( arr, left, center );
		if ( arr.get(left).getRebound()>arr.get(right).getRebound() )
			swapRef( arr, left, right );
		if ( arr.get(center).getRebound()>arr.get(right).getRebound() )
			swapRef( arr, center, right );
 
		swapRef( arr, center, right - 1 );
		return arr.get( right - 1 );
      }
	
	private void quickSort( ArrayList<PlayerNormalInfo> arr, int left, int right ) {
		
		if ( left + CUTOFF <= right  ) {
			//find the pivot
			PlayerNormalInfo pivot = median( arr, left, right );
			//start partitioning
			int i = left, j = right - 1;
			for ( ; ; ) {
				while ( arr.get(++i).getRebound()< pivot.getRebound()  ) ;
				while ( arr.get(--j).getRebound()> pivot.getRebound() ) ;
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
	
	public void swapRef( ArrayList<PlayerNormalInfo> arr, int idx1, int idx2 ) {  
		PlayerNormalInfo tmp = arr.get(idx1);
		arr.set(idx1, arr.get(idx2));
		arr.set(idx2, tmp);
      }
	
	public void insertionSort( ArrayList<PlayerNormalInfo> arr, int start, int end ) {
		int i;
		for ( int j = start + 1; j <= end; j++ ) {
			PlayerNormalInfo tmp = arr.get(j);
			for ( i = j; i > start && tmp.getRebound()<arr.get(i - 1).getRebound(); i-- ) {
				arr.set(i, arr.get(i-1));
			}
			arr.set(i, tmp);
			}
	}
}
