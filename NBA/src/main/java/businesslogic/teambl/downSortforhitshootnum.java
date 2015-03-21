package businesslogic.teambl;

import java.util.ArrayList;

import vo.TeamVO;

public class downSortforhitshootnum {
	public static final int CUTOFF = 11;
	 
    /**
     * quick sort algorithm. <br />
     * 
     * @param arr an array of Comparable items. <br />
     */
     public static void quicksort( ArrayList<TeamVO> arr ) {
	 quickSort( arr, 0, arr.size() - 1 );
     }
 
     /**
      * get the median of the left, center and right. <br />
      * order these and hide the pivot by put it the end of
      * of the array. <br />
      * 
      * @param arr an array of Comparable items. <br />
      * @param left the most-left index of the subarray. <br />
      * @param right the most-right index of the subarray.<br />
      * @return T
      */
      public static TeamVO median( ArrayList<TeamVO> arr, int left, int right ) {
 
		int center = ( left + right ) / 2;
 
		if ( arr.get(left).getHitShootNum()<arr.get(center).getHitShootNum() )
			swapRef( arr, left, center );
		if ( arr.get(left).getHitShootNum() <arr.get(right).getHitShootNum() )
			swapRef( arr, left, right );
		if ( arr.get(center).getHitShootNum() <arr.get(right).getHitShootNum() )
			swapRef( arr, center, right );
 
		swapRef( arr, center, right - 1 );
		return arr.get( right - 1 );
      }
 
     /**
      * internal method to sort the array with quick sort algorithm. <br />
      * 
      * @param arr an array of Comparable Items. <br />
      * @param left the left-most index of the subarray. <br />
      * @param right the right-most index of the subarray. <br />
      */
      private static  void quickSort( ArrayList<TeamVO> arr, int left, int right ) {
		if ( left + CUTOFF <= right  ) {
			//find the pivot
			TeamVO pivot = median( arr, left, right );
 
			//start partitioning
			int i = left, j = right - 1;
			for ( ; ; ) {
				while ( arr.get(++i).getHitShootNum()>pivot.getHitShootNum() ) ;
				while (arr.get(--j).getHitShootNum()<pivot.getHitShootNum() ) ;
				if ( i < j )
					swapRef( arr, i, j );
				else
					break;
			}
 
			//swap the pivot reference back to the small collection.
			swapRef( arr, i, right - 1 );
 
			quickSort( arr, left, i - 1 );		//sort the small collection.
			quickSort( arr, i + 1, right );		//sort the large collection.
 
		} else {
			//if the total number is less than CUTOFF we use insertion sort instead (cause it much more efficient).
			insertionSort( arr, left, right );
		}
      }
 
 
      /**
       * method to swap references in an array.<br />
       * 
       * @param arr an array of Objects. <br />
       * @param idx1 the index of the first element. <br />
       * @param idx2 the index of the second element. <br />
       */
      public static void swapRef( ArrayList<TeamVO> arr, int idx1, int idx2 ) {
		TeamVO tmp = arr.get(idx1);
		arr.set(idx1, arr.get(idx2));
		arr.set(idx2, tmp);
      }
 
 
      /**
       * method to sort an subarray from start to end
       * 		with insertion sort algorithm. <br />
       * 
       * @param arr an array of Comparable items. <br />
       * @param start the begining position. <br />
       * @param end the end position. <br />
       */
      public static  void insertionSort( ArrayList<TeamVO> arr, int start, int end ) {
		int i;
		for ( int j = start + 1; j <= end; j++ ) {
			TeamVO tmp = arr.get(j);
			for ( i = j; i > start && tmp.getHitShootNum()> arr.get(i - 1).getHitShootNum() ; i-- ) {
				arr.set(i, arr.get(i-1));
			}
			arr.set(i, tmp);
		}
      }

}
