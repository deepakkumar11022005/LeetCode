class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Long> map = new HashMap<>();
        int n = nums.length;
        long res = (long) n * (n - 1) / 2;

        for (int i = 0; i < n; i++) {
            int diff = nums[i] - i;
            if (map.containsKey(diff)) {
                res -= map.get(diff);
                map.put(diff, map.get(diff) + 1);
            } else {
                map.put(diff, 1L);
            }
        }

        return res;
    }
}
