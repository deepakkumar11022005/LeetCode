class Solution {
    public int maxScore(String s) {
        int max=0;
        for(int i=0;i<s.length()-1;i++)
        {
            int a=s.substring(0,i+1).replace("1","").length();
            int b=s.substring(i+1).replace("0","").length();
            max=Math.max(max,a+b);
        }
        return max;
    }
}