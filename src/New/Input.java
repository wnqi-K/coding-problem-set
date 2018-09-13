package New;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Input {

    // Input an integer
    public static void anInt(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter an integer. ");
        int number = sc.nextInt();
        System.out.println("The number is " + number);
    }

    // Input a double
    public static void aDouble(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a double. ");
        double number = sc.nextDouble();
        System.out.println("The number is " + number);
    }

    // Input string, and print out chars
    public static void aString(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a String. ");
        String line = sc.nextLine();
        char[] chars = line.toCharArray();
        for(char c : chars){
            System.out.print(c + "\t");
        }
    }

    // Input an array of integer, given the number of integer
    public static void aLineOfInt(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the total number of integers. ");
        int count = sc.nextInt();

        System.out.println("enter a list of integer, separate with whitespace: ");
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < count; i++){
            list.add(sc.nextInt());
        }
        System.out.println(list.toString());
    }

    // Input multiple sets of 'double' array, each has a count number before.
    public static void linesOfDouble(){
        Scanner sc = new Scanner(System.in);

        ArrayList<ArrayList<Double>> lists = new ArrayList<>();
        while(sc.hasNext()){
            int count = sc.nextInt();
            ArrayList<Double> line = new ArrayList<>();
            for(int i = 0; i < count; i++){
                line.add(sc.nextDouble());
            }
            lists.add(line);
        }

        for(ArrayList<Double> line : lists){
            System.out.println(line.toString());
        }
    }

    // Input a date in format DD/MM/YYYY
    public static void aDate(){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] date = line.split("/");

        System.out.println("Day: " + Integer.parseInt(date[0]) + " Month: " + Integer.parseInt(date[1]) + " Year: " + Integer.parseInt(date[2]));
    }

    // Input operators and number, out results
    public static void operations(){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        for(int i = 0; i < count; i++){
            String op = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(op.charAt(0) == '+'){
                System.out.println(a + b);
            }else if(op.charAt(0) == '-'){
                System.out.println(a - b);
            }else if(op.charAt(0) == '*'){
                System.out.println(a * b);
            }else if(op.charAt(0) == '/'){
                if(a % b == 0){
                    System.out.println(a / b);
                }else{
                    System.out.printf("%.2f", a/(b*1.0));
                }
            }
        }
    }

    // Input an array of int and sort(quick sort)
    public static void intArray(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ary[] = new int[n];
        for(int i =0; i < n; i++){
            ary[i] = sc.nextInt();
        }
        Arrays.sort(ary);
        System.out.println(Arrays.toString(ary));
    }

    public static void main(String[] args){
        //aString();
        //aLineOfInt();
        //linesOfDouble();
        //aDate();
        //operations();
        //intArray();
    }
}
