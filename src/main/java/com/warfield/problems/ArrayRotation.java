package com.warfield.problems;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfTestCase = scanner.nextInt();
        for (int i=0;i<noOfTestCase;i++){
            int arraySize = scanner.nextInt();
            int rotateBy = scanner.nextInt();
            int[] arr = new int[arraySize];
            for (int j=0;j<arraySize;j++){
                int k = (j+rotateBy)%arraySize;
                arr[k] = scanner.nextInt();
            }
            String s = Arrays.toString(arr);
            System.out.println(s.substring(1,s.length()-1).replace(",",""));
        }
    }
}
