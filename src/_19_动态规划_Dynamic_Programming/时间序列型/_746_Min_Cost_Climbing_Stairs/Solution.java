package _19_动态规划_Dynamic_Programming.时间序列型._746_Min_Cost_Climbing_Stairs;

/**
 * Project Name: Leetcode
 * Package Name: _19_动态规划_Dynamic_Programming.时间序列型._746_Min_Cost_Climbing_Stairs
 * File Name: Solution
 * Creator: Jipeng Chen
 * Date: 7/6/20
 * Description: TODO
 */
public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int step2 = cost[0];
        int step1 = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int temp = step1;
            step1 = Math.min(step2, temp) + cost[i];
            step2 = temp;
        }
        return Math.min(step1, step2);
    }
}
