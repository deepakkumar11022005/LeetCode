class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n=nums.length;
        int incre=1;
        int decre=1;
        int max=1;
        for(int i=1;i<n;i++)
        {
            if(nums[i-1]<nums[i])
            {
                incre++;
                
            }
            else
            {
                incre=1;
            }
            if(nums[i-1]>nums[i])
            {
                decre++;
            }
            else{
                decre=1;
            }
            max=Math.max(max,Math.max(incre,decre));
        }
        return max;
    }
}