 class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(max, Math.abs(sum));
            if (sum < 0)
                sum = 0;
            sum2 += nums[i];
            min = Math.min(min, sum2);
            if (sum2 > 0)
                sum2 = 0;

        }

         
        return Math.max(max, Math.abs(min));
    }
}