class Solution {
    public void helper(int[] nums,int i,List<Integer> ds,List<List<Integer>> res){
        if(i>=nums.length)
        {
            res.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[i]);
        helper(nums,i+1,ds,res);
        ds.remove(ds.size()-1);
        helper(nums,i+1,ds,res);

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        helper(nums,0,new ArrayList<>(),res);
        return res;
    }
}