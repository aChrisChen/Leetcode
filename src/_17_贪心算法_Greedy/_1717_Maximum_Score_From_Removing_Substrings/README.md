# [1717. Maximum Score From Removing Substrings](https://leetcode.com/problems/maximum-score-from-removing-substrings/submissions/)


参考：[lzl124631的回答](https://leetcode.com/problems/maximum-score-from-removing-substrings/discuss/1009028/C%2B%2B-Greedy-O(N)-Time-O(1)-Space)

[vikrant_pc的回答](https://leetcode.com/problems/maximum-score-from-removing-substrings/discuss/1008862/Java-Stack)

Intuition:

1. We greedily remove the pattern with greater points, then remove the other pattern.
   - For removing the pattern string recursively, we can reuse the solution to 1003. Check If Word Is Valid After Substitutions (Medium)
2. 如何证明greedy work？
   - Assume score(ab) > score(ba) but removing ba first is optimal.
   - This could only happen when the removal of a single ab prevents 2 ba removals, and score(remove ba first) > score(remove ab first) i.e. score(ba) * 2 > score(ab).
   - Only b(ab)a satisfies this requirement. But we after removing ab we can remove one ba, so we get score(ab) + score(ba) which is greater than score(ba) * 2.
   - Thus removing ba first is not optimal, the assumption is wrong.
