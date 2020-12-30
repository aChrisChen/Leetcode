# [1706. Where Will the Ball Fall](https://leetcode.com/problems/where-will-the-ball-fall/)


参考：

- [lee215的回答](https://leetcode.com/problems/where-will-the-ball-fall/discuss/988576/JavaC%2B%2BPython-Solution-with-Explanation)
- [wisdompeak的视频](https://www.youtube.com/watch?v=Fpxbc_YpldQ)


intuition：

1. 本题乍看有点像959.Regions-Cut-By-Slashes，但本质只是简单的模拟。
2. 基本规律
   - 当前是\时，如果右边是/，那么卡死。j1 != j2
   - 当前是\时，如果右边是边界，那么卡死
   - 当前是\时，如果右边是\，那么会掉落在右下方的格子。j1 == j2
   - 当前是/时，如果左边是\，那么卡死
   - 当前是/时，如果左边是边界，那么卡死
   - 当前是/时，如果左边是/，那么会掉落在左下方的格子。
3. 直至球落到第m行，所在的y坐标就是答案