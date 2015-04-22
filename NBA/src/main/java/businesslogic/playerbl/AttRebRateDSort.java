package businesslogic.playerbl;

import java.util.ArrayList;

import test.data.PlayerHighInfo;

public class AttRebRateDSort {
public static final int CUTOFF = 11;
	
	public void quicksort( ArrayList<PlayerHighInfo> arr ) {
		quickSort( arr, 0, arr.size() - 1 ); 
	}
	
	public PlayerHighInfo median( ArrayList<PlayerHighInfo> arr, int left, int right ) {
		int center = ( left + right ) / 2;
		
		if ( arr.get(left).getOffendReboundEfficient()<arr.get(center).getOffendReboundEfficient() )
			swapRef( arr, left, center );
		if ( arr.get(left).getOffendReboundEfficient()<arr.get(right).getOffendReboundEfficient() )
			swapRef( arr, left, right );
		if ( arr.get(center).getOffendReboundEfficient()<arr.get(right).getOffendReboundEfficient() )
			swapRef( arr, center, right );
 
		swapRef( arr, center, right - 1 );
		return arr.get( right - 1 );
      }
	
	private void quickSort( ArrayList<PlayerHighInfo> arr, int left, int right ) {
		
		if ( left + CUTOFF <= right  ) {
			//find the pivot
			PlayerHighInfo pivot = median( arr, left, right );
			//start partitioning
			int i = left, j = right - 1;
			for ( ; ; ) {
				while ( arr.get(++i).getOffendReboundEfficient()> pivot.getOffendReboundEfficient()  ) ;
				while ( arr.get(--j).getOffendReboundEfficient()< pivot.getOffendReboundEfficient() ) ;
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
	
	public void swapRef( ArrayList<PlayerHighInfo> arr, int idx1, int idx2 ) {  
		PlayerHighInfo tmp = arr.get(idx1);
		arr.set(idx1, arr.get(idx2));
		arr.set(idx2, tmp);
      }
	
	public void insertionSort( ArrayList<PlayerHighInfo> arr, int start, int end ) {
		int i;
		for ( int j = start + 1; j <= end; j++ ) {
			PlayerHighInfo tmp = arr.get(j);
			for ( i = j; i > start && tmp.getOffendReboundEfficient()>arr.get(i - 1).getOffendReboundEfficient(); i-- ) {
				arr.set(i, arr.get(i-1));
			}
			arr.set(i, tmp);
			}
	}
}
