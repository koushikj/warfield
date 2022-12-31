package com.warfield.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MedianOfTwoArrays {
    public static void main(String[] args) {
        MedianOfTwoArrays medianOfTwoArrays = new MedianOfTwoArrays();
        System.out.println(medianOfTwoArrays.findMedianFromUnSortedArrays(new int[]{1,2,3},new int[]{3,4}));
        System.out.println(medianOfTwoArrays.findMedianFromUnSortedArrays(new int[]{1,3},new int[]{2}));
        System.out.println(medianOfTwoArrays.findMedianFromUnSortedArrays(new int[]{1,2,3,4},new int[]{5,6,7,8,9,10}));
        System.out.println(medianOfTwoArrays.findMedianFromSortedArraysMethod1(new int[]{1,3},new int[]{2}));
        System.out.println(medianOfTwoArrays.findMedianFromSortedArraysMethod2(new int[]{1,3},new int[]{2}));
    }


    private double findMedianFromSortedArraysMethod2(int[] ints, int[] ints1) {
        int[] mergeArrays = mergeArrays(ints,ints1);
        Arrays.sort(mergeArrays);
        int totalLength = mergeArrays.length;
        if (totalLength %2!=0){
            int medianPosition = ((totalLength+1)/2)-1;
            return mergeArrays[medianPosition];
        }else{
            int medianPosition1 = (totalLength/2)-1;
            int medianPosition2 = (totalLength/2);
            int num1 = mergeArrays[medianPosition1];
            int num2 = mergeArrays[medianPosition2];
            return (num1+num2)/2.0;
        }
    }

    private int[] mergeArrays(int[] array1, int[] array2) {
        int[] joinedArray = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, joinedArray, 0, array1.length);
        System.arraycopy(array2, 0, joinedArray, array1.length, array2.length);
        return joinedArray;
    }

    private static List<Integer> mergeAndSortArrays(int[] nums1, int[] nums2) {
        List<Integer> ints = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> ints2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        ints.addAll(ints2);
        ints.sort(Comparator.comparingInt(o -> o));
        System.out.println(ints);
        return ints;
    }

    private double findMedianFromSortedArraysMethod1(int[] nums1, int[] nums2) {
        List<Integer> integerList = mergeAndSortArrays(nums1, nums2);
        int totalLength = integerList.size();
        if (totalLength %2!=0){
            int medianPosition = ((totalLength+1)/2)-1;
            return integerList.get(medianPosition);
        }else{
            int medianPosition1 = (totalLength/2)-1;
            int medianPosition2 = (totalLength/2);
            int num1 = integerList.get(medianPosition1);
            int num2 = integerList.get(medianPosition2);
            return (num1+num2)/2.0;
        }
    }

    public double findMedianFromUnSortedArrays(int[] nums1, int[] nums2) {
        double result=0;
        int totalLength = nums1.length+nums2.length;
        if (totalLength%2!=0){
            int medianPosition = ((totalLength+1)/2)-1;
            return getNumberFromPosition(nums1, nums2, medianPosition);

        }else{
            int medianPosition1 = (totalLength/2)-1;
            int medianPosition2 = (totalLength/2);
            int num1,num2;
            num1=getNumberFromPosition(nums1, nums2, medianPosition1);
            num2=getNumberFromPosition(nums1,nums2,medianPosition2);
            return (num1+num2)/2.0;
        }
    }

    private static int getNumberFromPosition(int[] nums1, int[] nums2, int medianPosition1) {
        if (medianPosition1 < nums1.length){
            return nums1[medianPosition1];
        }else{
            return nums2[medianPosition1 - nums1.length];
        }
    }
}
