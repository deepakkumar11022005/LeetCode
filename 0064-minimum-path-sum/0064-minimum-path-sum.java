class Solution {

    public int dfs(int nums[][], int i, int j, int n, int m, int sum, Integer dp[][]) {
        if (i < 0 || i >= n || j < 0 || j >= m)
            return Integer.MAX_VALUE;
        if (i == n - 1 && j == m - 1) {
            return sum + nums[i][j];
        }
        if (dp[i][j] != null)
            return dp[i][j]+sum;
        dp[i][j] = Math.min(dfs(nums, i + 1, j, n, m, sum + nums[i][j], dp),
                dfs(nums, i, j + 1, n, m, sum + nums[i][j], dp)) - sum;
        return dp[i][j]+sum;
    }

    public int minPathSum(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;
        // min = Integer.MAX_VALUE;
        Integer dp[][] = new Integer[n][m];
        return dfs(nums, 0, 0, n, m, 0, dp);
        // return min;
    }
}