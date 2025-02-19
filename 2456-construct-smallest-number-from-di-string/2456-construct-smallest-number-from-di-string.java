import java.util.*;

class Solution {
    int n;
    String result = null;

    public void dfs(int index, int res[], boolean vis[], String pattern) {
        if (index == n + 1) {  // Base case: when the entire number is built
            StringBuilder sb = new StringBuilder();
            for (int num : res) sb.append(num);
            if (result == null || sb.toString().compareTo(result) < 0) {
                result = sb.toString();  // Store lexicographically smallest result
            }
            return;
        }

        for (int i = 1; i <= n + 1; i++) {  // Range should be [1, n+1]
            if (vis[i]) continue; // Skip already used numbers

            if (index == 0 || 
                (pattern.charAt(index - 1) == 'I' && res[index - 1] < i) || 
                (pattern.charAt(index - 1) == 'D' && res[index - 1] > i)) {

                res[index] = i;
                vis[i] = true;
                dfs(index + 1, res, vis, pattern);
                vis[i] = false; // Backtrack
            }
        }
    }

    public String smallestNumber(String pattern) {
        n = pattern.length();
        int res[] = new int[n + 1];  // To store numbers
        boolean vis[] = new boolean[n + 2];  // Visited array for tracking

        for (int i = 1; i <= n + 1; i++) {  // Fix: Range should be [1, n+1]
            res[0] = i;
            vis[i] = true;
            dfs(1, res, vis, pattern);
            vis[i] = false;
            if (result != null) break; // Stop early after finding the smallest valid number
        }

        return result;
    }

   
}
