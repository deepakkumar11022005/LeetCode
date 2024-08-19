class Solution {
    public List<Integer> spiralOrder(int[][] nums) {
        int m=nums.length;
        int n=nums[0].length;
        int top=0;
        int bottom=m-1;
        int left=0;
        int right=n-1;
        List<Integer> res=new ArrayList<>();

        while(left <= right && top <= bottom){
            int l=left;
            while(l<=right){
                res.add(nums[top][l++]);
                // System.out.println("right");
            }
            top++;
           int t=top;
            while(t<=bottom){
                 res.add(nums[t++][right]);
                //  System.out.println("bot");
            }
            right--;
            int r=right;
             if (top <= bottom) {
            while(r>=left){
                res.add(nums[bottom][r--]);
                // System.out.println("left");
            }
            bottom--;}
            if (left <= right) {
            int b=bottom;
            while(b>=top){
                res.add(nums[b--][left]);
                // System.out.println("top");
            }
            left++;}
        }
        return res;
    }
}