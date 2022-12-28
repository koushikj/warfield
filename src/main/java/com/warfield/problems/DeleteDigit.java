package com.warfield.problems;

public class DeleteDigit {
    public static void main(String[] args) {
        DeleteDigit deleteDigit = new DeleteDigit();
        System.out.println(deleteDigit.solution(15958));
        System.out.println(deleteDigit.solution(-5859));
        System.out.println(deleteDigit.solution(-5000));
        System.out.println(deleteDigit.solution(-5000));
    }

    public int solution(int N) {
        // Implement your solution here
        String input = Integer.toString(N);
        String output = "";
        if (N>0){
            int firstIndexOf5 = input.indexOf('5');
            output=input.substring(0,firstIndexOf5)+input.substring(firstIndexOf5+1);
        }else{
            int lastIndexOf5 = input.lastIndexOf('5');
            output=input.substring(0,lastIndexOf5)+input.substring(lastIndexOf5+1);
        }
        return Integer.parseInt(output);
    }
}
