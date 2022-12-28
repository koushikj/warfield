package com.warfield.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayTransformation {

    public static void main(String[] args) {
/*        Scanner in = new Scanner(System.in);
        int a;
        a = in.nextInt();
        int b;
        b = in.nextInt();
        int sum;

        sum = addNumbers(a, b);
        System.out.println(sum);*/

        int[][] input= new int[][]{{1, 0, 3}, {2, 3, 4}, {0, 6, 7}};
        System.out.println("Input Matrix: " +Arrays.deepToString(input));
        transformMatrix(input);

    }

    private static void transformMatrix(int[][] input) {


        List<ZeroPosition> zeroList = new ArrayList<>();

        int lenX = input.length; //row
        int lenY = input[0].length; //col

        for (int i = 0; i < lenX; i++) {
            for (int j = 0; j < lenY; j++) {
                if (input[i][j] == 0) {
                    zeroList.add(new ZeroPosition(i, j));
                }
            }
        }

        for (ZeroPosition zeroPosition : zeroList) {
            for (int i = 0; i < lenX; i++) {
                for (int j = 0; j < lenY; j++) {
                    if (i == zeroPosition.x || j == zeroPosition.y) {
                        input[i][j] = 0;
                    }
                }
            }
        }
        System.out.println("Transformed Matrix: "+Arrays.deepToString(input));
    }


    static class ZeroPosition {
        int x;
        int y;

        ZeroPosition(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}