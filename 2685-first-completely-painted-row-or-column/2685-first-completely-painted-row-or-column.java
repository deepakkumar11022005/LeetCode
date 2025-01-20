class pair{
    int i;
    int j;
    public  pair(int ii,int jj){
        i=ii;
        j=jj;
    }
}
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int num=arr.length;
        int row[]=new int[n];
        int col[]=new int[m];
       
        HashMap<Integer,pair> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                map.put(mat[i][j],new pair(i,j));
            }
        }
        for(int i=0;i<num;i++)
        {
           pair temp= map.get(arr[i]);
           row[temp.i]++;
      
           if(row[temp.i]==m) return i;
             col[temp.j]++;
      
           if(col[temp.j]==n) return i;
 
        }
       
       return -1;
    }
}