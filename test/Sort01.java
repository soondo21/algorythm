package test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Sort01 {

    // Complete the insertionSort1 function below.
    static void insertionSort1(int n, int[] arr) {
        int curIndex = n-1;
        int temp = arr[curIndex];
        
        while(true){
            if(curIndex == 0) {
                arr[curIndex] = temp;
                printArr(arr);
                break;
        
            } else if(arr[curIndex-1] > temp){
                // if(curIndex-1 == 0){
                //     arr[curIndex] = arr[curIndex-1];
                //     arr[curIndex-1] = temp;
                //     printArr(arr);
                //     break;
                // }
                arr[curIndex] = arr[curIndex-1];
                curIndex = curIndex-1;
                printArr(arr);
                System.out.println();
            } else {
                arr[curIndex] = temp;
                printArr(arr);
                // curIndex = curIndex-1;
                break;
            }
        }
        
    }
    
    static private void printArr(int[] arr) {
        for(int i =0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        insertionSort1(n, arr);

        scanner.close();
    }
}
