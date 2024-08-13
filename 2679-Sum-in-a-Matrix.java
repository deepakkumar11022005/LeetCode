class Solution {
    public int matrixSum(int[][] nums) {
        int sum = 0;
        int n = nums.length;
        int m = nums[0].length;
        for(int i=0;i<n;i++)
        Arrays.sort(nums[i]);
        for (int i = 0; i < m; i++) {
            int max=-999;
            for (int j = 0; j < n; j++) {
                  if(max<nums[j][i])
                  max=nums[j][i];
            }
            sum+=max;
        }
         return sum;
    }
}