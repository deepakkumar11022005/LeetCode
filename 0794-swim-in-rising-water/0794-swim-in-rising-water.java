class pair{
    int i;
    int j;
    int time;
    public pair(int  ii,int jj,int t)
    {
        time=t;
        i=ii;
        j=jj;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int row[]={1,-1,0,0};
        int col[]={0,0,1,-1};
        PriorityQueue<pair> q=new PriorityQueue<>((a,b)-> (a.time-b.time));
        q.add(new pair(0,0,grid[0][0]));
        boolean vis[][]=new boolean[n][m];
        vis[0][0]=true;
        int min=Integer.MAX_VALUE;
        while(!q.isEmpty())
        {
            pair temp=q.poll();
            if(temp.i==n-1 && temp.j==m-1)
            {
                min=Math.min(min,temp.time);
                return min;
            }
            for(int i=0;i<4;i++)
            {
               int r=temp.i+row[i];
               int c=temp.j+col[i];
               if(r>=0 && r<n && c>=0 && c<m && !vis[r][c])
               {
                vis[r][c]=true;
                // if(grid[temp.i][temp.j]<grid[r][c])
                // q.add(new pair(r,c,temp.time+(grid[r][c]-grid[temp.i][temp.j])));
                // else
                q.add(new pair(r,c,Math.max(temp.time,grid[r][c])));
              
               }
            }
        }
        return min;
    }
}