package com.warfield.chatgpt;
public class RegExpMatcher {


    public static boolean match(String str, String pattern) {
        int strIndex = 0;
        int patternIndex = 0;

        while (patternIndex < pattern.length()) {
            if (strIndex >= str.length()) {
                if (patternIndex + 1 < pattern.length() && pattern.charAt(patternIndex + 1) == '*') {
                    patternIndex += 2;
                    continue;
                } else {
                    return false;
                }
            }

            if (pattern.charAt(patternIndex) == '.') {
                strIndex++;
                patternIndex++;
            } else if (pattern.charAt(patternIndex) == '*') {
                if (patternIndex == 0) {
                    return false;
                }
                char prevChar = pattern.charAt(patternIndex - 1);
                if (prevChar == '.') {
                    if (patternIndex == pattern.length() - 1) {
                        return true;
                    }
                    for (int i = strIndex; i <= str.length(); i++) {
                        if (match(str.substring(i), pattern.substring(patternIndex + 1))) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    while (strIndex < str.length() && str.charAt(strIndex) == prevChar) {
                        strIndex++;
                    }
                    patternIndex++;
                }
            } else {
                if (str.charAt(strIndex) != pattern.charAt(patternIndex)) {
                    if (patternIndex + 1 < pattern.length() && pattern.charAt(patternIndex + 1) == '*') {
                        patternIndex += 2;
                        continue;
                    } else {
                        return false;
                    }
                }
                strIndex++;
                patternIndex++;
            }
        }

        return strIndex == str.length();
    }


    public static void main(String[] args) {
        String str = "abcd";
        String pattern = "a*";
        boolean result = match(str, pattern);
        System.out.println(result);
    }
}
