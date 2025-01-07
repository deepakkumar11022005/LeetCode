class Solution {
    public int dfs(int nums[][], int i, int j, int n, int m, Integer dp[][]) {
        if (i < 0 || j < 0 || i >= n || j >= m || nums[i][j] == 1)
            return 0;
        if (i == n - 1 && j == m - 1) {
            return 1;
        }
        if (dp[i][j] != null)
            return dp[i][j];
        return dp[i][j] = dfs(nums, i + 1, j, n, m, dp) + dfs(nums, i, j + 1, n, m, dp);
    }

    public int uniquePathsWithObstacles(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;
        Integer dp[][] = new Integer[n + 1][m + 1];
        return dfs(nums, 0, 0, n, m, dp);

    }
}