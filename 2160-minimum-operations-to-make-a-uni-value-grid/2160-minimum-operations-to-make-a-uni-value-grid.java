class Solution {
    public int check(int mid, int arr[], int x) {
        int count = 0;
        int remainder = arr[0] % x;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % x != remainder)
                return -1;
            count += Math.abs(arr[i] - mid);
        }
        return count/x;
    }

    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        int arr[] = new int[n * m];
        int k = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                arr[k++] = grid[i][j];
        Arrays.sort(arr);
        int mid = (n * m) / 2 - 1;
        int a = -1;
        if (mid >= 0 && mid < n * m) {
            a = check(arr[mid], arr, x);
            //  System.out.println(a + "  mid:" + arr[mid]  );
        }
        int b = -1;
        if (mid + 1 < n * m) {
            b = check(arr[mid + 1], arr, x);
            //  System.out.println(b/ + "  mid:" + arr[mid+1]  );
        }
       
        return a == -1 && b == -1 ? -1 : Math.min(a == -1 ? Integer.MAX_VALUE : a, b == -1 ? Integer.MAX_VALUE : b);
    }
}