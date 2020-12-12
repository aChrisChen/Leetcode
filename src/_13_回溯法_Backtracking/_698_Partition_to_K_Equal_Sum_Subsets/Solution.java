class Solution {
    int target;

    // solution 1: 
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // time: O(k*2^n) 95.53%
        // space: O(n) 45.74%
        // step1: pre-computing
        Arrays.sort(nums);
        reverse(nums);
        // step2: cal target
        int total = 0;
        for (int num : nums) total += num;
        if (total % k != 0) return false;
        this.target = total / k;
        // step3: dfs
        return canPartition(nums, new boolean[nums.length], k, 0, 0, 0);
    }
    
    private boolean canPartition(int[] nums, boolean[] visited, int k, int start, int curSum, int count) {
        if (k == 1) {
            return true;
        }
        if (curSum > target) {
            return false;
        }
        if (curSum == target && count > 0) {
            return canPartition(nums, visited, k - 1, 0, 0, 0); // start serach from index 0
        }
        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                // continue search from i+1 to avoid look back
                if (canPartition(nums, visited, k, i+1, curSum + nums[i], count + 1)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
    
    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // solution2 : 
    
    public boolean canPartitionKSubsets2(int[] nums, int k) {
        // time: O(n^k) 20.15%
        // space: O(n) 29.44%
        // step1: pre-computing
        Arrays.sort(nums); // 这里数字从小到大，等会dfs就从后往前，来确保从大到小遍历
        // step2: cal target
        int total = Arrays.stream(nums).sum();
        if (total % k != 0) return false;
        this.target = total / k;
        // step3: dfs
        return canPartition(nums, new int[k], nums.length - 1);
    }
    
    private boolean canPartition(int[] nums, int[] groups, int end) {
        // [0, end] is the nums waiting to be assigned
        if (end < 0) return true;
        int val = nums[end];
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + val <= target) {
                groups[i] += val;
                if (canPartition(nums, groups, end - 1)) {
                    return true;
                }
                groups[i] -= val;
            }
        }
        return false;
    } 
}