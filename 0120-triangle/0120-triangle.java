class Solution {
    public int dfs(List<List<Integer>> nums, int ind, int num, int n, int sum, Integer dp[][]) {
        if (ind >= n)
            return Integer.MAX_VALUE;
        if (num == n - 1) {
            return sum + nums.get(num).get(ind);
        }
        if (dp[num][ind] != null)
            return dp[num][ind] + sum;
        dp[num][ind] = Math.min(dfs(nums, ind, num + 1, n, sum + nums.get(num).get(ind),dp),
                dfs(nums, ind + 1, num + 1, n, sum + nums.get(num).get(ind),dp)) - sum;
        return dp[num][ind] + sum;
    }

    public int minimumTotal(List<List<Integer>> nums) {
        int n = nums.size();
        Integer dp[][] = new Integer[n][n];
        return dfs(nums, 0, 0, n, 0, dp);
    }
}