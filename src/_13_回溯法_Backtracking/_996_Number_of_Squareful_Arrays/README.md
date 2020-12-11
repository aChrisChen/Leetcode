# [996. Number of Squareful Arrays](https://leetcode.com/problems/number-of-squareful-arrays/)

数据结构：

1. Map<Integer, Integer> count
   - 每一个键值对 <K, V> 表示示 数字 K 一共有 V 个

2. Map<Integer, List<Integer>> graph
   - 每一个键值对 <K, V> 表示，对于 vertex K 来说，可以和他组成 squareful 的另一个数字，被存储在 V 中
   - graph.get(v) : values w in A for which v + w is a square (ie., "vw" is an edge)

思路：

1. 初始化 count 和 graph
2. 利用 dfs 来递归
   - x 表示当前的数字是啥
   - todo 表示还有多少数字需要添加

注意：

1. 如何判断一个数字 num 是否是 perfect square
   - int root = (int) Math.sqrt(num);
   - root * root == num
  