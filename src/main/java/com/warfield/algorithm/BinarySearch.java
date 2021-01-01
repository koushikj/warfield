package com.warfield.algorithm;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) throws FileNotFoundException {
        int[] a ={192,182,483,893,203,31293,12,303,73,3,192,182,483,893,203,542,12,303,73,3,192,182,483,893,203,542,12,303,73,3,192,182,483,893,112112,542,12,303,73,3,192,182,483,893,203,542,12,303,73,3};
        int key=112112;
        System.out.println(a.length);
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        List<Integer> input = new ArrayList<>();
        List<Integer> queryList = new ArrayList();
        readInput(input,queryList);

    }

    private static void readInput(List<Integer> input, List<Integer> queryList) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("/Users/kojayaku/Documents/Koushik/intelij/warfield/src/main/java/com/warfield/algorithm/input.txt"));
        int size = Integer.parseInt(in.nextLine());
        System.out.println("size:"+size);
        input = convertStringArrayToIntArray(in.nextLine());
        System.out.println("input list size:"+input.size());
        int querySize = Integer.parseInt(in.nextLine());
        queryList = new ArrayList();
        for(int i=0;i<querySize;i++){
            queryList.add(Integer.parseInt(in.nextLine()));
        }
        System.out.println("querySize:"+querySize);
        System.out.println("querList Size:"+queryList.size());
        for (Integer ipKey: queryList){
            System.out.println(binarySearch(0,input.size()-1,input,ipKey));
        }
    }

    private static List<Integer> convertStringArrayToIntArray(String next) {
        System.out.println("input strings:"+next);
        String[] ip = next.split(" ");
        List<Integer> ip2 = new ArrayList();
        for (String i: ip){
            ip2.add(Integer.parseInt(i));
        }
        return ip2;
    }

    private static int binarySearch(int low, int high, List<Integer> a, int key) {
        while (low<=high){
            int mid = low + ((high - low) / 2);
            if(a.get(mid)<key){
                low=mid+1;
            }else if(a.get(mid)>key){
                high=mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
