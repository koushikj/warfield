package com.warfield.problems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].

 */
public class SmallestNonExistNumber {
    public static void main(String[] args) {
        SmallestNonExistNumber smallestNonExistNumber=new SmallestNonExistNumber();
        System.out.println(smallestNonExistNumber.solution(new int[]{1, 3, 6, 4, 1, 2}));
    }

    public int solution(int[] A) {
        int min = 1;
        List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
        for (int i=1;i<=100000;i++){
            if(!list.contains(i)){
                return i;
            }
        }
        return min;
    }
}
