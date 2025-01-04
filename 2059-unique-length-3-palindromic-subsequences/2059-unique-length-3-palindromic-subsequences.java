class Solution {
    public void findLast(int arr[],String s,int n)
    {
        for(int i=0;i<n;i++)
        {
            arr[s.charAt(i)-'a']=i;
        }
    }
    public int check(String s,int i,int j)
    {
        HashSet<Character> set=new HashSet<>();
        for(int k=i+1;k<j;k++)
        {
              set.add(s.charAt(k));
        }
        // System.out.println(set.size());
        return set.size();

    }
    public int countPalindromicSubsequence(String s) {
        int lastInd[] = new int[26];
        int n = s.length();
        Arrays.fill(lastInd,-1);
        findLast(lastInd, s, n);
        int  count=0;
        int i=0;
        n-=2;
        while(i<n)
        {
            char c=s.charAt(i);
            if(lastInd[c-'a']!=-1)
            {
                count+=check(s,i,lastInd[c-'a']);
                lastInd[c-'a']=-1;
            }
            i++;
        }
        return count;
    }
}