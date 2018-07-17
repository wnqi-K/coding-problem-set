/**
 * Author: Wenqiang Kuang
 * Date: 2018-07-04
 */

public class Problem02 {
    /**
     * Look up an integer in a two dimensional array, whose numbers show ascending
     * orders in both rows and columns.
     * @param matrix The two dimensional array
     * @param num the number to look up
     * @return true or false showing the lookup result.
     */
    public static Boolean lookup(int[][] matrix, int num){

        if(matrix == null || matrix.length < 1 || matrix[0].length < 1){
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int currRow = 0;
        int currCol = cols - 1;

        while(currRow >= 0 && currRow < rows && currCol >= 0 && currCol < cols){
            if(matrix[currRow][currCol] == num){
                return true;
            }else if(matrix[currRow][currCol] > num){
                currCol --;
            }else{
                currRow ++;
            }
        }
        return false;
    }

    public static void main(String args[]){
        int[][] matrix = {{1, 6, 9, 11},
                          {7, 13, 17, 21},
                          {11, 14, 18, 23},
                          {30, 32, 34, 37}};
        System.out.println(lookup(matrix, 11));
        System.out.println(lookup(matrix, 15));
        System.out.println(lookup(matrix, 14));
        System.out.println(lookup(null, 1));
    }
}
