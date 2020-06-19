package _8_字符串_String.实现题._1233_Remove_SubFolders_from_the_Filesystem;

import java.util.*;

/**
 * Project Name: Leetcode
 * Package Name: _8_字符串_String.实现题._1233_Remove_SubFolders_from_the_Filesystem
 * File Name: Solution
 * Creator: Jipeng Chen
 * Date: 6/19/20
 * Description: finish 1233
 */
public class Solution {

    // Solution1: sort by length then put only parent into HashSet
    public List<String> removeSubfolders1(String[] folder) {
        // time: O(n*logn + n*m*m), n = folder.length, 98.45%
        // space: O(n*m), m = max length of str, 73.53%
        HashSet<String> set = new HashSet<>();
        Arrays.sort(folder, (a, b) -> a.length() - b.length());
        for (String f : folder) {
            boolean contained = false;
            for (int i = 2; i < f.length(); i++) {
                if (f.charAt(i) == '/' && set.contains(f.substring(0, i))) {
                    contained = true;
                    break;
                }
            }
            if (!contained) set.add(f);
        }
        return new ArrayList<>(set);
    }

    // Solution2: sort folders
    public List<String> removeSubfolders2(String[] folder) {
        // time: O(n*m*logn), n = folder.length, 65.24%
        // space: O(n*m), m = max length of a str, 71.83%
        LinkedList<String> res = new LinkedList<>();
        Arrays.sort(folder); // Note: / is smaller than a~z
        for (String f : folder) {
            if (res.isEmpty() || !f.startsWith(res.peekLast() + "/")) {
                res.add(f);
            }
        }
        return res;
    }

    // Solution3: Trie
    // O(m * n)


}
