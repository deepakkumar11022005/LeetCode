class Solution {
    boolean used[];
    int ans[];
    int end;
    public boolean dfs(int res[],int index,int n)
    {
        if(index==end)
        {
            ans=Arrays.copyOf(res,end);
            return true;
        }
        if(res[index]!=0) return dfs(res,index+1,n);
        for(int i=n;i>=1;i--)
        {
            if(used[i]) continue;
            if(i==1)
            {
                res[index]=1;
                used[i]=true;
                if(dfs(res,index+1,n)) return true;
                res[index]=0;
                used[i]=false;
            } 
            else if(index+i<end && res[index+i]==0){
                res[index]=i;
                res[index+i]=i;
                used[i]=true;
                if(dfs(res,index+1,n)) return true;
                res[index]=0;
                res[index+i]=0;
                used[i]=false;

            }
        }
        return false;
    }
    public int[] constructDistancedSequence(int n) {
    end=n*2-1;
    used=new boolean[n+1];
    ans=new int[end];
    int res[]=new int[end];
    dfs(res,0,n);
    return ans;
    }
}