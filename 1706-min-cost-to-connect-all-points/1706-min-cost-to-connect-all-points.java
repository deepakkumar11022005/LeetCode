class pair{
    int a;
    int b;
    int wt;
    public pair(int aa,int bb,int ww)
    {
        a=aa;
        b=bb;
        wt=ww;
    }
}
class Solution {
    
    int parent[];
    int size[];
    public int find(int node)
    {
        if(node==parent[node])
        {
            return node;
        }
        return parent[node]=find(parent[node]);
    }
    public boolean union(int i,int j)
    {
        int a=find(i);
        int b=find(j);
        if(a==b) return false;
        if(size[a]>size[b])
        {
            parent[b]=a;
            size[a]+=size[b];
        }
        else{
            parent[a]=b;
            size[b]+=size[a];
        }
        return true;
    }
    public int minCostConnectPoints(int[][] points) {
        List<pair> adj=new ArrayList<>();
        int n=points.length;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j) continue;
                 adj.add(new pair(i,j,(Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]))));
            }
        }
        Collections.sort(adj,(a,b)-> a.wt-b.wt);
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++)
        {
            size[i]=1;
            parent[i]=i;
        }
        int sum=0;
        for(pair i:adj)
        {
            if(union(i.a,i.b)){
               sum+=i.wt;
            }
        }
        return sum;
    }
}