/**
 * Author: Wenqiang Kuang
 * Date: 2018-07-17
 */

/**
 * Find the minimum number in a rotated array derived from a sorted array.
 * The array is only rotated once.
 * complexity n(Log n)
 */
public class Problem07 {
    public static int findMinimum(int[] array, int start, int end) {
        if(array == null){
            throw new RuntimeException("invalid New.Input.");
        }

        if (start == end) {
            return array[start];
        }

        // special case, array is not rotated.
        if (start > end) {
            return array[0];
        }

        int mid = (start + end) / 2;
        if(mid < end && array[mid] > array[mid + 1]) {
            return array[mid + 1];
        }
        if(mid > start && array[mid] < array[mid - 1]){
            return array[mid];
        }
        if(array[end] > array[mid]){
            return findMinimum(array, start, mid);
        }
        return findMinimum(array, mid+1, end);
    }

    public static void main(String args[]){
        int[] array1 = {4,5,6,7,8,2,3};
        int[] array2 = {4,5,6,7,1,1,1};
        int[] array3 = {4,5,6,7,8,9,10};
        int[] array4 = {3,4,3,3,3,3,3};

        System.out.println(findMinimum(array1, 0, array1.length -1));
        System.out.println(findMinimum(array2, 0, array1.length -1));
        System.out.println(findMinimum(array3, 0, array1.length -1));
        System.out.println(findMinimum(array4, 0, array1.length -1));
    }
}
