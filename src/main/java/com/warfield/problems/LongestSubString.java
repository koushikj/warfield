package com.warfield.problems;

import java.util.Set;
import java.util.HashSet;

public class LongestSubString {
    public static void main(String[] args) {
        LongestSubString longestSubString = new LongestSubString();
        longestSubString.lengthOfLongestSubstring("abcabcbb");
        longestSubString.lengthOfLongestSubstring("bbbbb");
        longestSubString.lengthOfLongestSubstring("pwwkew");
        longestSubString.lengthOfLongestSubstring("aab");
        longestSubString.lengthOfLongestSubstringMethod2("dvdf");
        longestSubString.lengthOfLongestSubstringMethod2("vvdvvf");
    }

    private int lengthOfLongestSubstringMethod2(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> characterSet = new HashSet<>();
        while (j < s.length()) {
            if (!characterSet.contains(s.charAt(j))) {
                characterSet.add(s.charAt(j++));
                max = Math.max(max, characterSet.size());
            } else {
                System.out.println(characterSet);
                characterSet.remove(s.charAt(i++));
            }
        }
        System.out.println(max);
        System.out.println(characterSet);
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int maxLength = 0;
        Set<Character> characterSet = new HashSet<>();
        for (char c : chars) {
            if (characterSet.contains(c)) {
                if (characterSet.size() > maxLength) {
                    maxLength = characterSet.size();
                }
                System.out.println(characterSet);
                characterSet.clear();
                characterSet.add(c);
            } else {
                characterSet.add(c);
            }
        }
        if (characterSet.size() > maxLength) {
            maxLength = characterSet.size();
            System.out.println(characterSet);
        }
        System.out.println(maxLength);
        return maxLength;
    }
}
