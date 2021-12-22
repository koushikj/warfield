package com.warfield.google.problems;

public class FindLocationXY {
    public static void main(String[] args) {
        System.out.println(solution(1221, 212));
    }

    public static String solution(long x, long y) {
        System.out.println("Correct position:   "+solution2(x, y));
        return "Calculated position: " + findLocation(x, y);
    }


    /**
     * this works but throws stackoverflow error for very large numbers
     */
    private static long findLocation(long x, long y) {
        long result = 0;
        if (x <= 1 && y <= 1) {
            return 1;
        } else if (x == 1) {
            long k = y - 1;
            result = result + findLocation(x, k) + k;
        } else {
            long k = x - 1;
            result = result + findLocation(k, y) + (x+y-1);
        }
        return result;
    }


    private static String solution2(long x,long y){
        long z = ((x+y-1)*(x+y-2))/2 + x;
        return String.valueOf(z);
    }
}
