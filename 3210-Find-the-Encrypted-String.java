class Solution {
    public String getEncryptedString(String s, int k) {
        int n=s.length();
        char arr[]=s.toCharArray();
        for(int i=0;i<n;i++)
        {
            arr[i]=s.charAt((i+k)%n);
             
        }
        return   new String(arr);
    }
}