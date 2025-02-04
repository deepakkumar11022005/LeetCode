class Solution {
    public int maxAscendingSum(int[] nums) {
        int n=nums.length;
        int sum=nums[0];
        int max=sum;
        for(int i=1;i<n;i++)
        {
            if(nums[i-1]<nums[i])
            sum+=nums[i];
            else
            sum=nums[i];
            max=Math.max(max,sum);

        }
        return max;
    }
}