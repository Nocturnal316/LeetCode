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
    int startIndx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder,inorder,0,preorder.length-1);
    }
    
    public TreeNode dfs(int[] preorder, int[] inorder, int left, int right){
        if(startIndx == inorder.length  || right < left){
            return null;
        }
        TreeNode root = new TreeNode(preorder[startIndx]);
        int num = preorder[startIndx];
        for(int i = left; i <= right;i++){
            if(inorder[i] == num){
                startIndx+=1;
                root.left = dfs(preorder,inorder,left,i-1);
                root.right = dfs(preorder,inorder,i+1,right);
                break;
            }
        }
        return root;
        
    }
}