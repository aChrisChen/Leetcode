class Solution {
    public int[] findBall(int[][] grid) {
        // time: O(mn) 62.58%
        // space: O(n) 78.74%
        int m = grid.length, n = grid[0].length, res[] = new int[n];
        for (int j = 0; j < n; j++) {
            int j1 = j; // j1 是当前所在的column
            for (int i = 0; i < m; i++) {
                int j2 = j1 + grid[i][j1]; // j2 下一个可能去的 column
                if (j2 < 0 || j2 >= n || grid[i][j1] != grid[i][j2]) {
                    // 滚出边界 或者 遇到V
                    j1 = -1;
                    break;
                }
                j1 = j2;
            }
            res[j] = j1;
        }
        return res;
    }
}