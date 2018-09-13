package New;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 输入包括多组测试数据。
 * 每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
 * 学生ID编号从1编到N。
 * 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
 * 接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
 * 当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
 * <p>
 * 对于每一次询问操作，在一行里面输出最高成绩.
 * <p>
 * Input :
 * 5 7
 * 1 2 3 4 5
 * Q 1 5
 * U 3 6
 * Q 3 4
 * Q 4 5
 * U 4 5
 * U 2 9
 * Q 1 5
 * <p>
 * Output:
 * 5
 * 6
 * 5
 * 9
 */

public class Huawei2016_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int studentCount = sc.nextInt();
        int commandCount = sc.nextInt();

        ArrayList<Integer> grades = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            grades.add(sc.nextInt());
        }

        String space = sc.nextLine();
        ArrayList<Integer> returnValues = new ArrayList<>();
        for (int i = 0; i < commandCount; i++) {
            String command = sc.nextLine();
            if (command.isEmpty()) {

            } else {
                String[] toks = command.split(" ");
                if (toks[0].charAt(0) == 'Q') {
                    int s1 = Integer.parseInt(toks[1]) - 1;
                    int s2 = Integer.parseInt(toks[2]) - 1;
                    int returnValue = grades.get(s1);
                    for (int j = s1; j < s2; j++) {
                        if (grades.get(j) > returnValue) {
                            returnValue = grades.get(j);
                        }
                    }
                    returnValues.add(returnValue);
                } else if (toks[0].charAt(0) == 'U') {
                    int s = Integer.parseInt(toks[1]) - 1;
                    int g = Integer.parseInt(toks[2]);
                    grades.set(s, g);
                }
            }
        }

        for(int i : returnValues){
            System.out.println(i);
        }
    }
}
