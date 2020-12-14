package _10_字符串_APPS.Palindrome;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name: Leetcode
 * Package Name: _10_字符串_APPS.Palindrome
 * File Name: _1177_Can_Make_Palindrome_from_Substring
 * Creator: Jipeng Chen
 * Date: 6/19/20
 * Description: finish 1177
 */
public class _1177_Can_Make_Palindrome_from_Substring {

    // Solution1: prefix count
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        // time: O(l + n), l = s.length(), 43.84%
        // space: O(26*l), n = queries.length, 48.55%
        // step1: count preSum for each character
        int[][] count = new int[s.length() + 1][26];
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i - 1].clone();
            count[i][s.charAt(i - 1) - 'a']++;
        }
        // step2: generate ans
        List<Boolean> res = new ArrayList<>();
        for (int[] q: queries) {
            int odd = 0;
            for (int i = 0; i < 26; i++) {
                odd += (count[q[1] + 1][i] - count[q[0]][i]) % 2;
            }
            res.add(odd / 2 <= q[2]);
        }
        return res;
    }

    // Solution2: prefix xor, optimized using bit and XOR
    public List<Boolean> canMakePaliQueries2(String s, int[][] queries) {
        // time: O(l + n), l = s.length(), 92.75%
        // space: O(l), n = queries.length, 84.95%
        // step1: count prefix xor for each character
        int[] odds = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            odds[i + 1] = odds[i] ^ (1 << s.charAt(i) - 'a');
        }
        // step2: generate ans
        List<Boolean> res = new ArrayList<>();
        for (int[] q: queries) {
            int odd = Integer.bitCount(odds[q[1] + 1] ^ odds[q[0]]);
            res.add(odd / 2 <= q[2]);
        }
        return res;
    }
}
