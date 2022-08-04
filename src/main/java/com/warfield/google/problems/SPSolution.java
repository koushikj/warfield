package com.warfield.google.problems;

public class SPSolution {
    public static void main(String[] args) {
        int[][] ip={{0, 1, 0, 0}, {0, 1, 0, 1}, {0, 1, 0, 0}, {0, 0, 0, 0}};
        System.out.println(solution(ip));
    }
    /*
    {0, 1, 0, 0},
    {0, 1, 0, 0},
    {0, 1, 0, 0},
    {0, 0, 0, 0}}
     */
    public static int solution(int[][] map) {
        int length=0;
        int k=0;
        for (int i=0;i<map.length;i++){
            int[] ar=map[i];
            for (int j=k;j<ar.length;j++){
                if(ar[j]==0){
                    length=length+1;
                    k=j;
                }else{
                    k=j-1;
                    break;
                }
            }
        }
        return length;
    }
}
