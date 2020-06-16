package _13_回溯法_Backtracking.面试题0812八皇后;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name: Leetcode
 * Package Name: _13_回溯法_Backtracking.面试题0812八皇后
 * File Name: Solution
 * Creator: Jipeng Chen
 * Date: 6/16/20
 * Description: finish
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        // time: O(n^n) 73.86%
        // space: O(n + n^2*答案数) 栈空间 100%
        List<List<String>> res = new ArrayList<>();
        helper(res, new int[n], 0);
        return res;
    }

    private void helper(List<List<String>> res, int[] queens, int pos) {
        if (pos == queens.length) {
            addSolution(res, queens);
            return;
        }
        for (int i = 0; i < queens.length; i++) { // 对pos行的不同位置的queen递归
            queens[pos] = i;
            if (isValid(queens, pos)) {
                helper(res, queens, pos + 1);
            }
        }
    }

    private boolean isValid(int[] queens, int pos) { // 检查第 pos行的queen是否合理
        for (int i = 0; i < pos; i++) {
            if (queens[i] == queens[pos]) { // 同一列
                return false;
            } else if (Math.abs(queens[i] - queens[pos]) == Math.abs(i - pos)) { // 同一对角线上
                return false;
            }
        }
        return true;
    }

    private void addSolution(List<List<String>> res, int[] queens) {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < queens.length; j++) {
                if (queens[i] == j) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            solution.add(sb.toString());
        }
        res.add(solution);
    }
}