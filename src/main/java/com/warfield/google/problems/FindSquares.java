package com.warfield.google.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSquares {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(15324)));
    }

    public static int[] solution(int area){
        List<Integer> output = new ArrayList<>();
        recursiveCal(area,output);
        int[] ints = output.stream().mapToInt(Integer::intValue).toArray();
        return ints;
    }

    private static void recursiveCal(int area, List<Integer> output) {
        if(area==0 || area <0){
            return;
        }
        int sqrtInt = (int) Math.sqrt(area);
        int squareOf = (int) Math.pow(sqrtInt,2);
        output.add(squareOf);
        int diff = area - squareOf;
        recursiveCal(diff,output);
    }
}
