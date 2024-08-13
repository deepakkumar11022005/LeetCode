class Solution {
    Set<List<Integer>> res=new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        solve(nums,0);
        return new ArrayList<>(res);
    }
    public void swap(int a,int b,int nums[]){
        int t=nums[a];
        nums[a]=nums[b];
        nums[b]=t;
    }
    public void  solve(int nums[],int index){
        if(index==nums.length){
            List<Integer> ds=new ArrayList<>();
            for(int j:nums)
            ds.add(j);
            res.add(ds);
            return;
        }
        for(int i=index;i<nums.length;i++)
        {
             swap(i,index,nums);
             solve(nums,index+1);
             swap(i,index,nums);
        }
    }
}