package New;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * 给出一个字符串，将重复的字符去除，仅保留第一次出现的字符，且保持去重后的字符在原字符串中的顺序不变。
 *
 * 输入数据是一个字符串（不包含空格）
 *
 * 输出去重后的字符串
 *
 * 输入：12ere2
 *
 * 输出：12er
 *
 * */
public class Huawei2019_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            ArrayList<Character> chars = new ArrayList<>();
            String word = sc.next();
            for(char c : word.toCharArray()){
                if(!chars.contains(c)){
                   chars.add(c);
                }
            }
            for(char c:chars){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
