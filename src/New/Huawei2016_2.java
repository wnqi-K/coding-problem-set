package New;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 输入一个字符串，求出该字符串包含的字符集合
 * 每组数据输入一个字符串，字符串最大长度为100，且只包含字母，不可能为空串，区分大小写。
 *
 * 每组数据一行，按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出。
 * input: abcqweracb
 * output: abcqwer
 *
 * */

public class Huawei2016_2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String line = sc.nextLine();
            outputUniqueChars(line);
        }
    }

    private static void outputUniqueChars(String line) {
        ArrayList<Character> charList = new ArrayList<>();
        for(char a: line.toCharArray()){
            if(!charList.contains(a)){
                charList.add(a);
            }
        }
        for(char a : charList){
            System.out.print(a);
        }
        System.out.println();
    }
}
