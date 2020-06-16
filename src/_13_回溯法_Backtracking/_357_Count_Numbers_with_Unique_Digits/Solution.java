package _13_回溯法_Backtracking._357_Count_Numbers_with_Unique_Digits;

/**
 * Project Name: Leetcode
 * Package Name: _13_回溯法_Backtracking._357_Count_Numbers_with_Unique_Digits
 * File Name: Solution
 * Creator: Jipeng Chen
 * Date: 6/16/20
 * Description: finish
 */
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        while (n-- > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            res += uniqueDigits;
            availableNumber--;
        }
        return res;
    }
}
