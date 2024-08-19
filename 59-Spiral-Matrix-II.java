class Solution {
    public int[][] generateMatrix(int n) {
          int m=n;
          int nums[][]=new int[n][n];
        int top=0;
        int bottom=m-1;
        int left=0;
        int right=n-1;
        int s=0;
        while(left <= right && top <= bottom){
            int l=left;
            while(l<=right){
                s++;
           nums[top][l++]=s;;
                // System.out.println("right");
            }
            top++;
           int t=top;
            while(t<=bottom){
                s++;
                nums[t++][right]=s;
                //  System.out.println("bot");
            }
            right--;
            int r=right;
             if (top <= bottom) {
            while(r>=left){
                s++;
                nums[bottom][r--]=s;
                // System.out.println("left");
            }
            bottom--;}
            if (left <= right) {
            int b=bottom;
            while(b>=top){
                s++;
                nums[b--][left]=s;
                // System.out.println("top");
            }
            left++;}
        }
        return nums;
    }
}