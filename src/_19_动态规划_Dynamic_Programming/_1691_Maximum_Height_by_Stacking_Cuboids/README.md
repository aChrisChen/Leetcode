# [1691. Maximum Height by Stacking Cuboids](https://leetcode.com/problems/maximum-height-by-stacking-cuboids/)

LIS 的升级版。

参考：

- [lee215 的回答](https://leetcode.com/problems/maximum-height-by-stacking-cuboids/discuss/970293/JavaC%2B%2BPython-DP-Prove-with-Explanation)
- [wisdompeak的github，解释了intuition，为啥greedy不可](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1687.Delivering-Boxes-from-Storage-to-Ports)

Intuition:

1. 只有在一种情况下，cuboid i 才可以放到 cuboid j 上，那就是
   - width[i] <= width[j] and length[i] <= length[j] and height[i] <= height[j]
2. 如果cuboid i 和 j 满足上面的条件 ===》那么把 cuboid 的length sort 一下，可以满足
   - small[i] <= small[j] and mid[i] <= mid[j] and big[i] <= big[j]
3. 因为我们要 maximize 叠在一起的 cuboids 的 height，所以我们最好是用 big 来作为 height
   - 有没有可能总是把 big 作为 height，导致有些本来可以放到一起的cuboids 不能放到一起了？
   - 不会的。因为 1 和 2。可以放到一起的话，肯定满足条件1，那么条件2也会满足。在条件2的情况下，很明显 big[i] + big[j] 可以得到最大的 height。
4. 所以我们要做的，就是先把所有的 cuboids 的三条边 sort一下，然后把cuboids 再sort 一下，然后用 LIS 的方法，找到最佳的可以叠在一起的cuboids
   

