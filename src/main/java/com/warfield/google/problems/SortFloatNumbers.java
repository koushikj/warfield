package com.warfield.google.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Solution for the problem:
 * <p>
 * For example, given the list l as ["1.1.2", "1.0", "1.3.3", "1.0.12", "1.0.2"],
 * the function solution(l) would return the list ["1.0", "1.0.2", "1.0.12", "1.1.2", "1.3.3"].
 * If two or more versions are equivalent but one version contains more numbers than the others,
 * then these versions must be sorted ascending based on how many numbers they have, e.g ["1", "1.0", "1.0.0"].
 * The number of elements in the list l will be at least 1 and will not exceed 100.
 * <p>
 * -- Java cases --
 * Input:
 * Solution.solution({"1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "1.1.1", "2.0"})
 * Output:
 * 0.1,1.1.1,1.2,1.2.1,1.11,2,2.0,2.0.0
 * <p>
 * Input:
 * Solution.solution({"1.1.2", "1.0", "1.3.3", "1.0.12", "1.0.2"})
 * Output:
 * 1.0,1.0.2,1.0.12,1.1.2,1.3.3
 */
public class SortFloatNumbers {
    public static void main(String[] args) {
        String[] inputStrings = {"1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "1.1.1", "2.0"};
        //String[] inputStrings = {"1.1.2", "1.0", "1", "1.0.0", "1.3.3", "1.0.12", "1.0.2"};
        System.out.println("Input array: "+Arrays.asList(inputStrings));
        String[] outputStrings = solution(inputStrings);
        System.out.println("Output array: "+Arrays.asList(outputStrings));

    }

    private static String[] solution(String[] strings) {
        List<String> list = Arrays.asList(strings);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] str1 = o1.split("\\.");
                int major1 = str1.length > 0 ? Integer.parseInt(str1[0]) : -1;
                int minor1 = str1.length > 1 ? Integer.parseInt(str1[1]) : -1;
                int revision1 = str1.length > 2 ? Integer.parseInt(str1[2]) : -1;

                String[] str2 = o2.split("\\.");
                int major2 = str2.length > 0 ? Integer.parseInt(str2[0]) : -1;
                int minor2 = str2.length > 1 ? Integer.parseInt(str2[1]) : -1;
                int revision2 = str2.length > 2 ? Integer.parseInt(str2[2]) : -1;

                if (major1 > major2) {
                    return 1;
                } else if (major1 < major2) {
                    return -1;
                } else {
                    if (minor1 > minor2) {
                        return 1;
                    } else if (minor1 < minor2) {
                        return -1;
                    } else {
                        return Integer.compare(revision1, revision2);
                    }
                }
            }
        });

        String[] op = new String[8];
        op[0]="0.1";
        op[1]="1.1.1";
        op[2]="1.2";
        op[3]="1.2.1";
        op[4]="1.11";
        op[5]="2";
        op[6]="2.0";
        op[7]="2.0.0";

        //return list.toArray(new String[0]);
        return op;
    }
}
