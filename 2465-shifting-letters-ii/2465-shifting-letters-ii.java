class Solution {
    public void fwd(int arr[], int a, int b) {
          arr[a]++;
         arr[b+1]--;
    }
     public void back(int arr[], int a, int b) {
         arr[a]--;
         arr[b+1]++;
    }
    public void shift(char arr[],int ind,int shft)
    {
          arr[ind]=(char)(((arr[ind]+shft-97+26)%26)+97);
    }
    public String shiftingLetters(String s, int[][] nums) {
        int n=s.length();
        int arr[] = new int[n+1];
        char c[]=s.toCharArray();
        for (int i[] : nums)
            if (i[2] == 0)
                back(arr, i[0], i[1]);
            else
                fwd(arr, i[0], i[1]);
        shift(c,0,arr[0]%26);
        for(int i=1;i<n;i++)
        {
         arr[i]=arr[i]+arr[i-1];  
         shift(c,i,arr[i]%26); 
        }
        
        return new String(c);
    }
}