package New;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 * 处理:
 * 1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一条，错误计数增加；(文件所在的目录不同，文件名和行号相同也要合并)
 * 2.超过16个字符的文件名称，只记录文件的最后有效16个字符；(如果文件名不同，而只是文件名的后16个字符和行号相同，也不要合并)
 * 3.输入的文件可能带路径，记录文件名称不能带路径
 *
 * Input:
 * 一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
 *
 *     文件路径为windows格式
 *
 *     如：E:\V1R2\product\fpgadrive.c 1325
 *
 * Output:
 * 将所有的记录统计并将结果输出，格式：文件名代码行数数目，一个空格隔开，如: fpgadrive.c 1325 1
 *
 *    结果根据数目从多到少排序，数目相同的情况下，按照输入第一次出现顺序排序。
 *
 *    如果超过8条记录，则只输出前8条记录.
 *
 *    如果文件名的长度超过16个字符，则只输出后16个字符
 *
 *    e.g.  E:\V1R2\product\fpgadrive.c 1325
 *          fpgadrive.c 1325 1
 * */
public class Huawei2016_02 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> errorLog = new HashMap<>();

        while(sc.hasNext()){
            /*if(errorLog.keySet().size() == 8){
                break;
            }*/
            String line = sc.nextLine();
            String[] toks = line.split("\\\\");
            String nameLine = toks[toks.length-1];
            if(errorLog.containsKey(nameLine)){
                errorLog.put(nameLine, errorLog.get(nameLine) + 1);
            }else{
                if(errorLog.keySet().size() == 8){
                    // doing nothing
                }else{
                    errorLog.put(nameLine, 1);
                }
            }
        }

        for(String file : errorLog.keySet()){
            String[] fileLine = file.split(" ");
            String fileName = fileLine[0];
            int length = fileName.length();
            String abbrv = fileName;
            if(length >= 16){
                abbrv = fileName.substring(length-16, length);
            }
            System.out.println(abbrv + " " + fileLine[1] + " " + errorLog.get(file));
        }
    }
}
