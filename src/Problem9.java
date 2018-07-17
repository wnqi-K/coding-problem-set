/**
 * Author: Wenqiang Kuang
 * Date: 2018-07-17
 */

/**
 * Given a number, return the number of 1s in its binary form.
 */
public class Problem9 {
    public static int count1(int n){
        int count = 0;

        // Binary form for 1 is simply 0{28} 0001
        // Do 'bit and' with any positive int would return 0
        // if the last bit is 0 and return 1 if last bit is 1
        for(int i = 0; i < 32; i++){
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(count1(32));
        System.out.println(count1(27));
        System.out.println(count1(1023));
        System.out.println(count1(2047));
    }
}
