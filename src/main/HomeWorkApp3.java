package main;
import java.util.*;
public class HomeWorkApp3 {
    public static void replaceZero(){
        int length = 10;
        int [] arr = new int [length];
        for (int i=0;i<length;i++){
            if (i%2==0) arr[i]=0;
            else arr[i]=1;
        }
        System.out.println(Arrays.toString((arr)));
        for (int i=0;i<length;i++){
            if(arr[i]==0){
                arr[i]=1;
            }
            else arr[i]=0;
        }
        System.out.println(Arrays.toString((arr)));
        System.out.println("======================");

    }
    public static void fillArray(){
        int [] arr = new int [100];
        for(int i=0;i<100; i++){
            arr[i]=i+1;
        }
        System.out.println(Arrays.toString((arr)));
        System.out.println("======================");
    }
    public static void multiplyArray(){
        int [] arr =  {1,5,3,2,11,4,5,2,4,8,9,2};
        int length = arr.length;
        for (int i=0;i<length;i++){
            if(arr[i]<6){
                arr[i]=arr[i]*2;
            }
        }
        System.out.println(Arrays.toString((arr)));
        System.out.println("======================");
    }
    public static void array2D(){
        int rows =4;
        int cols =4;
        int [][] matrix = new int [rows][cols];

        //left to right diagonal
        for (int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i==j){
                    matrix[i][j]=1;
                }
                else if ((i+j)==(rows-1)){
                    matrix[i][j]=6;
                }
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        // System.out.println(Arrays.deepToString(matrix));
    }
    public static int[] createArray(int len, int initialValue){
        int [] array = new int [len];

        /*
        for (int i=0;i<len;i++){
            array[i]=initialValue;
        }
        */
        Arrays.fill(array,initialValue);
        return array;
    }
    public static void  minMaxArray(){
        int [] arr = {1,3,3,2,-1};
        int max =arr[0];
        int min=arr[1];
        int length = arr.length;
        for (int i =0;i<length;i++)  {
            if(max<arr[i]){
                max=arr[i];
            }
            if (min>arr[i]){
                min=arr[i];
            }
        }
        System.out.print("max="+ max+"|");
        System.out.println("min="+min);
    }
    /*
    similar to find pivot index https://leetcode.com/problems/find-pivot-index/
    --compute sum of all elements
     - - - compute leftsum ==sum -leftsum
     */
    public static boolean isLeftEqualRight(int[]arr){
        boolean isEqual = false;
        int length = arr.length;
        int sum =0;
        int leftSum=0;

        if (length<2)return isEqual;
        //calculate sum of whole array
        for (int i=0;i<length;i++){
            sum+=arr[i];
        }
        for (int i=0;i<length;i++){
            leftSum+=arr[i];

            if(leftSum==sum-leftSum){
                isEqual=true;
            }
        }
        // System.out.println("isEqual "+ isEqual);
        return isEqual;
    }

    //1.outer loop for the numOfRotations;2. inner loop for <arr.length-1 ; shift elements arr[j]=arr[j+1]
    public static int [] rotateArrayLeft(int[] arr, int numberOfRotations){
        int length=arr.length;
        for(int i=0;i<numberOfRotations;i++){
            //store first el
            int first=arr[0];
            for (int j=0;j<length-1;j++){
                arr[j]=arr[j+1];
            }
            arr[length-1]=first; //store first element
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
    //1. outer loop for numOfRotations 2. inner loop from end length-1 till 0 ; arr[j]=arr[j-1]
    public static int[] rotateArrayRight(int[]arr,int numberOfRotations){
        int length =arr.length;
        for(int i=0;i<numberOfRotations;i++){
            //store last el
            int last=arr[length-1];
            for(int j=length-1; j>0;j--){
                arr[j]=arr[j-1];
            }
            arr[0]=last;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
    public static int [] rotateArray(int[] arr, int numberOfRotations){
        if(arr.length<2) return arr;
        if(numberOfRotations>0){
            arr=  rotateArrayLeft(arr,numberOfRotations);
        }
        else{
            numberOfRotations=Math.abs(numberOfRotations);
            arr=rotateArrayRight(arr,numberOfRotations);
        }
        return arr;
    }
    public static void main (String args[]){
        replaceZero();
        fillArray();
        multiplyArray();
        array2D();
        createArray(10,5);
        minMaxArray();
        int []arr = {1,2,3};
        isLeftEqualRight(arr);
        int[] array = {10,20,30,40};
        rotateArray(array,2); //array modified in place
        rotateArray(array,-1);
        //test();
    }
    public static void test(){
        int [] arr = {1,2,2}; //false
        int []arr1 = {2,2,2,1,2,2,10,1}; //true
        int [] arr2 ={0};//false
        int []arr3={1,1};//true
        System.out.println(isLeftEqualRight(arr));
        System.out.println(isLeftEqualRight(arr1));
        System.out.println(isLeftEqualRight(arr2));
        System.out.println(isLeftEqualRight(arr3));
    }
}

