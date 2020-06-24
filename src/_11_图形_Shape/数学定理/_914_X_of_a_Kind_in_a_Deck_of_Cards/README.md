题目链接：[914. X of a Kind in a Deck of Cards](https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/)

参考：[lee215的回答](https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/discuss/175845/C%2B%2BJavaPython-Greatest-Common-Divisor)

intuition：
1. 如果有 2 个1 和 4 个 2，那么可以分成每组 X = 2,能分成3 组，2个1，2个2，2个2
2. 如果有8 个 1 和 12 个 2，那么可以分成每组 X = 4，能分成5组，两组4个1，三组4个2
3. 所以大概可以看出
    - 在保证每组卡片一样的前提下，每组卡片能有多少张
    - 其实就是各个数字的卡牌数量的最大公约数 Greatest Common Divisor！！！！！

思路：
1. count 得到每个 number 的数量
2. 求这些数量的 GCD
