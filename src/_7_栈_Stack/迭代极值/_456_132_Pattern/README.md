[Leetcode](https://leetcode.com/problems/132-pattern/)

这种题目，找这种规律。一般都是用中间大小的数字来作为标准！！

参考：中文参考
LC高票
LC官方

Intuition：
* 要把中间的数字作为标准，数字大小是 1 、 3、2
  * 因为 3、2是连续的
  * 所以，遍历顺序，是从后往前找
* 为什么想到要用 Stack?
  * 后进 Stack的，可能先变成 mid
  * 做题越熟，越能感觉出来！！！多做题啊！！

数据结构：
* int mid
  * (s1, s2, s3) 中的 s3，是大小在中间的数
  * Mid 有大小的话，一定是一个合格的数，表示 s2 和 s3 都找到了！！
  * Mid 越大越好！！！
  * 遍历的时候，遍历到 i 的时候， mid 都是我们能在左边找到的最大的符合条件的 mid。
* Stack<Integer> stack
  * 中间存的是 mid 的备选值
  * 每次通过 stack 选 mid的时候，对应的最大的数，是 nums[i] 本身
  * 注意，Stack 中的数，从栈底到栈顶依次减小（不严格）！！！

思路：
* 从右往左遍历
* 如果当前的数 比 mid 小，那么就 return true
* 如果当前的数 >= mid，说明我们可以找到更大的 mid
  * 将当前的数，和 栈中的数比较，找到一个新的 mid
  * 将当前的数 push进栈，作为 mid 备选

