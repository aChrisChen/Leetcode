# [1687. Delivering Boxes from Storage to Ports](https://leetcode.com/problems/delivering-boxes-from-storage-to-ports/)

Dp + Sliding Window 相结合的一道题！！！！

参考：

- [tien-nam的回答，通俗易懂](https://leetcode.com/problems/delivering-boxes-from-storage-to-ports/discuss/969518/DP-%2B-Sliding-window-O(n)-time-and-space)
- [wisdompeak的github，解释了intuition，为啥greedy不可](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1687.Delivering-Boxes-from-Storage-to-Ports)

Intuition:
1. Greedy肯定是不行的，因为 一味的Greedy满足ship的最大的capacity，会导致同一港口的货物被分成两艘船，增加来回的次数
2. 我们先来考察一下贪心的解法为什么会有局限性。我们考察从第一个盒子开始，假设到第5个盒子为止，区间[1:5]是用一次船载的极限（考虑了盒子总数、盒子总重的约束）。
```
idx   1 2 3 4 5
port: 1 2 3 4 5 
```
在上面的例子中总共需要6段航程（包括回港）。那么为什么我们充分利用了船载极限，不见得是最优解呢？其实是和之后的行程有关系。看下面的例子：
```
idx   1 2 3 4 5 6
port: 1 2 3 4 5 5
```
如果按照之前的方案，我们需要两次船载，分别是运载[1:5]，需要6段trip，然后运载[6]，需要2段trip。总共需要 **8** 段trip。但是更优的方案是，第一次运载[1:4]，需要5段trip；第二次运载[5:6]需要2段trip，总共就是 **7** 段trip。

3. 再看题目，**其中要求所有的boxes 必须 handled in order from left  to right, 这是一个很强的可以使用DP的信号**。


数据结构：

1. int[] dp = new int[N+1]
   - dp[i] 表示 前 i 个 box 需要多少 trips 才能完全送完
2. 对于 dp[i], 如果把新的货物加入进去，我们是用新的船，或者加入最后一艘船，所以我们需要知道最后一艘船的情况
   - int i, j，表示最后一艘船上的货物的 index 的 range是 [i, j]
   - int count， 最后一艘船上有多少 box
   - int load， 最后一艘船的 总载重
   - int cost， 最后一艘船的 trips 的总数


思路：
1. Base case
   - dp[1] = 2， 只有一个货物的时候，一来一回两次
   - dp[1] 对应的 last ship的信息
     - box = 1
     - load = boxes[0].weight
     - cost = 2

2. Transition equation
   - 已知 dp[0 ~ j]. 求 dp[j+1] 的时候
   - 关键在于加入最新的货物 box[j] 和哪些 货物组成 last ship, 要确定合适的 i
   - 暴力法
     - dp[j+1] = min (dp[i] + cost) for i in [0, j-1]
   - 优化
     - 当前的 last ship 的 range 总是上一个 last boat 的变化
     - 我们可以通过 sliding window 来捕捉这种变化
     - 所以可以 update i，通过以下规则
       - count > maxBoxes
       - load > maxWeight
       - dp[i] == dp[i+1]， 尽可能减少不必要的货物来减少最后一艘船的 cost，此时因为等是满足前面的cost不变，所以总的cost在变小
         - Obviously，货物越多，trips肯定越多


注意：

1. ship 最终总是要返回 出发地 

2. 所有的 weight 总是 positive 的

