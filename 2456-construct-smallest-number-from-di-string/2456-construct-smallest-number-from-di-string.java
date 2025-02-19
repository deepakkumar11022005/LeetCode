class Solution {
    int n;
    String result=null;
    public void dfs(int index, int res[], boolean vis[], String pattern) {
         if (index == n + 1) { 
            StringBuilder sb = new StringBuilder();
            for (int num : res) sb.append(num);
            if (result == null || sb.toString().compareTo(result) < 0) {
                result = sb.toString();
            }
            return;
        }

        // System.out.println(index+" "+res[index]);
        for (int i = 1; i <=n+1; i++) {
            if (vis[i])
                continue;
            if (index==0|| (pattern.charAt(index-1) == 'I' && res[index - 1] < i )|| (pattern.charAt(index-1) == 'D' && res[index - 1] > i)) {
                res[index] = i;
                vis[i] = true;
                dfs(index + 1, res, vis, pattern);
                vis[i]=false;
            } 
        }
        // res[index]=0;
    }

    public String smallestNumber(String pattern) {
        n = pattern.length();
        int res[] = new int[n + 1];
        boolean vis[] = new boolean[n + 2];
        for (int i = 1; i <= n+1; i++) {
            res[0] = i;
            vis[i]=true;
            // System.out.println(res[0]+"hi");
            dfs(1, res, vis, pattern);
            vis[i]=false;
            if(result!=null) break;
        }
      return result;
    }
}