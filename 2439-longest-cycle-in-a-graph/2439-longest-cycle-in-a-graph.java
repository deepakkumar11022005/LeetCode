class Solution {

    int par[];
    int vis[];
    List<Integer> temp=new ArrayList<>();
    public boolean dfs(int node,int adj[],int parent){
        vis[node]=1;
        par[node]=parent;
        int child=adj[node];
        if(child==-1) return false;
        if(vis[child]==0)
        {
            if(dfs(child,adj,node)) return true;
        }
         else if(vis[child]==1)
            {
                temp.add(child);
                while(node!=child)
                {
                    if(node==-1){
                        temp.clear();
                        return false;
                    }
                    
                    temp.add(node);
                    node=par[node];
                }
                if(node==child) return true;
                temp.clear();
                return false;
            }
        return false;
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
                   if(dfs(i,edges,-1))
                   {
                    max=Math.max(max,temp.size());
                    // System.out.println(i+" "+"  "+temp);
                    temp.clear();
                   } 
            }
        }
        return max==0?-1:max;
    }
}