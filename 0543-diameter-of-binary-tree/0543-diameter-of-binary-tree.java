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
    int diameter = 0;
    
    public int countDiameter(TreeNode root){
        if(root == null) return 0 ;
        
        int l = countDiameter(root.left);
        int r = countDiameter(root.right);
        diameter = Math.max(diameter,l+r);
        
        return Math.max(l, r)+1;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        countDiameter(root);
        return diameter;
    }
}