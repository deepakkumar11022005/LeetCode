class Solution {
    public int numMagicSquaresInside(int[][] nums) {
        int c=0;
        int n=nums.length;
        int m=nums[0].length;
        if(n<3 && m<3)
        return 0;
        for(int i=0;i<n-2;i++)
        {
             for(int j=0;j<m-2;j++)
            if(check(nums,i,j))
            c++;
        }
        return c;
    }
    public boolean check(int [][]grid,int row,int col){
      
         HashSet<Integer> set = new HashSet<>();
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                int num = grid[i][j];
                if (num < 1 || num > 9 || !set.add(num)) {
                    return false;   
                }
            }
        }
        int sum = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
          for (int i = 0; i < 3; i++) {
            if (grid[row + i][col] + grid[row + i][col + 1] + grid[row + i][col + 2] != sum) {
                return false;
            }
        }
        
        for (int j = 0; j < 3; j++) {
            if (grid[row][col + j] + grid[row + 1][col + j] + grid[row + 2][col + j] != sum) {
                return false;
            }
        }
        
   
        if (grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2] != sum) {
            return false;
        }
        if (grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col] != sum) {
            return false;
        }
        
        return true;
         
    }
}