# [1705. Maximum Number of Eaten Apples](https://leetcode.com/problems/maximum-number-of-eaten-apples/)

数据结构：

1. TreeMap<Integer, Integer> map
   - 每一个键值对 <K, V> 表示 过期日期是 K 的苹果 一共有 V 个
   - 我们的贪心策略的关键就是在于，优先吃快要过期的苹果
  
思路：

1. 初始化 map
2. 一直循环，遍历 apples 或者 map 非空
   - 加入当天的 苹果
   - 去除 expire 的苹果
   - 吃今天要吃的苹果

注意：

1. TreeMap 有的时候可以和 PriorityQueue的写法相互转换
   - 写法一是 TreeMap，也是本文的数据结构和思路
   - 写法二是 PQ
2. 时间复杂度是o(NlogN)，其中N是天数。最多我们会遍历多少天呢？极限情况是：最后一天遇上了保质期最长的苹果，N最大是2e4+2e4.所以o(NlogN)是可以接受的。
  