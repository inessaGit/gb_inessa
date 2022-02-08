package temp;
import org.testng.annotations.*;

import java.util.*;

public class Temp {
    enum State {
        DOT_EMPTY, DOT_X, DOT_0;
    }
    // To print out the board.
    /* |---|---|---|
       | 1 | 2 | 3 |
       |-----------|
       | 4 | 5 | 6 |
       |-----------|
       | 7 | 8 | 9 |
       |---|---|---|*/
    public static void main(String args[]) {
      String s=2+2+"=value";
        System.out.println(s);

        System.out.println(State.DOT_X);
        int[][] matrix = new int[3][3];
        for (int[] row : matrix) {
            Arrays.fill(row, 1);
            System.out.println(Arrays.toString(row));
        }


    }

}