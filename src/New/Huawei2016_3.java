package New;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 数独是一个我们都非常熟悉的经典游戏，运用计算机我们可以很快地解开数独难题，现在有一些简单的数独题目，请编写一个程序求解。
 * 输入9行，每行为空格隔开的9个数字，为0的地方就是需要填充的。
 *
 * 输出九行，每行九个空格隔开的数字，为解出的答案。
 * */
public class Huawei2016_3 {
    public static final int SIZE = 9;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        ArrayList<ArrayList<Integer>> sudoku = new ArrayList<>();
        while (sc.hasNext()){
            for(int i=0; i<9; i++){
                ArrayList<Integer> line = new ArrayList<>();
                for(int j=0; j<9; j++){
                    int next = sc.nextInt();
                    line.add(next);
                }
                sudoku.add(line);
            }
            solve(sudoku);
        }
    }

    private static boolean isInRow(ArrayList<ArrayList<Integer>> sudoku, int row, int number) {
        for (int i = 0; i < SIZE; i++)
            if (sudoku.get(row).get(i) == number)
                return true;
        return false;
    }

    private static boolean isInCol(ArrayList<ArrayList<Integer>> sudoku, int col, int number) {
        for (int i = 0; i < SIZE; i++)
            if (sudoku.get(i).get(col) == number)
                return true;
        return false;
    }

    private static boolean isInBox(ArrayList<ArrayList<Integer>> sudoku, int row, int col, int number) {
        int r = row - row % 3;
        int c = col - col % 3;

        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (sudoku.get(i).get(j) == number)
                    return true;

        return false;
    }

    // combined method to check if a number possible to a row,col position is ok
    private static boolean isOk(ArrayList<ArrayList<Integer>> sudoku, int row, int col, int number) {
        return !isInRow(sudoku, row, number)  &&  !isInCol(sudoku, col, number)  &&  !isInBox(sudoku, row, col, number);
    }

    private static boolean solvable(ArrayList<ArrayList<Integer>> sudoku) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                // we search an empty cell
                if (sudoku.get(row).get(col) == 0) {
                    // we try possible numbers
                    for (int number = 1; number <= SIZE; number++) {
                        if (isOk(sudoku, row, col, number)) {
                            // number ok. it respects sudoku constraints
                            sudoku.get(row).set(col, number);

                            if (solvable(sudoku)) { // we start backtracking recursively
                                return true;
                            } else { // if not a solution, we empty the cell and we continue
                                sudoku.get(row).set(col, 0);
                            }
                        }
                    }

                    return false; // we return false
                }
            }
        }

        return true;
    }

    public static void solve(ArrayList<ArrayList<Integer>> sudoku){
        if(solvable(sudoku)){
            for(ArrayList<Integer> line : sudoku){
                for(int i : line){
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }else{
            System.out.println("unable to solve. ");
        }
    }
}
