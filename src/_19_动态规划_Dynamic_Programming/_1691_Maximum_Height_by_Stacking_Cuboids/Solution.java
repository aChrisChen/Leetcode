class Solution {
    public int maxHeight(int[][] cuboids) {
        // time: O(n) 46.82%
        // space: O(n) 17.04%
        // step1: sort
        for (int[] a: cuboids) {
            Arrays.sort(a);
        }
        Arrays.sort(cuboids, new Comparator<>(){
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) return b[0] - a[0];
                if (a[1] != b[1]) return b[1] - a[1];
                return b[2] - a[2];
            }
        });
        // step2: LIS, using the biggest dimension as the height will give the optimal
        int res = 0;
        int[] dp = new int[cuboids.length];
        for (int i = 0; i < cuboids.length; i++) {
            dp[i] = cuboids[i][2];
            for (int j = 0; j < i; j++) {
                if (cuboids[j][0] >= cuboids[i][0] && cuboids[j][1] >= cuboids[i][1] && cuboids[j][2] >= cuboids[i][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}