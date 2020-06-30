package _3_数组题_Array.HashMap._1128_Number_of_Equivalent_Domino_Pairs;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Project Name: Leetcode
 * Package Name: _3_数组题_Array.HashMap._1128_Number_of_Equivalent_Domino_Pairs
 * File Name: Solution
 * Creator: Jipeng Chen
 * Date: 6/30/20
 * Description: TODO
 */
public class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < dominoes.length; i++) {
            Arrays.sort(dominoes[i]);
            String key = Arrays.toString(dominoes[i]);
            res += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return res;
    }
}
