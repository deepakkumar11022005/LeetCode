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
    static int barCount;
    static int sum;
    static int strIndex;
    int n;
    public int findNum(String traversal){
        int sum=0;
    
        while(strIndex<n && traversal.charAt(strIndex)>=48 && traversal.charAt(strIndex)<=57){
            sum=sum*10+traversal.charAt(strIndex)-'0';
            strIndex++;
        }
        // strIndex--;
        return sum;
    }
    public void dfs(String traversal, int depth,TreeNode root)
    {
        if(strIndex>n || strIndex<0) return;
        barCount=0;
        while(strIndex<n && traversal.charAt(strIndex++)=='-'){
            barCount++;
        }
        strIndex--;
        if(depth==barCount-1)
        {
            root.left=new TreeNode(findNum(traversal));
            dfs(traversal,depth+1,root.left);
            if(depth==barCount-1)
            {
                root.right=new TreeNode(findNum(traversal));
                dfs(traversal,depth+1,root.right);
            }
        }
        else{
            return;
        }
    }
    public TreeNode recoverFromPreorder(String traversal) {
        barCount=0;
        sum=0;
        strIndex=0;
        n=traversal.length();
        TreeNode root=new TreeNode(findNum(traversal));
        dfs(traversal,0,root);
        return root;
        
    }
}