package com.warfield.algorithm;

public class BS {
    public static void main(String[] args) {
        int res = search(new int[]{1,2,3,4,303,12,51,202,20,12},51);
        System.out.println(res);
    }

    public static int search(int[] nums, int target) {
        return findPosition(nums,target,nums.length/2);
    }

    private static int findPosition(int[] nums, int target, int middle) {
        int res=-1;
        if(target>nums[middle]){
            res=findPosition(nums,target,middle);
        }else if(target<nums[middle]){
            res=findPosition(nums,target,0);
        }else{
            res=middle;
        }
        return res;
    }
}
