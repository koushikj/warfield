package com.warfield.string;

public class FindLongestSubstring {
    public static void main(String[] args) {
        String[] input1={"ABAZDC","AGGTAB","aaaa"};
        String[] input2={"BACBAD","GXTXAYB","aa"};
        String[] expectedOutput={"ABAD","GTAB","aa"};
        for(int ip=0;ip<input1.length;ip++) {
            String s1 = input1[ip];
            String s2 = input2[ip];

            System.out.println("\nInputs : "+ s1+" and "+s2);
            String maxSubString = new String();

            for (int i = 0; i < s1.length(); i++) {
                String temp = new String();
                System.out.print("\nprocessing : " + s1.charAt(i) +" :: ");
                int k = i;
                for (int j = 0; j < s2.length(); j++) {
                    //System.out.println(" "+s2.charAt(j));
                    if (s1.charAt(k) == s2.charAt(j)) {
                        temp = temp + s1.charAt(k);
                        System.out.print(s1.charAt(k));
                        k++;
                        if (k >= s1.length())
                            break;
                    }
                }
                if (temp.length() > maxSubString.length())
                    maxSubString = temp;
            }

            System.out.println("\n OUTPUT : max substring : " + maxSubString +" --> "+maxSubString.equals(expectedOutput[ip]));
            System.out.println("_______________________________");
        }
    }
}
