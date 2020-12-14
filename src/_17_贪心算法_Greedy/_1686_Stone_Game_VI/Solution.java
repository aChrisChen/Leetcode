class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        // time: O(N) 33.33%
        // space: O(N) 33.33%
        int N = aliceValues.length;
        // step1: sort
        int[][] sums = new int[N][3];
        for (int i = 0; i < N; i++) {
            sums[i][0] = aliceValues[i] + bobValues[i];
            sums[i][1] = aliceValues[i];
            sums[i][2] = bobValues[i];
        }
        Arrays.sort(sums, (a, b) -> b[0] - a[0]);
        // step2: greedy
        int a = 0, b = 0;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                a += sums[i][1]; // 这里也可以使用 sums[i][0]
            } else {
                b += sums[i][2]; // 这里也可以使用 sums[i][0]
            }
        }
        return Integer.compare(a, b);
    }
}