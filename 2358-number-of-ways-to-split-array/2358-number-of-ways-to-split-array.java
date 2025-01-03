class Solution {
    public int waysToSplitArray(int[] nums) {
        int num = nums.length;
        long sum = 0;
        for (int i = 0; i < num; i++)
            sum += nums[i];
        long n = 0;
        int count = 0;
        for (int i = 0; i < num-1 ; i++) {
            n += nums[i];
            if (n >= (sum - n))
                count++;
        }
        return count;
    }
}