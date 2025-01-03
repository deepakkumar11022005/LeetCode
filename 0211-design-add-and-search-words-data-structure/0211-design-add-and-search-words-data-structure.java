class Node {
    boolean end = false;
    Node arr[] = new Node[26];

}

class WordDictionary {
    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public boolean contains(Node t, int i) {
        return t.arr[i] != null;
    }

    public void addWord(String word) {
        Node temp = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            int ind = word.charAt(i) - 'a';
            if (!contains(temp, ind))
                temp.arr[ind] = new Node();
            temp = temp.arr[ind];
        }
        temp.end = true;
    }

    public boolean dfs(Node root, String s, int ind) {
        if(root==null) return false;
        Node temp = root;
        if (ind == s.length())
            return temp.end;
            char c = s.charAt(ind);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (temp.arr[i] != null) {
                    if (dfs(temp.arr[i], s, ind + 1))
                        return true;
                }

            }
            return false;
        } else {
            if (!contains(temp, c - 'a'))
                return false;
            return dfs(temp.arr[c - 'a'], s, ind + 1);
        }
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */