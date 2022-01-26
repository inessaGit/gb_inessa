package main;

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

        System.out.println(State.DOT_X);
        int[][] matrix = new int[3][3];
        for (int[] row : matrix) {
            Arrays.fill(row, 1);
            System.out.println(Arrays.toString(row));
        }

        String test ="hello";
        String test1= String.format(test, "%d");
        System.out.println(test1);
        System.out.printf("%d",test);


    }

}