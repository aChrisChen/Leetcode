package _13_回溯法_Backtracking.面试题0808有重复字符串的排列组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project Name: Leetcode
 * Package Name: _13_回溯法_Backtracking.面试题0808有重复字符串的排列组合
 * File Name: Solution
 * Creator: Jipeng Chen
 * Date: 6/16/20
 * Description: finish
 */
public class Solution {

    public String[] permutation(String S) {
        // time: O(n*n^n) 99.16%
        // space: O(n) 100%
        List<String> res = new ArrayList<>();
        if (S == null || S.length() == 0) return new String[0];
        char[] chs = S.toCharArray();
        Arrays.sort(chs);
        boolean[] used = new boolean[S.length()];
        dfs(res, new StringBuilder(), chs, used, 0);
        return res.toArray(new String[0]);
    }

    private void dfs(List<String> res, StringBuilder sb, char[] chs, boolean[] used, int idx) {
        if (idx == chs.length) {
            res.add(sb.toString());
            return;
        }
        // we must find a char to place at the index idx of the sb
        for (int i = 0; i < chs.length; i++) {
            if (used[i]) continue;
            // remove duplciate
            if (i > 0 && chs[i] == chs[i - 1] && !used[i - 1]) {
                continue;
            }
            // use char
            sb.append(chs[i]);
            used[i] = true;
            dfs(res, sb, chs, used, idx + 1);
            sb.deleteCharAt(idx);
            used[i] = false;
        }
    }

}
