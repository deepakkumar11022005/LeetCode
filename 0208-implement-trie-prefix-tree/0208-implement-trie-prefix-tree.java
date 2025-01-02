class Node {
    boolean end = false;
    Node arr[] = new Node[26];
}

class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public boolean contains(Node temp, int c) {
        return temp.arr[c] != null;
    }

    public void makeEnd(Node t) {
         t.end = true;
    }

    public boolean isEnd(Node t) {
        return t.end;
    }

    public void insert(String word) {
        Node temp = root;
 
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (!contains(temp, index))
                temp.arr[index] = new Node();
            temp = temp.arr[index];
        }
        makeEnd(temp);
    }

    public boolean search(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (!contains(temp, index))
                return false;

            temp = temp.arr[index];
        }
        return isEnd(temp);
    }

    public boolean startsWith(String prefix) {
        Node temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (!contains(temp, index))
                return false;
            temp = temp.arr[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */