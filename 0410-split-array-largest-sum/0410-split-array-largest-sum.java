class Solution {
    public int check(int nums[],int cap)
    {
        int d=0;
        int sum=0;
        for(int i:nums)
        {
            if(sum+i>cap)
            {
                d++;
                sum=i;
            }
            else{
                sum+=i;
            }
        }
        return d+1;
    }
    public int splitArray(int[] nums, int k) {
        int tsum=0;
        int max=Integer.MIN_VALUE;
        for(int i:nums)
        {
            tsum+=i;
            max=Math.max(max,i);
        }
        int i=max;
        int j=tsum;
        while(i<=j)
        {
            int  mid=(i+j)/2;
            if(check(nums,mid)<=k){
                j=mid-1;
            }
            else
            {
                i=mid+1;
            }
        }
        return i;
    }
}