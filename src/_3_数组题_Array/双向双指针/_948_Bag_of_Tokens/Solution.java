package _3_数组题_Array.双向双指针._948_Bag_of_Tokens;

import java.util.Arrays;

/**
 * Project Name: Leetcode
 * Package Name: _3_数组题_Array.双向双指针._948_Bag_of_Tokens
 * File Name: Solution
 * Creator: Jipeng Chen
 * Date: 6/30/20
 * Description: TODO
 */
public class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int res = 0, points = 0, i = 0, j = tokens.length - 1;
        while (i <= j) {
            if (P >= tokens[i]) {
                P -= tokens[i++];
                res = Math.max(res, ++points);
            } else if (points > 0) {
                points--;
                P += tokens[j--];
            } else {
                break;
            }
        }
        return res;
    }
}
