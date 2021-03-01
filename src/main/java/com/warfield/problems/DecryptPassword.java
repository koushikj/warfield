package com.warfield.problems;

public class DecryptPassword {
    public static void main(String[] args) {
        //encryptPassword("");
        System.out.println(encryptPassword("aP5pL1e"));
        System.out.println(decryptPassword("51Pa*0Lp*0e"));
    }

    private static String decryptPassword(String s) {
        int i=0;
        char[] chars = s.toCharArray();
        while (i< chars.length){
            char c = chars[i];
            if (chars[i]=='0'){
                chars=insertCharacter(chars,i);
                chars = String.valueOf(chars).replaceFirst("0", "").toCharArray();
                //i++;
            } else if (chars[i]=='*'){
                char a = chars[i-1];
                chars[i-1]=chars[i-2];
                chars[i-2]=a;
                chars = String.valueOf(chars).replaceFirst("\\*", "").toCharArray();
            }else{
                i++;
            }
        }
        return String.valueOf(chars);    }

    private static char[] insertCharacter(char[] chars, int k) {

        char first = chars[0];
        String x = String.valueOf(chars);
        x = x.substring(1, k) + first + x.substring(k);

/*        char[] op = new char[chars.length];
        for(int i=1;i< chars.length;i++){
            if(i==k){
                op[k-1]=first;
            }else{
                op[i-1]=chars[i];
            }
        }*/
        return x.toCharArray();
    }

    public static String encryptPassword(String s) {
        // Write your code here
        int i=0;
        char[] chars = s.toCharArray();
        while (i<s.length()){
            if (Character.isLowerCase(chars[i]) && Character.isUpperCase(chars[i+1])){
                //swap
                char a = chars[i];
                chars[i]=chars[i+1];
                chars[i+1]=a;
                i=i+2;
            }else if (Character.isDigit(chars[i])){
                char a = chars[i];
                chars[i]=0;
                chars = shiftCharArray(chars,a);
                i=i+1;
            }else{
                i=i+1;
            }
        }
        return String.valueOf(chars);
    }

    private static char[] shiftCharArray(char[] chars, char a) {
        char[] op = new char[chars.length+1];
        op[0]=a;
        for (int i=1;i< chars.length;i++){
            op[i+1] = chars[i];
        }
        return op;
    }
}
