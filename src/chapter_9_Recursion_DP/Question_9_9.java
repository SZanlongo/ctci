package chapter_9_Recursion_DP;

import java.util.ArrayList;
import java.util.Arrays;

//place pieces on an 8x8 board, where none share the same row, column, or diagonal
public class Question_9_9 {
    private static int RC = 8; // number of rows and columns
    private static ArrayList<Integer[]> solutions = new ArrayList<Integer[]>();

    // positions of pieces (col pos, where each index is row)
    private static Integer[] positions = new Integer[RC];

    public static void main(String[] args) {
        for (int i = 0; i < RC; i++) {
            positions[i] = -1;
        }

        setPositions(0);

        for (Integer[] sol : solutions) {
            System.out.println(Arrays.toString(sol));
        }
    }

    public static void setPositions(int row) {
        if (row == RC) {
            // done traversing rows
            solutions.add(positions.clone());
        } else {
            // traverse columns at that row
            for (int col = 0; col < RC; col++) {
                if (checkPosition(positions, row, col)) {
                    // valid position, place and check next row
                    positions[row] = col;
                    setPositions(row + 1);
                }
            }
        }
    }

    public static boolean checkPosition(Integer[] positions, int r, int c) {
        for (int i = 0; i < r; i++) {
            // check if same column
            // (no need to check row because of how pieces are placed)
            if (c == positions[i]) {
                return false;
            }

            // diagonal check
            // if |col1-col2| == row1-row2 then diagonal
            if ((Math.abs(positions[i] - c)) == (r - i)) {
                return false;
            }
        }

        return true;
    }

}
