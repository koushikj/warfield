package com.warfield.problems;

import java.util.*;

public class StringSplitBasedOnDoubleQuotes
{
    public static void main(String[] args) {
        List<String> output = splitString("hi my name is \"koushik j\" im from coimbatore \"tamil nadu\" india",'"');
        List<String> output2 = splitString("im working in cisco , as a software-engineer, bangalore",',');
        System.out.println(output);
        System.out.println(output2);
    }

    private static List<String> splitString(String stringWithQuote, char splitByChar) {
        char[] charArray = stringWithQuote.toCharArray();
        List<String> outputList = new ArrayList<>();
        StringBuilder substring = new StringBuilder();
        boolean splitByCharFlag=false;
        for (char c:charArray){
            if (c == splitByChar){
                splitByCharFlag= !splitByCharFlag;
                continue;
            }
            if (c == ' ' && !splitByCharFlag){
                outputList.add(substring.toString());
                substring = new StringBuilder();
            }else{
                substring.append(c);
            }
        }
        outputList.add(substring.toString());
        return outputList;
    }
}
