class Solution {
    char arr[] = { 'a', 'b', 'c' };
    List<String> res = new ArrayList<>();
    int num;
    int kk;

    public boolean dfs(int index, String str) {
        if (res.size() == kk)
            return true;
        if (index >= num) {
            res.add(str);
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (str.charAt(index - 1) != arr[i])
                dfs(index + 1, str + arr[i]);
        }
        return false;
    }

    public String getHappyString(int n, int k) {
        num = n;
        kk = k;
        for (int i = 0; i < 3; i++) {
            if (dfs(1, ("" + arr[i])))
                break;
            
        }
        // System.out.println(res);
        return  res.size()<k ? "": res.get(res.size()-1);

    }
}
