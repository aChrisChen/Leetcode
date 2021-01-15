class Solution {
    int res;
    
    public int minimumTimeRequired(int[] jobs, int k) {
        // time: O(k^n), n = jobs.length, 44.14%
        // space: O(n), 50.75%
        Integer[] workers = new Integer[k];
        Arrays.fill(workers, 0);
        this.res = Integer.MAX_VALUE;
        dfs(jobs, workers, 0);
        return res;
    }
    
    private void dfs(int[] jobs, Integer[] workers, int cur) {
        if (cur == jobs.length) {
            res = Math.min(res, Collections.max(Arrays.asList(workers))); // Integer[]可以成功asList
            return;
        }
        // workers=[10,5,5,2]的时候，把当前job分配给中间两个工人是一样的，利用seen来prune这个
        HashSet<Integer> seen = new HashSet<>(); 
        for (int i = 0; i < workers.length; i++) {
            // prune
            if (seen.contains(workers[i])) continue;
            if (workers[i] + jobs[cur] >= res) continue;
            // recursive
            seen.add(workers[i]);
            workers[i] += jobs[cur];
            dfs(jobs, workers, cur + 1);
            workers[i] -= jobs[cur];
        }
    }
}