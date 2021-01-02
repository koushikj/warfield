package com.warfield.dynamicProgramming;

/*
    for a given input n and an array arr , find subset of arr that gives sum n
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ArraySubsetProblem {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        ArrayList<Integer> arrayList = new ArrayList<>();
//
        int n=9;
        int[] arr = {1,1,4,5,1,4,3,2,2,5,6,8,9};

        HashSet<List<Integer>> result = new HashSet<>();
        for (int i=0;i< arr.length-1;i++) {
            int sum=0;
            List<Integer> output = new ArrayList<>();
            for (int j=i;j< arr.length-1;j++) {
                if (sum == n) {
                    result.add(output);
                    break;
                }
                if (!(sum + arr[j] > n)) {
                    sum = sum + arr[j];
                    output.add(arr[j]);
                }
            }
        }
        System.out.println(result);
    }
}
