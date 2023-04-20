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
    List<List<Integer>> ans;
    public List<List<Integer>> levelOrder(TreeNode root) {
       
        int levels = getHeight(root);
         ans = new ArrayList<>();
        for(int i = 0; i < levels; i++){
            ans.add(new ArrayList<Integer>());
        }
        
        dfs(root,0);
        return ans;
    }
    
    public void dfs(TreeNode root, int level){
        if(root == null) return;
        
        List<Integer> t = ans.get(level);
        t.add(root.val);
        
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
    
    public int getHeight(TreeNode t){
        if(t == null) return 0;
        int l = getHeight(t.left);
        int r = getHeight(t.right);
        
        if(l > r){
            return l + 1;
        }else{
            return r + 1;
        }
    }
        
}