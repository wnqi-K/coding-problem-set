package New;

import java.util.Scanner;

/**
 * 输入一个整数，输出整数的位数，倒序输出它的每一位数字（数字之间空格分开）和倒序的连续数值，而且题目限定了输入的整数不超过五位数。
 *
 * 输入：-12345
 * 输出：-5 4 3 2 1
 *      -54321
 * */
public class Huawei2018_1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String line = sc.nextLine();
            Boolean isNegative = false;
            if(line.contains("-")){
                isNegative = true;
                line = line.substring(1);
            }
            if(isNegative){
                System.out.print("-");
            }
            for(int i = line.length()-1; i>0; i--){
                System.out.print(line.charAt(i) + " ");
            }
            System.out.print(line.charAt(0));
            System.out.println();

            if (isNegative){
                System.out.print("-");
            }
            System.out.println(new StringBuffer(line).reverse());
        }
    }
}
