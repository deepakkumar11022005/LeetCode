class Solution {
    public int solve(int nums[],int target,int index,int dp[][])
    {
        if (index == 0) {
 
            if (target == 0 && nums[0] == 0)
                return 2;
 
            if (target == 0 || target == nums[0])
                return 1;
            return 0;
        }
        if(dp[index][target]!=-1) return dp[index][target];
        int take=0;
        if(target>=nums[index])
        take=solve(nums,target-nums[index],index-1,dp);
        int notTake=solve(nums,target,index-1,dp);
        return dp[index][target]=take+notTake;
        
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        int count0=0;
        for (int i : nums)
        {
                  sum += i;
                  if(i==0) count0++;
        }
          
        if (sum<target ||((sum-target)%2) == 1)
            return 0;
        int dp[][]=new int[nums.length][(sum - target)/2 +1];
        for(int i[]:dp)
        Arrays.fill(i,-1);
        return solve(nums, (sum - target)/2, nums.length - 1,dp)  ;

    }
}