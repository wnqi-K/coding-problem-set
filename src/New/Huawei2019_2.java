package New;

/**
 * 八小时聚会, 时间段为12:00-20:00, 来访客人到达时间和离开时间用int,int表示,计算八个时间段的客人数量.
 *
 * 输入: -1,-1 表示结束
 * 12,15
 * 12,13
 *
 * 输出:
 * [12,13):2
 * [13,14):1
 * [14,15):1
 *
 * */
import java.util.HashMap;
import java.util.Scanner;
public class Huawei2019_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i <= 100; i++){
            if(sc.hasNext()){
                String guest = sc.nextLine();
                String[] startEnd = guest.split(",");
                int start = Integer.parseInt(startEnd[0]);
                int end = Integer.parseInt(startEnd[1]);
                if(start == -1 || end == -1){
                    break;
                }
                for(int j = start; j < end; j++){
                    if(count.containsKey(j)){
                        count.put(j, count.get(j)+1);
                    }else{
                        count.put(j, 1);
                    }
                }
            }else{
                break;
            }
        }
        for(int k = 12; k < 20; k++){
            if(count.containsKey(k)){
                System.out.println("[" + k + "," + (k+1) + "):" + count.get(k));
            }
        }
    }
}
