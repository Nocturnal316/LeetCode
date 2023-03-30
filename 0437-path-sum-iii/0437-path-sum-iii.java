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
   
    int ans = 0;
    HashMap<Long,Integer> map;
    
    public void helper(TreeNode root, int targetSum, Long curSum){
        
        if(root == null) return;
        
        long pref = root.val + curSum;
        long comp = pref-targetSum;
        
        ans+= map.getOrDefault(comp,0);
        
        map.put(pref,map.getOrDefault(pref,0)+1);
        
        helper(root.left,targetSum,pref);
        
        helper(root.right,targetSum,pref);
        
        map.put(pref,map.getOrDefault(pref,0)-1);
        
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
         
        map = new HashMap<>();
        map.put(0L,1);
        
        helper(root,targetSum,0L);
        return ans;
    }
}