/**
 * Author: Wenqiang Kuang
 * Date: 2018-07-17
 */

/**
 * Give an integer n, return the nth fibonacci number.
 * Complexity O(n)
 */
public class Problem8 {
    public static long fibonacci(int n){
        if(n <= 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        long n1 = 1;
        long n2 = 1;
        long n3 = 2;
        while(n - 2 >= 0){
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            n--;
        }
        return n3;
    }

    public static void main(String[] args){
        System.out.println(fibonacci(10));
        System.out.println(fibonacci(20));
        System.out.println(fibonacci(30));
    }
}
