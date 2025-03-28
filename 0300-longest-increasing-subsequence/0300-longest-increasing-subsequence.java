class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int arr[]=new int[n];
        Arrays.fill(arr,1);
        int max=1;
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[j]<nums[i])
                arr[i]=Math.max(arr[i],arr[j]+1);
            }
            max=Math.max(max,arr[i]);
        }
        return max;
    }
}