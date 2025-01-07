class Solution {
    public void solve(int nums[],int target,int ind,List<List<Integer>> res,List<Integer> ds){
          if(ind>=nums.length)
          {
            if(target==0)
            res.add(new ArrayList<>(ds));
            return;
          }
          if(target>=nums[ind])
          {
            ds.add(nums[ind]);
            solve(nums,target-nums[ind],ind,res,ds);
            ds.remove(ds.size()-1);
          }
        //   else
           solve(nums,target,ind+1,res,ds);

    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        solve(nums,target,0,res,new ArrayList<>());
        return res;
    }
}