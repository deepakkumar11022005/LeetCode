class pair {
    int i;
    int j;
    boolean vis;

    public pair(int ii, int jj, boolean f) {
        i = ii;
        j = jj;
        vis = f;
    }
}

class Pair {
    int node;
    int level;

    public Pair(int n, int l) {
        node = n;
        level = l;
    }
}

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int i = n - 1;
        int j = 0;
        boolean flag = true;
        int count = 1;
        HashMap<Integer, pair> map = new HashMap<>();
        while (i >= 0) {
            if (flag) {
                for (int k = 0; k < n; k++)
                    map.put(count++, new pair(i, k, false));
                flag = false;
            } else {
                for (int k = n - 1; k >= 0; k--)
                    map.put(count++, new pair(i, k, false));
                flag = true;
            }
            i--;
        }
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)-> a.level-b.level);
        q.add(new Pair(1, 0));
        map.put(1, new pair(5, 0, true));
        boolean bonus = false;
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Pair temp = q.poll();
           
            if (temp.node == n * n) {
                 
                min = Math.min(min, temp.level);
                return min;
            }
            int maxMove = Math.min(temp.node + 6, n * n);
            bonus = false;
            for (int k = temp.node + 1; k <= maxMove; k++) {
                int a = map.get(k).i;
                int b = map.get(k).j;
                if (board[a][b] != -1 && !map.get(k).vis) {
                    bonus = true;
                    q.add(new Pair(board[a][b], temp.level + 1));
                }
                else if(!map.get(k).vis){
                     q.add(new Pair(k, temp.level + 1));
                }
                 map.put(k, new pair(a, b, true));
            }
           
        }
       

        return min== Integer.MAX_VALUE?-1:min;
    }
}