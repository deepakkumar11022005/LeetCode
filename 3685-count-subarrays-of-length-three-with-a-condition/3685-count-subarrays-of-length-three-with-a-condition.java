class Solution {
    public boolean check(int i,int j,int nums[]){
        return ((nums[i]+nums[j])*2== nums[j-1]);
    }
    public int countSubarrays(int[] nums) {
        int i=0;
        int j=2;
        int n=nums.length;
        if(n<2) return -1;
        int count =0;
        while(j<n)
            {
                if(check(i,j,nums)){
                    count++;
                }
                i++;
                j++;
            }
        return count;
    }
}