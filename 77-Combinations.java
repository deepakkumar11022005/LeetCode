class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>  res=new ArrayList<>();
        solve(1,n,k,res,new ArrayList<>());
        return res;
    }
    public void solve(int i,int n,int k,List<List<Integer>> res,ArrayList<Integer> ds ){
        if(i>=n+1)
        {
            if(ds.size()==k)
            res.add(new ArrayList<>(ds));
            return ;
        }
        ds.add(i);
        solve(i+1,n,k,res,ds);
        ds.remove(ds.size()-1);
        solve(i+1,n,k,res,ds);

    }
}