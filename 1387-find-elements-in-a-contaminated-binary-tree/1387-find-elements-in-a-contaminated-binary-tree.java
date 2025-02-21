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
class FindElements {
     HashSet<Integer> set;
    TreeNode root;
    public void dfs(TreeNode root)
    {
        if(root==null) return;
        set.add(root.val);
        if(root.left!=null){
            root.left.val=2*root.val+1;
        }
        if(root.right!=null)
        {
            root.right.val=2*root.val+2;
        }
        dfs(root.left);
        dfs(root.right);
    }
    public FindElements(TreeNode root) {
        set=new HashSet<>();
        this.root=root;
        root.val=0;
        dfs(root);
        System.out.println(set);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */