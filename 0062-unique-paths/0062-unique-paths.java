class Solution {
    public int dfs(int i, int j, int n, int m, Integer dp[][]) {
        if (i < 0 || j < 0 || i >= n || j >= m)
            return 0;
        if (i == n - 1 && j == m - 1) {  
            return 1;
        }
        if(dp[i][j]!=null) return dp[i][j];
        return dp[i][j]=dfs(i + 1, j, n, m, dp)+dfs(i, j + 1, n, m, dp);
    }

    public int uniquePaths(int n, int m) {
       
        Integer dp[][] = new Integer[n+1][m+1];
        return dfs(0, 0, n, m, dp);
    }
}