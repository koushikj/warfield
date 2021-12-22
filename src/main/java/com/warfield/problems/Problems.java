package com.warfield.problems;

import java.util.*;

public class Problems {
    public static void main(String[] args) {
        /* 1. find the no of matches problem*/
        int[] input = {1, 5, 3, 1, 5};
        System.out.println("sockMerchant:" + sockMerchant(5, input));

        /* 2. compare triplet problem*/
        System.out.println("compareTriplets:" + compareTriplets(Arrays.asList(1, 2, 3), Arrays.asList(3, 2, 1)));

        /* 3. Diagonal difference of a matrix */
        List<List<Integer>> iList = new ArrayList<>();
        List<Integer> jList1 = Arrays.asList(11, 2, 4);
        List<Integer> jList2 = Arrays.asList(4, 5, 6);
        List<Integer> jList3 = Arrays.asList(10, 8, -12);
        iList.add(jList1);
        iList.add(jList2);
        iList.add(jList3);
        System.out.println((iList));
        System.out.println(diagonalDifference(iList));

        /* 4. find fractions of +ve, -ve and zero values*/
        plusMinus(new int[]{1, 2, 3, -2, -3, 0, 1, 3, 0, 0, -3});

        /* 5. print stair case */
        staircase(5);

        /* 6. find min and max of 4 values in an array */
        //miniMaxSum(new int[]{9,7,12,4,6,1});
        miniMaxSum(new int[]{1, 2, 3, 4, 5});

        /* 7. find the no of tallest candles */
        System.out.println(birthdayCakeCandles(Arrays.asList(3, 2, 1, 3)));

        /* 8. convert time to 24 hr format */
        System.out.println(timeConversion("12:05:45AM"));

        /* 9. find pairs that satisfy the given difference target value */
        System.out.println(pairs(2, new int[]{1, 5, 3, 4, 2}));

        /* 10. balanced sum */
        System.out.println(balancedSums(Arrays.asList(1, 2, 1, 3, 3, 0, 0, 0, 0, 0, 0, 1, 10)));

        /* 11. max mod sum*/
        System.out.println(maximumSum(new long[]{1,5,9},5));

        /* 12. grading problem */
        System.out.println(gradingStudents(Arrays.asList(73,67,38,33)));

        /* 13. countApplesAndOranges */
        countApplesAndOranges(7,11,5,15,new int[]{-2,2,1},new int[]{5,-6});

        /* 14. kangaroo */
        System.out.println(kangaroo(0,3,4,2));

        oddEvenStringChar("helloworld");


        findMaxHit(Arrays.asList(1,4,4,4,5,3));

        System.out.println(Arrays.toString(new byte[1]));
    }

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int count = 0;
        List<Integer> socks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (socks.contains(ar[i])) {
                count++;
                socks.remove(Integer.valueOf(ar[i]));
            } else {
                socks.add(ar[i]);
            }
        }
        return count;
    }

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> op = new ArrayList<>();
        int aCount = 0, bCount = 0;
        for (int i = 0; i < 3; i++) {
            if (a.get(i) > b.get(i)) {
                aCount++;
            } else if (b.get(i) > a.get(i)) {
                bCount++;
            }
        }
        op.add(aCount);
        op.add(bCount);
        return op;
    }

    // Complete the aVeryBigSum function below.
    static long aVeryBigSum(long[] ar) {
        long sum = 0;
        for (long a : ar) {
            sum = sum + a;
        }
        return sum;
    }

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        int aCount = 0;
        int bCount = 0;
        int size = arr.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    aCount = aCount + arr.get(i).get(i);
                }
                if (i + j == size - 1) {
                    //System.out.printf("-- %d,%d\n",i,j);
                    bCount = bCount + arr.get(i).get(j);
                }
            }
        }

        //System.out.println(aCount);
        //System.out.println(bCount);
        return Math.abs(aCount - bCount);
    }

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int pCount = 0, nCount = 0, zeroCount = 0;
        for (int i : arr) {
            if (i > 0) {
                pCount++;
            } else if (i < 0) {
                nCount++;
            } else {
                zeroCount++;
            }
        }
        //System.out.printf("%d,%d,%d \n",pCount,nCount,zeroCount);
        System.out.printf("%f\n%f\n%f\n", (double) pCount / arr.length, (double) nCount / arr.length, (double) zeroCount / arr.length);
    }

    // Complete the staircase function below.
    static void staircase(int n) {
        char[] arr = new char[n];
        Arrays.fill(arr, ' ');
        for (int i = 1; i <= n; i++) {
            arr[n - i] = '#';
            System.out.println(arr);
        }
    }


    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        Arrays.sort(arr);
        long min = 0, max = 0;
        for (int i = 0; i < 4; i++) {
            min = min + arr[i];
        }
        for (int i = arr.length - 1; i >= arr.length - 4; i--) {
            max = max + arr[i];
        }
        System.out.printf("%d %d\n", min, max);
    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        int maxItemCount = 0;
        Collections.sort(candles);
        int match = candles.get(candles.size() - 1);
        for (int i = candles.size() - 1; i >= 0; i--) {
            if (candles.get(i) == match) {
                maxItemCount++;
            } else {
                break;
            }
        }
        return maxItemCount;
    }

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        boolean am = s.contains("AM");
        String op;
        int hour;
        String[] split = s.split(":");
        hour = Integer.parseInt(split[0]);
        if (!am) {//pm
            hour = (hour == 12) ? hour : hour + 12;
            op = hour + ":" + split[1] + ":" + split[2].substring(0, 2);
        } else {//am
            hour = (hour == 12) ? 0 : hour;
            String hourString;
            if (hour < 10) {
                hourString = "0" + hour;
            } else {
                hourString = String.valueOf(hour);
            }
            op = hourString + ":" + split[1] + ":" + split[2].substring(0, 2);
        }
        return op;
    }

    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        for (int i : set) {
            if (set.contains(i + k)) {
                result++;
            }
        }
        return result;
    }

    // Complete the balancedSums function below.
    static String balancedSums(List<Integer> arr) {
        if (arr.size() == 1)
            return "YES";
        for (int i = 0; i < arr.size(); i++) {
            int sumL = 0;
            int sumR = 0;
            int p1 = i + 1;
            int p2 = i - 1;
            for (int j = i + 1; j < arr.size(); j++) {
                sumL = sumL + arr.get(j);
            }
            for (int j = i - 1; j >= 0; j--) {
                sumR = sumR + arr.get(j);
            }
            if (sumL == sumR) {
                return "YES";
            }
        }
        return "NO";
/*
//efficient solution

//            let's denote a middle integer with y and both
//            right and left side as x because there sum is same. Now the equation will look like ->
//            1) x + y + x = sum of array
//            2) 2x + y = sum
//            3) 2x = sum - y

        int x = 0;
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }

        for (int y : arr) {
            if (2 * x == sum - y) {
                return "YES";
            }
            x = x + y;
        }
        return "NO";*/
    }

    // Complete the maximumSum function below.
    static long maximumSum(long[] a, long m) {
        long maxModSum=0;
        for (int i=0;i<a.length;i++){
            long sum=a[i];
            for (int j=i+1;j<a.length;j++){
                sum=sum+a[j];
                if(sum%m>maxModSum){
                    maxModSum=sum%m;
                }
            }
        }
        return maxModSum;
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        System.out.println(grades);
        List<Integer> result = new ArrayList<>();
        for (int i : grades) {
            if (i < 38) {
                result.add(i);
            } else {
                int modDiff=5-(i%5);
                if(modDiff<3){
                    result.add(i+modDiff);
                }else{
                    result.add(i);
                }
            }
        }
        return result;
    }

    // Complete the countApplesAndOranges function below.
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int aCount=0;
        for (int d:apples){
            if((a+d)>=s && (a+d)<=t){
                aCount++;
            }
        }
        int OCount=0;
        for (int d:oranges){
            if((b+d)>=s && (b+d)<=t){
                OCount++;
            }
        }
        System.out.println(aCount);
        System.out.println(OCount);
    }

    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {
        for(int i=0;i<10;i++){
            int op1=(i*v1)+x1;
            int op2=(i*v2)+x2;
            System.out.println("k1:"+op1);
            System.out.println("k2:"+op2);
        }

        int op1=x1;
        int op2=x2;
        if(op1<=op2){
            int i=1;
            while (op1<op2){
                op1=(i*v1)+x1;
                op2=(i*v2)+x2;
                i++;
            }
            if(op1==op2){
                return "YES";
            }
        }else{
            int i=1;
            while (op1>op2){
                op1=(i*v1)+x1;
                op2=(i*v2)+x2;
                i++;
            }
            if(op1==op2){
                return "YES";
            }
        }

        return "NO";

    }

    private static void oddEvenStringChar(String s){
        if(!s.isEmpty()){

        }
        char[] chars = s.toCharArray();
        String odd = new String();
        String even = new String();
        for(int i=0;i<chars.length;i++){
            if(i%2==0){
                even=even+chars[i];
            }else{
                odd=odd+chars[i];
            }
        }
        System.out.println(odd);
        System.out.println(even);
    }

    private static void findMaxHit(List<Integer> arr){
        SortedMap<Integer,Integer> op = new TreeMap<>();
        for(int i : arr){
            if(op.containsKey(i)){
                int val = op.get(i);
                val++;
                op.put(i,val);
            }else{
                op.put(i,1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entries = op.entrySet();
        int maxHitValue=0;
        int maxKey=0;
        for(Map.Entry<Integer,Integer> entry: entries){
            //System.out.println(entry.getKey());
            //System.out.println(entry.getValue());
            if(entry.getValue()>maxHitValue){
                maxHitValue=entry.getValue();
                maxKey=entry.getKey();
            }
        }
        System.out.println(maxHitValue);
        System.out.println(maxKey);
        System.out.println(op);

        // or elegant solution
        System.out.println(Collections.max(op.entrySet(),Map.Entry.comparingByValue()).getKey());
    }
}
