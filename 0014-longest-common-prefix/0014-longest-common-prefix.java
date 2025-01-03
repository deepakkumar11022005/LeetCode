class Node {
    int count;
    boolean end;
    HashMap<Character, Node> map;

    public Node() {
        count = 0;
        end = false;
        map = new HashMap<>();
    }
}

class Solution {
    private Node root;

    public Solution() {
        root = new Node();
    }

    boolean contains(Node node, char c) {
        return node.map.containsKey(c);
    }

    void incre(Node node) {
        node.count++;
    }

    void insert(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!contains(temp, c)) {
                temp.map.put(c, new Node());
            } else {
                incre(temp.map.get(c));
            }
            temp = temp.map.get(c);
        }
        temp.end = true;
    }

    public int getPre(int ind, String s) {
        Node temp = root;
        int count = 0;
        int max = Integer.MIN_VALUE;
        int n = s.length();
        while (temp.map != null && temp.map.size() == 1 && ind < n) {
            char c = s.charAt(ind);

            if (!temp.map.containsKey(c) || max > temp.map.get(c).count)
                break;
            max = Math.max(max, temp.map.get(c).count);
            // System.out.println(c);
            count++;
            ind++;
            temp = temp.map.get(c);
        }
        return count;
    }

    public String longestCommonPrefix(String[] strs) {
        for (String s : strs) {
            if (s.equals(""))
                return "";
            insert(s);
        }

        return strs[0].substring(0, getPre(0, strs[0]));
    }
}