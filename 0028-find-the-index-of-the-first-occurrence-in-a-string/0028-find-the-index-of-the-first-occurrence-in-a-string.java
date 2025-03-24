class Solution {
    public int[] constuctLps(int pat[], String needle) {
        int len = 0;
        int i = 1;
        pat[0] = 0;
        int n = needle.length();
        while (i < n) {
            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
                pat[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = pat[len - 1];

                } else {
                    pat[i]=0;
                    i++;
                }
            }
        }
        return pat;
    }

    public int strStr(String haystack, String needle) {
        int pat[] = constuctLps(new int[needle.length()], needle);
        int i=0;
        int j=0;
        int n=haystack.length();
        int m=needle.length();
        while(i<n)
        {
            if(haystack.charAt(i)==needle.charAt(j))
            {
                i++;
                j++;
                if(j==m)
                {
                    return i-j;
                }
            }
            else{
                if(j!=0)
                {
                    j=pat[j-1];
                }
                else{
                    i++;
                }
            }
        }
           return -1;
    }
}