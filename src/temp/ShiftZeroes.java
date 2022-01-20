package temp;

import java.util.*;

public class ShiftZeroes {
    public static void main (String args[]){
        int [] arr={1,2,0,3,0};
        shiftZeroesLeft(arr);
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
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
