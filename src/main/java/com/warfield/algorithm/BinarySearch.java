package com.warfield.algorithm;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) throws FileNotFoundException {

        //Scanner in = new Scanner(new FileReader("/Users/kojayaku/Documents/Koushik/intelij/warfield/src/main/java/com/warfield/algorithm/input.txt"));
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> input = new ArrayList<>();
        int size = in.nextInt();
        for (int i = 0; i < size; i++) {
            input.add(in.nextInt());
        }
        Collections.sort(input);
        int querySize = in.nextInt();
        for (int i = 0; i < querySize; i++) {
            int ipKey = in.nextInt();
            System.out.println(binarySearch(0, size - 1, input, ipKey));
        }
    }


    private static int binarySearch(int low, int high, List<Integer> a, int key) {
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (a.get(mid) < key) {
                low = mid + 1;
            } else if (a.get(mid) > key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
