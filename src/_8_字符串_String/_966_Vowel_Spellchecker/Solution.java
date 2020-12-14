package _9_字符串_HashMap_Sliding_Wndow.HashMap._966_Vowel_Spellchecker;

import java.util.*;

/**
 * Project Name: Leetcode
 * Package Name: _9_字符串_HashMap_Sliding_Wndow.HashMap._966_Vowel_Spellchecker
 * File Name: Solution
 * Creator: Jipeng Chen
 * Date: 6/19/20
 * Description: finish
 */
public class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        // time: O(n) 25.71%
        // space: O(n) 31.73%
        // step1: init
        Set<String> words = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> cap = new HashMap<>();
        Map<String, String> vowel = new HashMap<>();
        for (String w : wordlist) {
            String lower = w.toLowerCase();
            String devowel = lower.replaceAll("[aeiou]", "#"); // 用lower来replace！保证pattern统一
            cap.putIfAbsent(lower, w); // 根据规则，以第一个match到的为准
            vowel.putIfAbsent(devowel, w);
        }
        // step2: process queries
        for (int i = 0; i < queries.length; i++) {
            if (words.contains(queries[i])) continue;
            String lower = queries[i].toLowerCase();
            String devowel = lower.replaceAll("[aeiou]", "#"); // 保证pattern统一
            if (cap.containsKey(lower)) {
                queries[i] = cap.get(lower);
            } else if (vowel.containsKey(devowel)) {
                queries[i] = vowel.get(devowel);
            } else {
                queries[i] = "";
            }
        }
        return queries;
    }


}
