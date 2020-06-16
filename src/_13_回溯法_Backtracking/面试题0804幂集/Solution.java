package _13_回溯法_Backtracking.面试题0804幂集;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name: Leetcode
 * Package Name: _13_回溯法_Backtracking.面试题0804幂集
 * File Name: Solution
 * Creator: Jipeng Chen
 * Date: 6/16/20
 * Description: finish
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> cand, int[] nums, int idx) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(cand));
            return;
        }
        // case1: not add
        dfs(res, cand, nums, idx + 1);
        // case2: add nums[i]
        cand.add(nums[idx]);
        dfs(res, cand, nums, idx + 1);
        cand.remove(cand.size() - 1);
    }
}
