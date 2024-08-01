class Solution {
    public int helper(int []nums,int mid){
        int sum=0;
        for(int i:nums)
        sum+=(i+mid-1)/mid;
        return sum;
    }
    public int smallestDivisor(int[] nums, int t) {
        int max=Integer.MIN_VALUE;
        for(int i:nums)
            max=Math.max(max,i);
            System.out.println(max);
        int low=1;
        int high=max;
        while(low<=high){
            int mid=low+(high-low)/2;
            int sum=helper(nums,mid);
            if(sum<=t)
             high=mid-1;
            else
            low=mid+1;
        }

        return low;
    }
}