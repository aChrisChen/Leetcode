class Solution {
    // clean solution
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        // time: O(n) 100.00%
        // space: O(n) 86.81%
        int N = boxes.length;
        int[] dp = new int[N + 1];
        dp[1] = 2;
        int count = 1; // # of boxes in last ship，这些关于last ship的信息都和题目的constraint对应
        int load = boxes[0][1]; // load in the last ship
        int cost = 2; // cost for last ship
        for (int i = 0, j = 1; j < N; j++) {
            // add current box
            count++;
            load += boxes[j][1];
            if (boxes[j - 1][0] != boxes[j][0]) cost++;
 
            // adjust to maxBoxes and maxWeight and remove unneccessary boxes to minimize diff
            while (count > maxBoxes || load > maxWeight || dp[i] == dp[i+1]) {
                count--;
                load -= boxes[i][1];
                if (boxes[i][0] != boxes[i+1][0]) cost--;
                i++;
            }
            // update
            dp[j+1] = dp[i] + cost;
        }
        return dp[N];
    }

    // detailed solution
    public int boxDelivering2(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        // time: O(n) 69.44%
        // space: O(n) 40.97%
        int N = boxes.length;
        // step1: pre-computing
        boolean[] diffNext = new boolean[N]; // diffNext[i] 表示boxes[i]是否和下一个货物属于不同的port
        for (int i = 0; i < N - 1; i++) {
            diffNext[i] = (boxes[i][0] != boxes[i+1][0]);
        }
        // step2: dp
        int[] dp = new int[N + 1];
        int sum = 0; // total weights for last ship
        int diff = 0; // # of different adjacent ports
        int start = 0; // first index of box in last ship
        for (int i = 0; i < N; i++) {
            // add current box
            sum += boxes[i][1];
            if (i > 0 && diffNext[i - 1]) diff++;
 
            // adjust to maxBoxes
            if (i - start == maxBoxes) {
                sum -= boxes[start][1];
                if (diffNext[start]) diff--;
                start++;
            }
            // adjust to maxWeight
            while (start < i && sum > maxWeight) {
                sum -= boxes[start][1];
                if (diffNext[start]) diff--;
                start++;
            }
            // remove unneccessary boxes to minimize diff
            while (start < i && dp[start] == dp[start + 1]) {
                sum -= boxes[start][1];
                if (diffNext[start]) diff--;
                start++;
            }
            // update
            dp[i + 1] = dp[start] + diff + 2;
        }
        return dp[N];
    }
}