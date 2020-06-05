package _7_栈_Stack.迭代极值._456_132_Pattern;

import java.util.Stack;

/**
 * Project Name: Leetcode
 * Package Name: _7_栈_Stack.迭代极值._456_132_Pattern
 * File Name: Solution
 * Creator: Jipeng Chen
 * Date: 6/5/20
 * Description: 132 pattern
 */
public class Solution {
    public boolean find132pattern(int[] nums) {
        // time: O(n) 74.11%
        // space: O(n) 28.57%
        int mid = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < mid) {
                return true;
            } else {
                // 把当前的 nums[i]作为 s2，寻找更大的 mid(s3)
                while(!stack.isEmpty() && nums[i] > stack.peek()) {
                    mid = stack.pop();
                }
                stack.push(nums[i]);
            }
        }
        return false;
    }
}
