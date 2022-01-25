package temp;

import java.util.*;

public class ShiftZeroes {
    public static void main (String args[]){
        int [] arr={1,2,0,3,0,12,0};
        shiftZeroesLeft(arr);
        shiftZeroesRight(arr);
    }
    //to shift LEFT start from the end
    public static int [] shiftZeroesLeft(int[] arr){
        int length=arr.length;
        int j=length-1;
        for(int i=length-1;i>=0;i--) {
            if (arr[i] != 0) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j--;
            }
        }
        System.out.println("Left shift "+Arrays.toString(arr));
        return arr;
    }

    public static int [] shiftZeroesRight(int[]arr){
        int length=arr.length;
        int j=0;
        for (int i=0;i<length;i++){
            if(arr[i]!=0){
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
                j++;
            }
        }
        System.out.println("Right shift " +Arrays.toString(arr));
        return arr;
    }
}
