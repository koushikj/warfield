package com.warfield.problems;

import java.util.*;

public class StringSplitBasedOnDoubleQuotes
{
    public static void main(String[] args) {
        List<String> output = splitString("hi my name is \"koushik j\" im from coimbatore \"tamil nadu\" india");
        System.out.println(output);
    }

    private static List<String> splitString(String stringWithQuote) {
        char[] charArray = stringWithQuote.toCharArray();
        List<String> outputList = new ArrayList<>();
        StringBuilder substring = new StringBuilder();
        boolean doubleQuoteFlag=false;
        for (char c:charArray){
            if (c == '"'){
                doubleQuoteFlag= !doubleQuoteFlag;
            }
            if (c == ' ' && !doubleQuoteFlag){
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
