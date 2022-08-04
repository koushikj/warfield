package com.warfield.google.problems.bunnies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    static int size;
    static List<Integer> ans;

    public static void main(String[] args) {
        int[][] a = {{0, 1, 1, 1, 1}, {1, 0, 1, 1, 1}, {1, 1, 0, 1, 1}, {1, 1, 1, 0, 1}, {1, 1, 1, 1, 0}};
        int[][] b = {{0, 2, 2, 2, -1}, {9, 0, 2, 2, -1}, {9, 3, 0, 2, -1}, {9, 3, 2, 0, -1}, {9, 3, 2, 2, 0}};


        int[] solution = Solution.solution(a, 3);
        System.out.println(Arrays.toString(solution));

        solution = Solution.solution(b, 1);
        System.out.println(Arrays.toString(solution));
    }

    public static int[] solution(int[][] times, int times_limit) {
        // Your code here
        int n = times.length;
        if (n <= 2 || (n != times[0].length)) {
            return new int[]{};
        }
        boolean negCycle = check(times, n);
        if (negCycle) {
            int[] ans = new int[n - 2];
            for (int i = 0; i < n - 2; i++) {
                ans[i] = i;
            }
            return ans;
        } else {
            size = 0;
            ans = new ArrayList<>();
            boolean[] visited = new boolean[n];
            visited[0] = true;
            for (int i = 1; i < n - 1; i++) {
                dfs(i, times_limit - times[0][i], times, new ArrayList<>(), visited);
            }
            if (ans.size() == 0) {
                return new int[]{};
            }
            int[] ret = new int[ans.size()];
            for (int i = 0; i < ret.length; i++) {
                ret[i] = ans.get(i);
            }
            Arrays.sort(ret);
            return ret;
        }
    }

    public static void dfs(int u, int time, int[][] times, List<Integer> list, boolean[] visited) {

        int n = times.length;
        if (time <= -999 || (u == n - 1 && time < 0) || (size == n - 2)) {
            return;
        }
        if (time >= 0 && u == n - 1) {
            if (list.size() > size) {
                ans = new ArrayList<>(list);
                size = list.size();
            }
            return;
        }
        if (visited[u]) {
            return;
        }
        visited[u] = true;
        list.add(u - 1);
        for (int v = 1; v < n; ++v) {
            if (v == u) {
                continue;
            }
            dfs(v, time - times[u][v], times, list, visited);
        }
        list.remove(list.size() - 1);
        visited[u] = false;
    }

    public static boolean check(int[][] times, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (times[i][k] + times[k][j] < times[i][j]) {
                        times[i][j] = times[i][k] + times[k][j];
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (times[i][i] < 0) {
                return true;
            }
        }
        return false;
    }
}