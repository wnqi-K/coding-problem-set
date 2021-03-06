package New;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，求最后一个被删掉的数的原始下标位置。
 * 以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。
 *
 * 每组数据为一行一个整数n(小于等于1000)，为数组成员数,如果大于1000，则对a[999]进行计算。
 *
 * 一行输出最后一个被删掉的数的原始下标位置。
 *
 * input e.g. 8
 * output 6
 * */

public class Huawei2016_1 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            if(num > 999){
                calcIndex(999);
            }else{
                calcIndex(num);
            }
        }
    }

    private static void calcIndex(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < num; i++){
            list.add(i);
        }

        int i = 0;
        while(list.size() > 1){
            i = (i + 2) % list.size();
            list.remove(i);
        }
        System.out.println(list.get(0));
    }
}
