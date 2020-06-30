package _3_数组题_Array.HashMap._846_Hand_of_Straights;

import java.util.Map;
import java.util.TreeMap;

/**
 * Project Name: Leetcode
 * Package Name: _3_数组题_Array.HashMap._846_Hand_of_Straights
 * File Name: Solution
 * Creator: Jipeng Chen
 * Date: 6/30/20
 * Description: TODO
 */
public class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        Map<Integer, Integer> c = new TreeMap<>();
        for (int i : hand) c.put(i, c.getOrDefault(i, 0)+1);
        for (int it : c.keySet())
            if (c.get(it) > 0)
                for (int i = W - 1; i >= 0; --i) {
                    if (c.getOrDefault(it + i, 0) < c.get(it)) return false;
                    c.put(it + i, c.get(it + i) - c.get(it));
                }
        return true;
    }
}
