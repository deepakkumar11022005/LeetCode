
class Solution {

    public int[] maxPoints(int[][] grid, int[] queries) {
        int num = queries.length;
        int[][] arr = new int[num][2];
        for (int i = 0; i < num; i++) {
            arr[i][0] = queries[i];
            arr[i][1] = i;
        }
        int res[] = new int[num];
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.add(new int[] { grid[0][0], 0, 0 });
        vis[0][0] = true;
        int index = 0;
        int row[] = { 1, -1, 0, 0 };
        int col[] = { 0, 0, 1, -1 };
        int count=0;
        while (!q.isEmpty() && index < num) {
            int temp[] = q.poll();
            
            while (index < num && temp[0] >= arr[index][0]){
              res[arr[index][1]]=count;
                 index++;
            }
                
            count++;
            // System.out.println(Arrays.toString(res) +" "+Arrays.toString(temp)+" "+arr[index][0]);
            for (int i = 0; i < 4; i++) {
                int r = row[i] + temp[1];
                int c = col[i] + temp[2];
                if (r >= 0 && c >= 0 && r < n && c < m && !vis[r][c]) {
                    q.add(new int[] { grid[r][c], r, c });
                    vis[r][c] = true;
                }
            }

        }
         while (index < num) {
            res[arr[index][1]] = count;
            index++;
        }
        return res;
    }
}