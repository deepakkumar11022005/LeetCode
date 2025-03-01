class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                stack.add(nums[i]);
            }
        }
        int size=stack.size();
        int i = size-1;
        while (!stack.isEmpty()) {
            nums[i] = stack.pop();
            i--;
        }
        i=size;
        while (i < n) {
            nums[i] = 0;
            i++;
        }
        return nums;
    }
}