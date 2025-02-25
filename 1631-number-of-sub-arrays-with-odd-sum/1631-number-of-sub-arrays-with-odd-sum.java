class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = (int) 1e9 + 7;
        int n = arr.length;
        int oddSum = 0;
        int evenSum = 0;
        int ans = 0;
        if (arr[0] % 2 == 0) {
            evenSum++;
            // ans++;
        } else {
            ans++;
            oddSum++;
        }
        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
            if (arr[i] % 2 == 0) {
                ans = (ans + oddSum) % mod;
                evenSum++;
            }

            else {
                ans = (ans + evenSum + 1) % mod;
                oddSum++;
            }
        }
        return ans;
    }
}