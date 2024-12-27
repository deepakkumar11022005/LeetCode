class pair {
    int i;
    int val;

    public pair() {
        val = Integer.MIN_VALUE;
    }

    public pair(int ii, int v) {
        i = ii;
        val = v;
    }
}

class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        pair max = new pair(0, values[0]);
        int m = Integer.MIN_VALUE;
        int temp = values[0];
        for (int j = 1; j < n; j++) {
            m = Math.max(m, max.val + max.i + values[j] - j);
            if (temp <= values[j] + j) {
                temp = values[j] + j;
                max = new pair(j, values[j]);
            }
        }
        return m == Integer.MIN_VALUE ? max.i + max.val + values[n - 1] - n - 1 : m;
    }
}