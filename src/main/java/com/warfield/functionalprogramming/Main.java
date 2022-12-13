package com.warfield.functionalprogramming;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(12,2,3,-2,12,312);
        printAllumbers(integerList);
        printOddNumbers(integerList);
        printSquaresOfOddNumbers(integerList);
        System.out.println("Sum:"+printSumOfAllNumbers(integerList));
        System.out.println("Max Number:"+printMaxNumber(integerList));
        System.out.println("Min Number:"+printMinNumber(integerList));
        System.out.println("Sum of Squares:"+printSumOfSquares(integerList));
        System.out.println("Even Numbers List:"+getEvenNumbersList(integerList));

        List<String> stringList = List.of("Spring", "Spring Boot","Java","AWS");
        printStrings(stringList);
        printLengthOfStrings(stringList);
        printEachCharInStrings(stringList);
        printSortedList(stringList);
        System.out.println("Map of Strings and lengths:"+getMapOfStringAndLengths(stringList));
    }

    private static Map<String, Integer> getMapOfStringAndLengths(List<String> stringList) {
        return stringList.stream()
                .collect(Collectors.toMap(s -> s, String::length));
    }

    private static List<Integer> getEvenNumbersList(List<Integer> integerList) {
        return integerList.stream()
                .filter(n -> n%2==0)
                .collect(Collectors.toList());
    }

    private static void printSortedList(List<String> stringList) {
        stringList.stream().sorted().map(x->"-"+x).forEach(System.out::println);
        stringList.stream().sorted(Comparator.reverseOrder()).map(x->"-"+x).forEach(System.out::println);
        stringList.stream().sorted(Comparator.comparing(String::length)).map(x->"-"+x).forEach(System.out::println);
    }

    private static int printSumOfSquares(List<Integer> integerList) {
        return integerList.stream()
                .map(x->x*x)
                .reduce(0, Integer::sum);
    }

    private static int printMinNumber(List<Integer> integerList) {
        return integerList.stream()
                .reduce(Integer.MAX_VALUE,(x,y)->(x>y?y:x));
    }

    private static int printMaxNumber(List<Integer> integerList) {
        return  integerList.stream()
                .reduce(Integer.MIN_VALUE,(x,y) -> (x > y? x: y));
    }

    private static int printSumOfAllNumbers(List<Integer> integerList) {
        BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer,Integer number2) {
                return integer+number2;
            }
        };

        Integer result = integerList.stream()
                .reduce(0, binaryOperator);//.reduce(0,(x,y)->x+y);
        System.out.println("result ::"+result);

        return integerList.stream()
                .reduce(0, Integer::sum); //.reduce(0,(x,y)->x+y);
    }

    private static void printLengthOfStrings(List<String> stringList) {
        stringList.stream()
                .map(str -> str+" "+str.length())
                .forEach(System.out::println);
    }

    private static void printEachCharInStrings(List<String> stringList) {
        stringList.stream()
                .map(String::toCharArray)
                .forEach(System.out::println);
    }
    private static void printSquaresOfOddNumbers(List<Integer> integerList) {
        Predicate<Integer> integerPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return number%2!=0;
            }
        };

        Function<Integer,Integer> integerFunction = new Function<>(){
            @Override
            public Integer apply(Integer number) {
                return number*number;
            }
        };

        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer number) {
                System.out.println(number);
            }
        };

        integerList.stream()
                .filter(integerPredicate)
                .map(integerFunction)
                .forEach(consumer);

        // the below code is simplified version

        integerList.stream()
                .filter(number -> number%2!=0)
                .map(number -> number *number)
                .forEach(System.out::println);

    }

    private static void printStrings(List<String> stringList) {
        stringList.stream()
                .filter(s -> s.length()>=4)
                .forEach(System.out::println);
    }

    private static void printOddNumbers(List<Integer> integerList) {
        integerList.stream()
                .filter(number -> number%2!=0)
                .forEach(System.out::println);
    }

    private static void printAllumbers(List<Integer> integerList) {
        integerList.stream()
                .forEach(System.out::println);
    }
}
