class Solution {
    public boolean isArraySpecial(int[] nums) {
        boolean res=true;
        int n=nums.length;
        for(int i=1;i<n;i++)
        {
            int a=(nums[i] & 1);
            int b=(nums[i-1] & 1);
            if(a==b){
           res=false;
            }
        }
        return res;
    }
}