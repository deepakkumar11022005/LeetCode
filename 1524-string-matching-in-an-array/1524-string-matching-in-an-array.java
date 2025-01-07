class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            boolean f = true;
            for (int j = 0; j < i; j++) {
                if (words[j].contains(words[i])) {
                    f = false;
                    break;
                }
            }
            for (int k = i + 1; k < n; k++) {
                if (words[k].contains(words[i])) {
                    f = false;
                    break;
                }
            }
            if (!f)
                res.add(words[i]);
        }
        return res;
    }
}