import java.util.HashSet;
import java.util.Set;

class Solution {
    int parent[];
    int size[];
    int edge[];

    public int find(int u) {
        if (parent[u] == u)
            return u;
        return parent[u] = find(parent[u]); 
    }

    public void union(int i, int j) {
        int a = find(i);
        int b = find(j);
        if (a == b) {
            edge[a]++;  
            return;
        }
        if (size[a] >= size[b]) {
            parent[b] = a;
            size[a] += size[b];
            edge[a] += edge[b] + 1;  
        } else {
            parent[a] = b;
            size[b] += size[a];
            edge[b] += edge[a] + 1;  
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];
        edge = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
            edge[i] = 0;
        }

        for (int[] e : edges) {
            union(e[0], e[1]);
        }

        Set<Integer> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            int root = find(i);
            if (!set.contains(root)) {
                if (edge[root] == (size[root] * (size[root] - 1)) / 2) {
                    count++;
                }
                set.add(root);
            }
        }

        return count;
    }
}
