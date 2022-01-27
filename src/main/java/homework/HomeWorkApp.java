package main;

import java.util.ArrayList;
import java.util.List;

public class HomeWorkApp {

    public static void printThreeWords(){

        List<String> fruits = new ArrayList<>();
        fruits.add("Orange");
        fruits.add("Banana");
        fruits.add("Apple");

        for (int i=0;i<3;i++){
            System.out.println(fruits.get(i));
        }
    }
    public static void checkSumSign(){
        int a=0;
        int b =2;
        String result = a+b>=0 ? "Sum is positive": "Sum is negative";
        System.out.println(result);
    }
    public static void  printColor(){
        /*
        Если value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение “Красный”,
        если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно), то “Желтый”,
        если больше 100 (100 исключительно) - “Зеленый”;
         */
        int value =90;
        String result =value<=0 ? "Red":(value>0 && value<=100) ?"Yellow" : (value>100) ? "Green" :"";
        System.out.println(result);
    }

    public static void compareNumbers(){
        /*
        Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”,
        в противном случае “a < b”;
         */
        int a =4;
        int b =9;
        String result = a>=b ? "a >= b": "a < b" ;
        System.out.println(result);
    }

    public static void main (String []args){
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

}

