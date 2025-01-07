class Solution {
    public void solve(int ind,int n,int k,List<List<Integer>> res ,List<Integer> adj ){
        if(ind>n)
        {
            if(adj.size()==k)
            res.add(new ArrayList<>(adj));
            return;
        }
        if(adj.size()==k)
        {
             res.add(new ArrayList<>(adj));
            return;
        }
        
        adj.add(ind);
        solve(ind+1,n,k,res,adj);
        adj.remove(adj.size()-1);
        solve(ind+1,n,k,res,adj);

    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        solve(1,n,k,res,new ArrayList<>());
        return res;
    }
}