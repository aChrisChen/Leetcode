package _11_图形_Shape.数学定理._914_X_of_a_Kind_in_a_Deck_of_Cards;

import java.util.HashMap;
import java.util.Map;

/**
 * Project Name: Leetcode
 * Package Name: _11_图形_Shape.数学定理._914_X_of_a_Kind_in_a_Deck_of_Cards
 * File Name: Solution
 * Creator: Jipeng Chen
 * Date: 6/24/20
 * Description: finish
 */
public class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        // time: O(n), we assume gcd() is of O(1), 43.96%
        // space: O(n) 97.45%
        // step1: count
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : deck) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // step2: get gcd, using euclidean algorithm
        int X = 0;
        for (int num : map.values()) {
            X = gcd(num, X);
        }
        return X >= 2;
    }

    private int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }
}
