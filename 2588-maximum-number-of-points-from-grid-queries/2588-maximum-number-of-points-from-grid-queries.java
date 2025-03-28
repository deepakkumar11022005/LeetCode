import java.util.*;

class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int num = queries.length;
        int[][] arr = new int[num][2];
        for (int i = 0; i < num; i++) {
            arr[i][0] = queries[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        int res[] = new int[num];

        int n = grid.length, m = grid[0].length;
        boolean vis[][] = new boolean[n][m];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{grid[0][0], 0, 0});
        vis[0][0] = true;

        int index = 0, count = 0;
        int[] row = {1, -1, 0, 0}, col = {0, 0, 1, -1};

        while (!pq.isEmpty() && index < num) {
            int[] temp = pq.poll();
            
            while (index < num && temp[0] >= arr[index][0]) {
                res[arr[index][1]] = count;
                index++;
            }
            
            count++; // Count valid cells
            
            for (int i = 0; i < 4; i++) {
                int r = temp[1] + row[i];
                int c = temp[2] + col[i];
                if (r >= 0 && c >= 0 && r < n && c < m && !vis[r][c]) {
                    pq.add(new int[]{grid[r][c], r, c});
                    vis[r][c] = true;
                }
            }
        }

        // Fill remaining queries
        while (index < num) {
            res[arr[index][1]] = count;
            index++;
        }

        return res;
    }
}
