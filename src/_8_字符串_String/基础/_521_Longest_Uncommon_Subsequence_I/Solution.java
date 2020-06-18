package _8_字符串_String.基础._521_Longest_Uncommon_Subsequence_I;

/**
 * Project Name: Leetcode
 * Package Name: _8_字符串_String.基础._521_Longest_Uncommon_Subsequence_I
 * File Name: Solution
 * Creator: Jipeng Chen
 * Date: 6/18/20
 * Description: finish
 */
public class Solution {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
