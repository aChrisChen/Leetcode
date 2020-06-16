package _13_回溯法_Backtracking._216_Combination_Sum_III;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name: Leetcode
 * Package Name: _13_回溯法_Backtracking._216_Combination_Sum_III
 * File Name: Solution
 * Creator: Jipeng Chen
 * Date: 6/16/20
 * Description: finish
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        // time: O(2^9) 100%
        // space: O(9) 80.16%
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> cand, int k, int n, int start) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(cand));
            return;
        }
        for (int i = start; i <= 9; i++) {
            cand.add(i);
            dfs(res, cand, k - 1, n - i, i + 1);
            cand.remove(cand.size() - 1);
        }
    }
}
