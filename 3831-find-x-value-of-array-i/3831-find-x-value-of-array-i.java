class Solution {
    public long solve(int index,int rem,int prod,int nums[],int n,int k,Long dp[][])
    {
        if(index>=n) return 0;
        if(dp[index][prod+1]!=null) return dp[index][prod+1];
        long take=0,notTake=0,count=0;
        if(prod==-1){
            if(nums[index]==rem) count=1;
            take=count+solve(index+1,rem,nums[index],nums,n,k,dp);
            notTake=solve(index+1,rem,prod,nums,n,k,dp);
        }
        else{
            int newProd=prod*nums[index]%k;
            if( newProd==rem) count=1;
            take=count+solve(index+1,rem,newProd,nums,n,k,dp);

        }
        return dp[index][prod+1]=take+notTake;
    }
    public long[] resultArray(int[] nums, int k) {
        long res[]=new long[k];
        int n=nums.length;
        for(int i=0;i<n;i++) nums[i]%=k;
        Long dp[][];
        for(int rem=0;rem<k;rem++)
        {
            dp=new Long[n][k+1];
            res[rem]=solve(0,rem,-1,nums,n,k,dp);
        }
        return res;
    }
}