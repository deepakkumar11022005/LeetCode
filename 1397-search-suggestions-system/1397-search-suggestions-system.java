class Node {
    boolean end = false;
    Node arr[] = new Node[26];
}

class Solution {
    private Node root;
    List<List<String>> res;

    public Solution() {
        root = new Node();
        res = new ArrayList<>();
    }

    public boolean contains(Node t, int ind) {
        return t.arr[ind] != null;
    }

    public boolean isEnd(Node t) {
        return t.end;
    }

    public void makeEnd(Node t) {
        t.end = true;
    }

    public void dfs(List<String> l, Node temp, String str) {

        if (l.size() == 3)
            return;
        if (isEnd(temp)) {
            l.add(str);
        }

        for (int i = 0; i < 26; i++) {
            if (temp.arr[i] != null) {
                dfs(l, temp.arr[i], str + (char) (i + 'a'));
            }
        }
    }

    public void prefix(String str) {
        Node temp = root;
        List<String> l = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            int ind = str.charAt(i) - 'a';
            if (!contains(temp, ind)) {
                {
                    res.add(l);
                    return;
                }
            }
            temp = temp.arr[ind];
        }

        dfs(l, temp, str);

        res.add(l);
    }

    public void insert(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) - 'a';
            if (!contains(temp, ind)) {
                temp.arr[ind] = new Node();
            }
            temp = temp.arr[ind];
        }
        makeEnd(temp);
    }

    public List<List<String>> suggestedProducts(String[] products, String srh) {

        for (String product : products) {
            insert(product);
        }

        int m = srh.length();
        for (int i = 0; i < m; i++) {
            String prefix = srh.substring(0, i + 1);
            prefix(prefix);
        }

        return res;
    }
}
