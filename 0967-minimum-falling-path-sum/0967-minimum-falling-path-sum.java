class Solution {
    public int dfs(int nums[][], int num, int ind, int n, Integer dp[][]) {
        if (ind < 0 || ind >= n)
            return Integer.MAX_VALUE;
        if (num == n - 1) {
            return nums[num][ind];
        }
        if (dp[num][ind] != null)
            return dp[num][ind] ;
        int left= dfs(nums, num + 1, ind - 1, n,dp);
        int st= dfs(nums, num + 1, ind, n,dp);
        int right= dfs(nums, num + 1, ind + 1, n,dp);

       dp[num][ind]=nums[num][ind]+Math.min(Math.min(left,st),right);
        return  dp[num][ind];
    }

    public int minFallingPathSum(int[][] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        Integer dp[][]=new Integer[n][n];
        for (int i = 0; i < n; i++) {
            int m = dfs(nums, 0, i, n,dp);
            min = Math.min(min, m);
        }
        return min;
    }
}