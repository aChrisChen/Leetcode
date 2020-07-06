package _10_字符串_APPS.Subsequence._392_Is_Subsequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Project Name: Leetcode
 * Package Name: _10_字符串_APPS.Subsequence._392_Is_Subsequence
 * File Name: Solution
 * Creator: Jipeng Chen
 * Date: 7/6/20
 * Description: finish
 */
public class Solution {

    // solution 1
    public boolean isSubsequence1(String s, String t) {
        // time: O(T), T=t.length(), 33.99%
        // space: O(T)
        return helper(s, 0, t, 0);
    }

    private boolean helper(String s, int i, String t, int j) {
        // base case
        if (i == s.length()) return true;
        if (j == t.length()) return false;
        // recursive
        if (s.charAt(i) == t.charAt(j)) i++;
        j++;
        return helper(s, i, t, j);
    }

    // solution 2
    public boolean isSubsequence2(String s, String t) {
        // time: O(T), T = t.length(), 30.43%
        // space: O(1), 99.39%
        if (s == null || s.length() == 0) return true;
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    // solution 3:
    // optimized for a lot of inputs S
    public boolean isSubsequence3(String s, String t) {
        // time: O(T + SlogT), S=s.length(), 33.99%
        // space: O(256 + T), T=t.length(), 30.96%
        // step1: precomputation
        List<Integer>[] idx = new List[256];
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (idx[ch] == null) {
                idx[ch] = new ArrayList<>();
            }
            idx[ch].add(i);
        }
        // step2: compute match
        int leastMatchIdx = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (idx[ch] == null) return false; // char of S does not exist in T
            int j = Collections.binarySearch(idx[ch], leastMatchIdx);
            if (j < 0) j = -j - 1;
            if (j == idx[ch].size()) return false; // there is no valid index
            leastMatchIdx = idx[ch].get(j) + 1;
        }
        return true;
    }

    // solution 4:
    public boolean isSubsequence(String s, String t) {
        // time: O(m * n) 5.70%
        // space: O(m * n) 34.05%
        int m = s.length(), n = t.length();
        if (m == 0) return true;
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
            if (dp[m][j] == m) {
                return true;
            }
        }
        return false;
    }

}
