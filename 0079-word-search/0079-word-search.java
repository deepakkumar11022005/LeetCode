class Solution {
    int[] row = {1, 0, -1, 0};
    int[] col = {0, -1, 0, 1};

    public boolean dfs(char[][] nums, String word, int i, int j, boolean[][] vis, int ind) {
        if (ind == word.length()) {
            return true;
        }

        vis[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int r = row[k] + i;
            int c = col[k] + j;

            if (r >= 0 && r < nums.length && c >= 0 && c < nums[0].length 
                && nums[r][c] == word.charAt(ind) && !vis[r][c]) {
                if (dfs(nums, word, r, c, vis, ind + 1)) {
                    return true;
                }
            }
        }

        vis[i][j] = false; 
        return false;
    }

    public boolean exist(char[][] nums, String word) {
        if (nums == null || nums.length == 0 || word == null || word.isEmpty()) {
            return false;
        }

        int n = nums.length;
        int m = nums[0].length;
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums[i][j] == word.charAt(0)) {
                    if (dfs(nums, word, i, j, vis, 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
