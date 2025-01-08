class Solution {
    public int countPrefixSuffixPairs(String[] words) {

        int c=0;
        for(int i=0;i<words.length;i++)
        {
          String s=words[i];
           for(int j=i+1;j<words.length;j++)
           {
            if(words[i].length()<=words[j].length())
            if(words[j].startsWith(s) && words[j].endsWith(s))
            c++;
        }
        }
        
        return c;
    }
}