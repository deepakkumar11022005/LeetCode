class Solution {
    int num;

    public boolean dfs(int index,String str,List<Integer> ds){
        if(index>=str.length()){
            int sum=0;
            for(int j:ds)
            sum+=j;
           

            return sum==num;
        }
        for(int i=index;i<str.length();i++){
            ds.add(Integer.parseInt(str.substring(index,i+1)));
           if( dfs(i+1,str,ds)) return true;;
            ds.remove(ds.size()-1);
        }
        return false;

    }
    public int punishmentNumber(int n) {
        int sum=0;
        
        for(int i=1;i<=n;i++)
        {
           num=i;
           if(dfs(0,String.valueOf(i*i),new ArrayList<>())){
              sum+=i*i;
            //   System.out.println(i);
           }
          
        }
        return sum;
    }
}