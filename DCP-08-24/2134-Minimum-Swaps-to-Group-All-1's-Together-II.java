class Solution {
    public int minSwaps(int[] nums) {
        int cof1=0;
        int n=nums.length;
        for(int i:nums)
         cof1+=i;
        if(cof1==0 || cof1==n) return 0;
        int i=0;
        
        int cof0=0;
         
        for(int k=0;k<cof1;k++)
            cof0+=nums[k];
         int min= cof0;;    
        while(i<n){
            cof0-=nums[i];
             cof0+=nums[(cof1+i)%n];
           min=Math.max(min,cof0);
           i++;
        }
        return cof1-min;
    }
}