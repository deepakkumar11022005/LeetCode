class Solution {
    public void dfs(int nums[], int ind, List<List<Integer>> res, List<Integer> adj) {
        if (ind >= nums.length) {
            res.add(new ArrayList<>(adj));
            return;
        }
        adj.add(nums[ind]);
        dfs(nums, ind + 1, res, adj);
        adj.remove(adj.size() - 1);
        dfs(nums, ind + 1, res, adj);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, res, new ArrayList<>());
        return res;
    }
}