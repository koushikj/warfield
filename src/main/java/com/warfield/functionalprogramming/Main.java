package com.warfield.functionalprogramming;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(12,2,3);
        printOddNumbers(integerList);
    }

    private static void printOddNumbers(List<Integer> integerList) {
        integerList.stream()
                .filter(number -> number%2!=0)
                .forEach(System.out::println);
    }
}
