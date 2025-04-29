class Solution {
    public long countSubarrays(int[] nums, int k) {
        long count = 0;
        int j = 0;
        int n = nums.length;
        int max = -1;
        
        for (int i : nums) max = Math.max(max, i);
        
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] == max) sum++;
            
            while (sum >= k) {
                if (nums[j] == max) sum--;
                j++;
            }
            
            count += j;
        }
        
        return count;
    }
}
