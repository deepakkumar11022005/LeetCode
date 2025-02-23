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
    public TreeNode dfs(int postorder[],int postStart,int postEnd,int []inorder,int inStart,int inEnd,HashMap<Integer,Integer> map)
    {
        if(postStart>postEnd || inStart>inEnd) return null;
        TreeNode root=new TreeNode(postorder[postEnd]);
        int inRoot=map.get(root.val);
        int numLeft=inRoot-inStart;

        root.left=dfs(postorder,postStart,postStart+numLeft-1,inorder,inStart,inRoot-1,map);
        root.right=dfs(postorder,postStart+numLeft,postEnd-1,inorder,inRoot+1,inEnd,map);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
           map.put(inorder[i],i);
        return dfs(postorder,0,n-1,inorder,0,n-1,map);
    }
}