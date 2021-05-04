# [753. Cracking the Safe](https://leetcode.com/problems/cracking-the-safe/)

## 法一：回溯法

intuition：
1. 关键在于 de Bruijin Sequence
    - A de Bruijn sequence of order n on a size-k alphabet A is a cyclic sequence in which every possible length-n string on A occurs exactly once as a substring. It has length k^n, which is also the number of distinct substrings of length n on a size-k alphabet; de Bruijn sequences are therefore optimally short.
    - de Bruijin sequence 是一个 cyclic string of size k^n，其中 size-k alphabet 中长度是 n 的 每个 substring都会出现一次 （相当于每一个字母开始的长度是n的substring都是distinct的）
    - 所以，对于题目中给定的 n 和 k，要找到一个 pwd，包含所有的 k^n 个密码，他的最短长度肯定是 k^n + n - 1。因为 de bruijin sequence的存在，所以我们可以根据 de bruijin sequence 来轻松的创建这么一个长度是最短的密码
    - 起始点是任意 node (长度n的substring) 都可以，因为 de Bruijin 是 cyclic 的
    - 所以，我们想到用 DFS 来寻找 pwd

思路：
1. DFS
    - goal: to find the shortest input password such that each possible n-length combination of digits [0..k-1] occurs exactly once as a substring.
    - node: current input password
    - edge: if the last n - 1 digits of node1 can be transformed to node2 by appending a digit from 0..k-1, there will be an edge between node1 and node2
    - start node: n repeated 0's
    - end node: all n-length combinations among digits 0..k-1 are visited
    - visitedComb: all combinations that have been visited

## 法二

用 Lyndon Word 来构建 de Bruijin Sequence