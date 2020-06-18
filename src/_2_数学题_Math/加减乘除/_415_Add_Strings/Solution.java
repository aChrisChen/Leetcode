package _2_数学题_Math.加减乘除._415_Add_Strings;

/**
 * Project Name: Leetcode
 * Package Name: _2_数学题_Math.加减乘除._415_Add_Strings
 * File Name: Solution
 * Creator: Jipeng Chen
 * Date: 6/18/20
 * Description: finish
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        // time: O(max(m,n)) 96.06%
        // space: O(max(m,n)) 100%
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry == 1) {
            int a = (i >= 0 ? num1.charAt(i--) - '0' : 0);
            int b = (j >= 0 ? num2.charAt(j--) - '0' : 0);
            int sum = a + b + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }
}
