package _13_回溯法_Backtracking._1079_Letter_Tile_Possibilities;

/**
 * Project Name: Leetcode
 * Package Name: _13_回溯法_Backtracking._1079_Letter_Tile_Possibilities
 * File Name: Solution
 * Creator: Jipeng Chen
 * Date: 6/16/20
 * Description: finish
 */
public class Solution {
    public int numTilePossibilities(String tiles) {
        // time: O(26^n) 90.04%
        // space: O(n) 82.86%
        int[] count = new int[26];
        for (char ch : tiles.toCharArray()) count[ch - 'A']++;
        return dfs(count);
    }

    private int dfs(int[] count) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) continue;
            // case1: add current char and stop adding
            sum++;
            // case2: add current char and continue adding
            count[i]--;
            sum += dfs(count);
            count[i]++;
        }
        return sum;
    }
}
