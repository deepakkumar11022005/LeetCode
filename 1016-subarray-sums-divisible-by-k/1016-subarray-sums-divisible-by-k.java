class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = ((sum + nums[i]) % k + k) % k;
            if (sum == 0)
                res++;
            res+=map.getOrDefault(sum, 0);
            map.put(sum , map.getOrDefault(sum , 0) + 1);
        }
        return res;
    }
}