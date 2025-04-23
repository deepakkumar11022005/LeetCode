class Solution {
    public int sum(int i)
    {
        int sum=0;
        while(i>0){
            sum+=i%10;
            i/=10;
        }
        return sum;
    }
    public int find(int target,int arr[],int n){
      int i=n-1;
      while(i>=0){
        if(arr[i]==target) i--;
        else break;
      }
      return n-i-1;
    }
    public int countLargestGroup(int n) {
        int arr[]=new int[n];
        for(int i=1;i<=n;i++) {
            arr[sum(i)-1]++;
        }
        Arrays.sort(arr);
        
        return find(arr[n-1],arr,n);
    }
}