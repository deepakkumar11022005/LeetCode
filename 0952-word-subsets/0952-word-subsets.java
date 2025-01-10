class Solution {
    public List<String> wordSubsets(String[] arr1, String[] arr2) {
        int arr[] = new int[26];
        for (String s : arr2) {
            int n = s.length();
            int temp[] = new int[26];
            for (int i = 0; i < n; i++) {
                temp[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                arr[i] = Math.max(arr[i], temp[i]);
            }
        }
        List<String> l = new ArrayList<>();
        for (String s : arr1) {
            int n = s.length();
            int temp[] = new int[26];
            for (int i = 0; i < n; i++) {
                temp[s.charAt(i) - 'a']++;
            }
            boolean f = true;
            for (int i = 0; i < 26; i++) {
                if (arr[i] > temp[i])
                    f = false;
            }
            if (f)
                l.add(s);
        }
        return l;
    }
}