package New;

import java.util.Scanner;

public class Huawei2019_a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String num1 = sc.next();
            String num2 = sc.next();
            //int size1 = size(num1);
            add(num1, num2);
        }
    }

    /*private static int size(String num) {
        int numDigit = num.length();
        int numSize = 0;
        for(int i = numDigit -1; i>0; i--){
            numSize += Integer.parseInt(num.charAt(i));
        }
    }*/

    private static void add(String num1, String num2) {
        int num1Digit = num1.length();
        int num1Size = 0;
    }
}
