# [1686. Stone Game VI](https://leetcode.com/problems/stone-game-vi/)


参考：[lee215的回答](https://leetcode.com/problems/stone-game-vi/discuss/969574/JavaC%2B%2BPython-Sort-by-Value-Sum)

[acme的回答](https://leetcode.com/problems/stone-game-vi/discuss/969635/math-proof)

Intuition:

1. 对于Alice而言，什么才是最优的决策吗？是优先选择自己能得到的最大值吗？并不是，通过这个例子就可以看出来：
   
```
Alice: 1 2
Bob:   3 1
```

2. 如果Alice优先选择第二个元素的话，那么Bob选择第一个元素反而会有更高的总分。于是我们显然发现，对于Alice而言，每一步的决策不仅要使自己的得分高，而且需要使对手的得分低。对于Alice而言，如果选择了第二个元素，那么Alice得了2分，Bob失去了一个得1分的机会，这一反一正差距是3分。同理，对于Bob而言，如果选择了第一个元素，那么自己得了3分，Alice失去了一个得1分的机会，这一反一正就是4分。
2. 所以，不管对哪个选手而言，一个元素的价值其实体现在了这个一反一正上。即使我自己得的分少，如果能让你失去了得高分的机会，也是一个成功的策略。

思路： 

1. 所以本题的算法很简单，将所有元素按照AliceValues[i]+BobValues[i]的大下排列。然后Alice和Bob轮流选取，对它们而言就是最优的决策。

Proof of why $a_i + b_i$ is critical:

1. Let your valuations be ${a_1, a_2, ..., a_n}$ and your opponent's valuations be ${b_1, b_2, ..., b_n}$. (In this analysis, I am making no assumption about whether you or your opponent goes first.)
2. Suppose you choose stones $i_1, i_2, ...$ and your opponent chooses stones $j_1, j_2, ....$ Let 
   $$X = a_{i_1} + a_{i_2} + ... - b_{j_1} - b_{j_2} - ...$$
3. Then you win if X > 0, you lose if X < 0, and you draw if X = 0. X can be re-arranged as 
   $$X = (a_{i_1} + b_{i_1}) + (a_{i_2} + b_{i_2}) + ... - (b_1 + b_2 + ... + b_n)$$
   , where $b_1 + b_2 + ... + b_n$ is a constant over all game strategies; it is the sum of your opponent's valuations.
4. Therefore, you win if you select indices i so that the sum of the (a_i+b_i) over all your selected indices minus the sum of all your opponents valuations is positive. So it is always in your interest (and your opponent's interest on his or her turn) to select the a_i+b_i available with the largest value to try to make this happen.

