/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Tuple {
    TreeNode node;
    int vertex;
    int level;

    public Tuple(TreeNode node, int vertex, int level) {
        this.node = node;
        this.vertex = vertex;
        this.level = level;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Tuple> q = new LinkedList<Tuple>();
        TreeMap<Integer, TreeMap<Integer,List<Integer>>> map = new TreeMap<>();
        q.add(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            TreeNode temp = q.peek().node;
            int vertex = q.peek().vertex;
            int level = q.peek().level;
            if (temp.left != null)
                q.add(new Tuple(temp.left, vertex - 1, level + 1));
            if (temp.right != null)
                q.add(new Tuple(temp.right, vertex + 1, level + 1));
            q.poll();
            map.putIfAbsent(vertex, new TreeMap<>());
            map.get(vertex).putIfAbsent(level, new ArrayList<>());
            map.get(vertex).get(level).add(temp.val);

        }
       List<List<Integer>> res = new ArrayList<>();
        for (TreeMap<Integer, List<Integer>> levelMap : map.values()) {
            List<Integer> sortedList = new ArrayList<>();
            for (List<Integer> levelList : levelMap.values()) {
                Collections.sort(levelList);
                sortedList.addAll(levelList);
            }
            res.add(sortedList);
        }
        return res;
    }
}