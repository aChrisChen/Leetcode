题目链接：[58. Length of Last Word](https://leetcode.com/problems/length-of-last-word/)

解题思路：

非常简单的练手题！！实现题。

注意：
1. 边界情况，string的最后可能有空格！！！

    - 比如，“abc  adf      ” 应该 返回 3

2. 利用 s.split(“ ”) 函数的时候，会自动把 s 后方的空格全部 trim 掉！！

    - S = “ abc  s     ”，s.split(“ ”) = [“”, “abc”, “”, “s”]
