/**
 * Author: Wenqiang Kuang
 * Date: 2018-07-17
 */

/**
 * Given a number n, print from 1 to the maximum n-digit number in sequence.
 * The number is likely to overflow. String can be used to represent number.
 */
public class Problem11 {
    public static void printToNdigit(int n){
        if(n <= 0){
            throw new RuntimeException("invalid input. ");
        }
        char[] currNumber = new char[n];
        for(int i = 0; i < n; i++){
            currNumber[i] = '0';
        }

        while(incrementCharArray(currNumber, n)){
            printNumber(currNumber);
        }
    }


    /**
     * Go to the leftmost non-9 digit if there is a carry.
     * if current_digit is not equal to 1, then add one for the leftmost digit
     * and restore current_digit numbers of 9 to 0.
     *
     * if current_digit is greater than the length of char[],
     * i.e. maximum reached, return false.
     */
    public static boolean incrementCharArray(char[] number, int n){
        int current_digit = 1;
        while(number[n-current_digit] == '9'){
            current_digit++;
            if(current_digit > n){
                return false;
            }
        }

        number[n-current_digit] = (char)(number[n-current_digit] + 1);
        if(current_digit != 1){
            for(int i = 1; i < current_digit; i++){
                number[n-i] = '0';
            }
        }
        return true;
    }

    public static void printNumber(char[] number){
        int start = 0;
        for(int i=0; i < number.length; i++){
            if(number[i] != '0'){
                start = i;
                break;
            }
        }
        for(int i = start; i < number.length; i++){
            System.out.print(number[i]);
        }

        System.out.println();
    }

    public static void main(String[] args){
        /*char[] number = new char[]{'1','9','9'};
        if(incrementCharArray(number,3)){
            for(char a:number){
                System.out.println(a);
            }
        }*/
        printToNdigit(10);
    }
}
