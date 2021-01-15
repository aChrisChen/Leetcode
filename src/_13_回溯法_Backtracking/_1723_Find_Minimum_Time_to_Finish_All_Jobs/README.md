# [1723. Find Minimum Time to Finish All Jobs](https://leetcode.com/problems/find-minimum-time-to-finish-all-jobs/)

参考：

- [lichuan199010 的回答](https://leetcode.com/problems/find-minimum-time-to-finish-all-jobs/discuss/1009817/One-branch-cutting-trick-to-solve-three-LeetCode-questions)

Intuition：

1. DFS + Prune
2. DFS 的思路主要在于依次遍历 jobs，分配jobs给不同的工人
3. prune 的思路主要有两个
    - 当前给过比已知的全剧最优解差，停止搜索 workers[i] + jobs[cur] >= res
    - Symmetry Breaking。比如 workers 当前所用时间是 [10,5,5,2], 此时把当前job分配给中间两个当前工作时间是5的工人，效果是一样的。所以创建一个 HashSet seen，分配给一样的工作时间的工人一次就好了

注意：

1. 如果把 jobs 一开始 Reverse sort 可以 speed up 吗？
    - It is much slower, because it will try to stack all long sticks into the same bin, but in reality, we know it is probably better to spread them out into each bin.
2. 类似题目
    - [473. Matchsticks to Square](https://leetcode.com/problems/matchsticks-to-square/)
    - [698. Partition to K Equal Sum Subsets](https://leetcode.com/problems/partition-to-k-equal-sum-subsets/)
3. 进一步优化
    - 理想的情况下，重的东西应该是平均分配给所有人的。可以加快速度。我们可以利用这个思路尽快的找到最优解，这样可以让我们更好的prune。
    - 具体算法实现上。reverse sort之后，每次分配的起始点不同。比如分配 job0的话优先分配给第一个人，分配job1最先分给第二个人……以此类推。从而实现，在最开始的搜索重，比较重的东西，尽量分配给所有人，从而尽快找到最优解。
    - Another trick is to change the for loop. Instead of always looping from 0 through k - 1, change it such that the first time iterates through (0, k), the second time iterates (1, k + 1), etc. So the first branch of the dfs will even out the job assignment instead of frontloading all into the first bucket. This speeds up runtime from ~480ms to ~80ms.

```Python
class Solution:
    def minimumTimeRequired(self, jobs: List[int], k: int) -> int:
        workers = [0]*k
        jobs.sort(reverse=True)
        self.res = sys.maxsize
        self.start = 0
        
        def dfs(curr):
            self.start += 1
            if curr == len(jobs):
                self.res = min(self.res, max(workers))
                return
            
            seen = set() # record searched workload of workers
            for i in range(self.start, self.start + k):
                idx = i % k
                if workers[idx] in seen: continue # if we have searched the workload of 5, skip it.
                if workers[idx] + jobs[curr] >= self.res: continue # another branch cutting
                seen.add(workers[idx])
                workers[idx] += jobs[curr]
                dfs(curr+1)
                workers[idx] -= jobs[curr]
        
        dfs(0)
        return self.res
```

