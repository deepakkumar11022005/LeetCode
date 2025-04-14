class Solution {
    public int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        if (n == 1) return 5;

        long mid = n / 2;
        long res1 = 1, res2 = 1;
        long base1 = 4, base2 = 5;

        while (mid > 0) {
            if (mid % 2 == 1) {
                res1 = (res1 * base1) % MOD;
                res2 = (res2 * base2) % MOD;
            }
            base1 = (base1 * base1) % MOD;
            base2 = (base2 * base2) % MOD;
            mid /= 2;
        }

        if (n % 2 == 1) res2 = (res2 * 5) % MOD;

        return (int)((res1 * res2) % MOD);
    }
}
