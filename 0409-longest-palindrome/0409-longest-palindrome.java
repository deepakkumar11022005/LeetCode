class Solution {
    public int longestPalindrome(String s) {
        int freq[] = new int[128];
        int n = s.length();
        for (int i = 0; i < n; i++)
            freq[s.charAt(i)]++;
        int sum = 0;
        boolean f = true;
        for (int count : freq) {

            if ((count % 2) == 0)
                sum += count;

            else {
                if (count > 1)
                    sum += count - 1;
                f = false;
            }
        }
        return sum + (!f ? 1 : 0);

    }
}