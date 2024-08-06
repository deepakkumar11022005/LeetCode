class Solution {
    public int minimumPushes(String s) {
        
        int n=s.length();
        int arr[]=new int[26];
        for(int i=0;i<n;i++)
            arr[s.charAt(i)-'a']++;
        Arrays.sort(arr);
        int sum=0;
        for(int i=0;i<26;i++)
        {
            sum += arr[26 - i - 1] * (i / 8 + 1);
        }
        return sum;
    }
}