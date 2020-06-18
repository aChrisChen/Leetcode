题目链接: [415. Add Strings](https://leetcode.com/problems/add-strings/)

常见且基础。这个标准答案写的真的很好！！！

数据结构：
1. StringBuilder sb
    - 存储答案
2. int i，j
    - 用于 num1 和 num2 的双指针
3. int carry
    - 表示当前进位是多少

思路：
    1. 只要 i >= 0 || j >= 0 || carry == 1，就从后往前加


注意：
1. 我们可以把 3 个 && 的 while 可以转换成 || 的 while 和 if，这样更简洁
原来的三个
    - while (i >= 0 && j >= 0)
    - while (i >= 0) 
    - while (j >= 0)
    - 变成 while (i >= 0 || j >= 0 || carry == 1)
2. 两个数字的长度可能不一样
