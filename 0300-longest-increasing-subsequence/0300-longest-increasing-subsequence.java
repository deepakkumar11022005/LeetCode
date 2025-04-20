class Solution {
    public int dfs(int index,int prev_index,int nums[], Integer dp[][])
    {
        if(index<0) return 0;
        if(dp[index][prev_index+1]!=null) return dp[index][prev_index+1];
        int take=-1;
        if( prev_index==-1||nums[index]<nums[prev_index])
        take=dfs(index-1,index,nums,dp)+1;
        int notTake=dfs(index-1,prev_index,nums,dp);
        return dp[index][prev_index+1]=Math.max(take,notTake);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        Integer dp[][]=new Integer[n][n+1];
        return dfs(n-1,-1,nums,dp);
    }
}