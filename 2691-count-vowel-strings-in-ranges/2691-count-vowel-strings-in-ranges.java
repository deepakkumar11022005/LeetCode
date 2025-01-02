class Solution {
    public boolean check(String s){
        if(s.length()==0) return false;
        int f=s.charAt(0);
        int l=s.charAt(s.length()-1);
        
        if((f=='a'||f=='e'||f=='i'||f=='o'||f=='u')&& (l=='a'||l=='e'||l=='i'||l=='o'||l=='u')) return true;
        return false;
    }
    public int[] vowelStrings(String[] words, int[][] q) {
        int n=words.length;
        int m=q.length;
        int dp[]=new int[n];
        if(n>0)
        dp[0]=check(words[0])?1:0;
        for(int i=1;i<n;i++)
        {
            if(check(words[i]))
            dp[i]=dp[i-1]+1;
            else
            dp[i]=dp[i-1];
        }
        int res[]=new int[m];
        int j=0;
        for(int i[]:q)
        {
            if(i[0]==0)
            res[j++]=dp[i[1]];
            else
            res[j++]=dp[i[1]]-(dp[i[0]-1]);
        }
       
        return res;
    }
}