class Solution {
    public int minSteps(int n) {
     boolean prime[]=new boolean[n+1];
     Arrays.fill(prime,true);
     prime[0]=false;
     prime[1]=false;
        for(int i=2;i<=n;i++)
        {
            for(int j=i+1;j<=n;j++)
            {
                if(j%i==0)
                prime[j]=false;

            }
        }
        ArrayList<Integer> l=new ArrayList<>();
        for(int i=0;i<=n;i++)
        if(prime[i])
        l.add(i);
        // System.out.println(l);
        int sum=0;
        int i=0;
        while(n>0 &&i<l.size()){
             if(n%l.get(i)==0){
                          sum+=l.get(i);
                          n/=l.get(i);
             }
             
             else
             i++;
        }
        
        return sum;
    }
}