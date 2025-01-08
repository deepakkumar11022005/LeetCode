class Solution {
    int row[] = { 1, -1, 0, 0 };
    int col[] = { 0, 0, 1, -1 };

    public int dfs(int nums[][], int i, int j, int n, int m, int count, int obst) {
        if (i < 0 || j < 0 || i >= n || j >= m ||nums[i][j] == -1 || nums[i][j] ==-2)
            return 0;
        
        if (nums[i][j] == 2) {
           return m*n-obst == count ? 1 : 0;

        }
        nums[i][j] = -2;
        int res = 0;
        for (int k = 0; k < 4; k++) {
            int r = row[k] + i;
            int c = col[k] + j;
            res += dfs(nums, r, c, n, m, count + 1, obst);
        }
        nums[i][j] = 0;
        return res;
    }

    public int uniquePathsIII(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;
        int ii = 0;
        int jj = 0;
        int zero = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums[i][j] == 1) {
                    ii = i;
                    jj = j;
                    
                }
                else if(nums[i][j]==-1)
                zero++;
            }
        }
        return dfs(nums, ii, jj, n, m, 1, zero);
    }
}