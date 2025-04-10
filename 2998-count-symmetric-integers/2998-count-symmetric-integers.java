class Solution {
    public boolean check(String s)
    {
        int n=s.length();
        if(n%2!=0) return false;
        int sum1=0;
        int sum2=0;
        for(int i=0;i<n/2;i++) sum1+=s.charAt(i)-'0';
        for(int i=n/2;i<n;i++) sum2+=s.charAt(i)-'0';
        return sum1==sum2;
    }
    public int countSymmetricIntegers(int low, int high) {
        int count=0;
        for(int i=low;i<=high;i++)
        {
            if(check(String.valueOf(i))) count++;
        }
        return count;
    }
}