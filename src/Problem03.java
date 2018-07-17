/**
 * Author: Wenqiang Kuang
 * Date: 2018-07-04
 */

public class Problem03 {
    /**
     * Replace the whitespace in a string with '%20'.
     * @param str The String to be modified.
     * @return the result string with %20 replacing whitespace.
     */
    public static String replaceWhitespace(String str){
        // if input string is empty, return.
        int strLength = str.length();
        if(strLength == 0){
           return str;
        }

        char[] strChar = str.toCharArray();

        // check the number of whitespace in the input string.
        int whitespaceCount = 0;
        for(char a : strChar){
            if(a == ' '){
                whitespaceCount ++;
            }
        }

        // no whitespace found, return the input string.
        if(whitespaceCount == 0){
            return str;
        }

        // calculate the length of output string and construct from a new char
        // array.
        int outputStrLen = whitespaceCount * 2 + strLength;
        char[] outputStr = new char[outputStrLen];
        int index = 0;
        for(char c : strChar){
            if(c != ' '){
                outputStr[index++] = c;
            }else{
                outputStr[index++] = '%';
                outputStr[index++] = '2';
                outputStr[index++] = '0';
            }
        }
        return new String(outputStr);
    }

    public static void main(String[] args){
        String str1 = "g g g g";
        String str2 = " ll l l ";
        System.out.println(replaceWhitespace(str1));
        System.out.println(replaceWhitespace(str2));

        //built-in method
        System.out.println(str1.replace(" ", "%20"));
    }
}
