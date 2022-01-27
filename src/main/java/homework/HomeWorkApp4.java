package main;

import java.util.*;
/*
By default :
- player using X
- AI using O
 */
public class HomeWorkApp4 {
    enum State{E, X, O};//E means empty cell
    static int SIZE = 3;
    static State[][] map = new State[SIZE][SIZE];
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    static boolean gameOver =false;

    public static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = State.E;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <SIZE; i++) {
          System.out.print("\t");
            System.out.print(i+1);
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + "\t ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (! isCellValid(x, y)); // while(isCellValid(x, y) == false)
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        makeMove(x,y,State.O);
    }
    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X(row) Y(col)");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (! isCellValid(x, y)); // while(isCellValid(x, y) == false)
       // map[y][x] = State.X;
        makeMove(x,y,State.X);
    }
    public static boolean isCellValid (int x, int y)  {
        if (map[x][y] == State.E) return true;
        return false;
    }
    static void makeMove(int x, int y, State s){
        map[x][y] = s;
        //check end conditions check col
        for(int i = 0; i < SIZE; i++){
            if(map[x][i] != s)
                break;
            if(i == SIZE -1){
                //report win for s
                System.out.println("Победил "+s);
                gameOver=true;
            }
        }
        //check row
        for(int i = 0; i < SIZE; i++){
            if(map[i][y] != s)
                break;
            if(i == SIZE -1){
                //report win for s
                System.out.println("Победил "+s);
                gameOver=true;
            }
        }
        //check diagonal LR
        if(x == y){
            //we're on a diagonal
            for(int i = 0; i < SIZE; i++){
                if(map[i][i] != s)
                    break;
                if(i == SIZE -1){
                    //report win for s
                    System.out.println("Победил "+s);
                    gameOver=true;
                }
            }
        }
        //check anti diagonal RL
        if(x + y == SIZE - 1){
            for(int i = 0; i < SIZE; i++){
                if(map[i][(SIZE -1)-i] != s)
                    break;
                if(i == SIZE -1){
                    //report win for s
                    System.out.println("Победил "+s);
                    gameOver=true;
                }
            }
        }
        //check draw
        if(isMapFull()){
            //report draw
            System.out.println("It's a draw ");
            gameOver=true;
        }
    }
    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == State.E) return false;
            }
        }
        return true;
    }

    public static void main (String args[]){
        initMap();
        printMap();
        while (gameOver==false) {
            humanTurn();
            printMap();
            if(gameOver==true)break;
            aiTurn();
            printMap();
        }
        System.out.println("Игра закончена");
    }
    }
