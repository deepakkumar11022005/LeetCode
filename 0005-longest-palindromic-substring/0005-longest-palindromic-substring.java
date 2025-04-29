class Solution {
    public int solve(String s,int i,int j){
        int n=s.length();
        while(i>=0 && j<n && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }
    public String longestPalindrome(String s) {
        if(s==null || s.length()<1) return "";
        int n=s.length();
        int start=0;
        int end=0;
        for(int i=0;i<n;i++)
        {
            int l1=solve(s,i,i);
            int l2=solve(s,i,i+1);
            int len=Math.max(l1,l2);
            if(len>end-start)
            {
                start=i-(len-1)/2;
                end=i+(len)/2;
            }
        }
        return s.substring(start,end+1);
    }
}