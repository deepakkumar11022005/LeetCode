/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 
class Solution {
   
   Map<String, Integer> subtreeMap = new HashMap<>();
    // List to store the root nodes of duplicate subtrees
    List<TreeNode> duplicates = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        // Perform DFS to serialize the tree and find duplicates
        dfs(root);
        return duplicates;
    }

    private String dfs(TreeNode node) {
        if (node == null) {
            return "#"; // Use "#" to represent null nodes
        }

        // Serialize the current subtree
        String serialized = node.val + "," + dfs(node.left) + "," + dfs(node.right);

        // Count the occurrences of the serialized subtree
        subtreeMap.put(serialized, subtreeMap.getOrDefault(serialized, 0) + 1);

        // If the count becomes 2, add the node to the duplicates list (only add once)
        if (subtreeMap.get(serialized) == 2) {
            duplicates.add(node);
        }

        return serialized;
    }
}