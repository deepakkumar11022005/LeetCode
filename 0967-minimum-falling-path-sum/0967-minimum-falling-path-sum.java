class Solution {
    public int dfs(int nums[][], int num, int ind, int n, int sum,Integer dp[][]) {
        if (ind < 0 || ind >= n)
            return Integer.MAX_VALUE;
        if (num == n - 1) {
            return sum + nums[num][ind];
        }
        if (dp[num][ind] != null)
            return dp[num][ind] + sum;
        dp[num][ind]=Math.min(Math.min(
                dfs(nums, num + 1, ind - 1, n, nums[num][ind] + sum,dp),
                dfs(nums, num + 1, ind, n, nums[num][ind] + sum,dp)),
                dfs(nums, num + 1, ind + 1, n, nums[num][ind] + sum,dp))-sum;
        return  dp[num][ind]+sum;
    }

    public int minFallingPathSum(int[][] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        Integer dp[][]=new Integer[n][n];
        for (int i = 0; i < n; i++) {
            int m = dfs(nums, 0, i, n, 0,dp);
            min = Math.min(min, m);
        }
        return min;
    }
}