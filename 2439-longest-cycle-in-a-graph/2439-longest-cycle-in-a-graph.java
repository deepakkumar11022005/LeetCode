class Solution {

    int par[];
    int vis[];
    // List<Integer> temp=new ArrayList<>();
    public int dfs(int node,int adj[],int parent){
        vis[node]=1;
        par[node]=parent;
        int child=adj[node];
        if(child==-1) return 0;
        if(vis[child]==0)
        {
            return dfs(child,adj,node);
        }
         else if(vis[child]==1)
            {
                int c=1;
               
                while(node!=child)
                {
                   c++;
                    if(node==-1){
                        return 0;
                    }
                    node=par[node];
                }
                if(node==child) return c;
                return 0;
            }
        return 0;
    }
    public int longestCycle(int[] edges) {
        int n=edges.length;
        vis=new int[n];
        par=new int[n];
        int max=0;
        for(int i=0;i<n;i++)
        {
            if(vis[i]==0 )
            {
                   
                    max=Math.max(max,dfs(i,edges,-1));
                     
            }
        }
        return max==0?-1:max;
    }
}