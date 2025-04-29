public class Solution {
    public int[] constructLps(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int len = 0, i = 1;
        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                lps[i++] = ++len;
            } else if (len != 0) {
                len = lps[len - 1];
            } else {
                i++;
            }
        }
        return lps;
    }

    public String longestPrefix(String s) {
       
        int[] lps = constructLps(s);
        int matchLength = lps[lps.length - 1];
        return s.substring(0, matchLength);
    }
}
