package New;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 输入一连串整数，整数之间以空格分开,，再输入一个整数表示按照固定规则排序后的位置，然后输出重新排序后对应的这个位置的整数。题目
 * 所给排序规则为：按照每个整数的后三位进行比较大小，按从小到大排序，不足三位的按原数值参与比较。倘若按规则比较两个数值相同，
 * 则顺序为输入时的相对位置。
 *
 * 输入：1223 22 3232 2016
 *      3
 *
 * 输出：1223
 * */
public class Huawei2018_3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String line = sc.nextLine();
            int index = sc.nextInt();

            ArrayList<Integer> nums = new ArrayList<>();
            String[] toks = line.split(" ");
            for(String s: toks){
                if(s.length() >= 3){
                    String actualNumber = s.substring(s.length()-3);
                    nums.add(Integer.parseInt(actualNumber));
                }else{
                    nums.add(Integer.parseInt(s));
                }
            }
            Collections.sort(nums);
            System.out.println(nums.get(index));
        }
    }
}
