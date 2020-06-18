package _8_字符串_String.基础and实现._58_Length_of_Last_Word;

/**
 * Project Name: Leetcode
 * Package Name: _8_字符串_String.基础and实现._58_Length_of_Last_Word
 * File Name: Solution
 * Creator: Jipeng Chen
 * Date: 6/18/20
 * Description: finish
 */
public class Solution {
    // 法一：利用split
    public int lengthOfLastWord1(String s) {
        // time: O(n) 52.37%
        // space: O(n) 99.97%
        String[] strs = s.split(" ");
        if (strs.length == 0) return 0;
        return strs[strs.length - 1].length();
    }

    // 法二：利用单指针
    public int lengthOfLastWord(String s) {
        // time: O(n) 100%
        // space: O(1) 99.97%
        if (s == null || s.length() == 0) return 0;
        int j = s.length() - 1;
        while (j >= 0 && !Character.isLetter(s.charAt(j))) {
            j--;
        }
        int end = j;
        while (j >= 0 && Character.isLetter(s.charAt(j))) {
            j--;
        }
        return end - j;
    }
}
