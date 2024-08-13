class Solution {
    Set<List<Integer>> res=new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        solve(nums,0,new ArrayList<>());
        return new ArrayList<>(res);
    }
    public void swap(int a,int b,int nums[]){
        int t=nums[a];
        nums[a]=nums[b];
        nums[b]=t;
    }
    public void  solve(int nums[],int index,List<Integer> ds){
        if(index==nums.length){
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index;i<nums.length;i++)
        {
             ds.add(nums[i]);
             swap(i,index,nums);
             solve(nums,index+1,ds);
             ds.remove(ds.size()-1);
             swap(i,index,nums);
        }
    }
}