package com.warfield.string;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println("Enter the input String to find the palindrome substring :");
        String input = new Scanner(System.in).next();
        boolean isPalindrome = isPalindrome(input);
        if(isPalindrome){
            System.out.println("The given string is a palindrome.");
        }else{
            System.out.println("The given string is not a palindrome.");
        }
        System.out.println("Longest Palindrome Substring :"+findPalindriomeSubString(input));
    }

    private static boolean isPalindrome(String input) {
        int length = input.length();
        for(char c: input.toCharArray()){
            if(c != input.charAt(--length)){
                return false;
            }
        }
        return true;
    }

    private static String findPalindriomeSubString(String s) {
        if (s == null) return null;
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            //odd cases like 121
            String palindrome = intermediatePalindrome(s, i, i);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
            //even cases like 1221
            palindrome = intermediatePalindrome(s, i, i + 1);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
        }
        return longest;
    }
    private static String intermediatePalindrome(String s, int left, int right) {
        if (left > right) return null;
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        System.out.println("Palindrome substring :"+s.substring(left + 1, right));
        return s.substring(left + 1, right);
    }

}
