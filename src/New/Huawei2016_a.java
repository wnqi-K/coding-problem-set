package New;

import java.util.Scanner;
/**有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”答案是5瓶，
 * 方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。然后你让老板先借给你
 * 一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
 *
 * 输入文件最多包含10组测试数据，每个数据占一行，仅包含一个正整数n（1<=n<=100），表示小张手上的空汽水瓶数。n=0表示输入结束，
 * 你的程序不应当处理这一行。
 *
 * 对于每组测试数据，输出一行，表示最多可以喝的汽水瓶数。如果一瓶也喝不到，输出0。
 *
 * input:
 * 3
 * 10
 * 81
 * 0
 *
 * output:
 * 1
 * 5
 * 40
 *
 * */
public class Huawei2016_a {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<=10; i++){
            if(sc.hasNext()){
                int number = sc.nextInt();
                if(number != 0){
                    calc(number);
                }else{
                    break;
                }
            }
        }
    }

    private static void calc(int number) {
        if(number == 1){
            System.out.println(0);
        }else if(number == 2){
            System.out.println(1);
        }else{
            int empty = number;
            int output = 0;
            int remainder;
            while(empty > 2){
                output += empty/3;
                remainder = empty%3;
                empty = empty/3 + remainder;
                if(empty == 2){
                    output ++;
                }
            }
            System.out.println(output);
        }
    }
}
