class pair{
    int dest;
    long wt;
    public pair(int d,long w)
    {
        dest=d;
        wt=w;
    }
}
class Solution {
    int mod=(int) 1e9+7;
    public int countPaths(int n, int[][] roads) {
         List<List<pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i[]:roads)
        {
            adj.get(i[0]).add(new pair(i[1],i[2]));
            adj.get(i[1]).add(new pair(i[0],i[2]));
        }
        long dis[]=new long[n];
        long ways[]=new long[n];
        Arrays.fill(dis,Long.MAX_VALUE);
        ways[0]=1;
        dis[0]=0;
        PriorityQueue<pair> q=new PriorityQueue<>((a,b)->Long.compare(a.wt,b.wt));
        q.add(new pair(0,0));
        while(!q.isEmpty())
        {
            pair temp=q.poll();
            for(pair i:adj.get(temp.dest))
            {
                if(temp.wt+i.wt <dis[i.dest])
                {
                    dis[i.dest]=temp.wt+i.wt ;
                    q.add(new pair(i.dest,dis[i.dest]));
                    ways[i.dest]=ways[temp.dest]%mod;
                }
                else if(temp.wt+i.wt ==dis[i.dest]){
                     ways[i.dest]=(ways[i.dest]+ways[temp.dest])%mod;
                }
            }
        }
        return (int)ways[n-1]%mod;
    }
}