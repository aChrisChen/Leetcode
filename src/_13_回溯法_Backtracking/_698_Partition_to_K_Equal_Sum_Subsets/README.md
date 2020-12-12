# [698. Partition to K Equal Sum Subsets](https://leetcode.com/problems/partition-to-k-equal-sum-subsets/)

这是一个著名的 NP-Hard 问题，名字叫做 `Subset Sum`。

法一：

参考：[caihao的回答](https://leetcode.com/problems/partition-to-k-equal-sum-subsets/discuss/108730/JavaC%2B%2BStraightforward-dfs-solution)

数据结构：

1. int target
   - 每一个 subset 的和
2. boolean[] visited = new boolean[N]
   - visited[i] 表示 nums[i] 是否被使用过

思路：

1. 预处理（不做也行）
   - 将数组从大到小排序，可以优化速度
   - 这样可以尽早把大的元素分配出去，大的元素sum >= target 的速度也快，可以提高速度
2. 求出 total 和 target
3. 利用 dfs 来递归
   - Base Case: 
     - k==1，说明只剩一下一组 set了，此时所有的剩下的数字正好可以组成和是target的一组数字，因为 k * target = total
     - curSum > target，说明当前invalid
     - curSum == target && count > 0
       - 说明找到一组合适的
   - start 用来控制每次搜索示从头到尾的一次搜索。每当搜索到合适的 set 的时候，从头开始搜索新的合适的subset
   - curSum 表示当前的sum
   - count 表示当前的 set 的数字的数量

注意：

1. This question has been changed after the contest. 
   - It added the special restriction 0 < nums[i] < 10000. My solution here is without that consideration.


法二：

参考：[Leetcode官方题解](https://leetcode.com/problems/partition-to-k-equal-sum-subsets/solution/)

数据结构：

1. int[] groups
   - groups[i] 表示 第 i 个 subset 的 和

思路：

1. 预处理（不做也行）
   - 将数组从大到小排序，可以优化速度
   - 这样可以尽早把大的元素分配出去，大的元素sum >= target 的速度也快，可以提高速度
2. 求出 total 和 target
3. 利用 dfs 来递归
   - 如果 end < 0 表示所有的 数字都 assigned出去了
     - 并且所有的 groups[i] <= target 也被满足
     - 因为 k * target == sum
     - 所以，此时 groups[i] == target 一定也都被满足
   - 否则，可以讲当前的 number 分配给 groups中的 任何一组来进行 branch