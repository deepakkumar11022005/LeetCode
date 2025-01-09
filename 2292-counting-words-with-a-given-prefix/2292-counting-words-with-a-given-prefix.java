class Node {
    boolean end = false;
    Node arr[] = new Node[26];
    int count = 1;
}

class Solution {
    Node root;
    public Solution() {
        root = new Node();
    }
    public void insert(String s) {
        Node temp = root;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int ind = s.charAt(i) - 'a';
            if (temp.arr[ind] == null)
                temp.arr[ind] = new Node();
            else
                temp.arr[ind].count++;
            // System.out.println(temp.count);
            temp = temp.arr[ind];
        }
        //   System.out.println("*********");
        temp.end = true;
    }

    public int search(String s) {
        Node temp = root;
        int n = s.length();
        // int c=0;
        for (int i = 0; i < n; i++) {
            int ind = s.charAt(i) - 'a';
            if (temp.arr[ind] == null)
                return 0;
            // c=temp.count;
            temp = temp.arr[ind];
        }
        return temp.count;
    }

    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String s : words)
            insert(s);
        return search(pref);
    }
}