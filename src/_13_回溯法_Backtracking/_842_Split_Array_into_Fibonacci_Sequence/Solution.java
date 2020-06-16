package _13_回溯法_Backtracking._842_Split_Array_into_Fibonacci_Sequence;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name: Leetcode
 * Package Name: _13_回溯法_Backtracking._842_Split_Array_into_Fibonacci_Sequence
 * File Name: Solution
 * Creator: Jipeng Chen
 * Date: 6/16/20
 * Description: finish
 */
public class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ans = new ArrayList<>();
        helper(S, ans, 0);
        return ans;
    }

    public boolean helper(String s, List<Integer> ans, int idx) {
        if (idx == s.length() && ans.size() >= 3) {
            return true;
        }
        for (int i=idx; i<s.length(); i++) {
            if (s.charAt(idx) == '0' && i > idx) {
                break;
            }
            long num = Long.parseLong(s.substring(idx, i+1));
            if (num > Integer.MAX_VALUE) {
                break;
            }
            int size = ans.size();
            // early termination
            if (size >= 2 && num > ans.get(size-1)+ans.get(size-2)) {
                break;
            }
            if (size <= 1 || num == ans.get(size-1)+ans.get(size-2)) {
                ans.add((int)num);
                // branch pruning. if one branch has found fib seq, return true to upper call
                if (helper(s, ans, i+1)) {
                    return true;
                }
                ans.remove(ans.size()-1);
            }
        }
        return false;
    }
}
