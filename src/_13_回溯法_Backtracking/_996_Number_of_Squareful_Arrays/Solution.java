class Solution {
    Map<Integer, Integer> count;
    Map<Integer, List<Integer>> graph;
    
    public int numSquarefulPerms(int[] A) {
        // time: O(n^n) 88.25%
        // space: O(n) 36.14%
        int N = A.length;
        this.count = new HashMap<>();
        this.graph = new HashMap<>();
        // step1: init
        for (int x: A) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        for (int x: count.keySet()) {
            graph.put(x, new ArrayList<>());
            for (int y: count.keySet()) {
                int r = (int) Math.sqrt(x + y);
                if (r * r == x + y) {
                    // the x and y are symmetric, so adding once here is enough
                    graph.get(x).add(y);
                }
            }
        }
        // step2: DFS
        int ans = 0;
        for (int x: count.keySet()) {
            ans += dfs(x, N - 1);
        }
        return ans;
    }
    
    private int dfs(int x, int todo) {
        if (todo == 0) {
            return 1;
        }
        int ans = 0;
        count.put(x, count.get(x) - 1);
        for (int y: graph.get(x)) {
            if (count.get(y) != 0) {
                ans += dfs(y, todo - 1);
            }
        }
        count.put(x, count.get(x) + 1);
        return ans;
    }
}