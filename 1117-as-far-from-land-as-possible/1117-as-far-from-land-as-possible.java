
class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        boolean vis[][] = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.add(new int[] { i, j, 0 });
                    vis[i][j] = true;
                }

            }
        }

        int max = -1;
        int row[] = { 1, -1, 0, 0 };
        int col[] = { 0, 0, 1, -1 };
        while (!q.isEmpty()) {
            int temp[] = q.poll();

            for (int i = 0; i < 4; i++) {
                int r = temp[0] + row[i];
                int c = temp[1] + col[i];
                // System.out.println(r+" "+c+" "+temp[2]+"**********");
                if (r >= 0 && c >= 0 && r < n && c < n && !vis[r][c] && grid[r][c] == 0) {
                    // System.out.println(temp[0] + " " + temp[1] + " " + temp[2]);
                    q.add(new int[] { r, c, temp[2] + 1 });
                    max = Math.max(max, temp[2] + 1);
                    vis[r][c] = true;
                }
            }

        }
        return max;
    }
}