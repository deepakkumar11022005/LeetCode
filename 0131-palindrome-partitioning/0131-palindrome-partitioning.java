class Solution {
    List<List<String>> res;
    int end;
    public boolean isPalin(String s, int start,int ed)
    {
        while(start<=ed)
        {
            if(s.charAt(start)!=s.charAt(ed)) return false;
            start++;
            ed--;
        }
        return true;
    }
    public void dfs(int index,String s,List<String> ds)
    {
        if(index>=end) {
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index;i<end;i++)
        {
            if(isPalin(s,index,i)){
                ds.add(s.substring(index,i+1));
                dfs(i+1,s,ds);
                ds.remove(ds.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        end=s.length();
        res=new ArrayList<>();
        List<String> ds=new ArrayList<>();

        dfs(0,s,ds);
        return res;
    }
}