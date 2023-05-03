/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //could use regular list or deque
        //but arraydeque does not have elemntAt
        Stack<TreeNode> path1 = new Stack();
        Stack<TreeNode> path2 = new Stack();
        dfs(root,p,path1);
        dfs(root,q,path2);
        
        //only need to run along the shortest path
        int min =  Math.min(path1.size(),path2.size());
        TreeNode common = null;
        for(int i = 0; i < min;i++){
            if(path1.elementAt(i) != path2.elementAt(i)){
                break;
            }
            common = path1.elementAt(i);
        }
        return common;
    }
    
    public boolean dfs(TreeNode root, TreeNode target,  Stack<TreeNode> path){
        if(root == null) return false;
        
        if(root.val == target.val){
            //since a node can be descendant of itself
            path.push(root);
            return true;
        }
        
        path.push(root);
    
        boolean left = dfs(root.left,target,path);
        boolean right = dfs(root.right, target,path);
        
        if(left || right){
            return true;
        }
        path.pop();
        return false;
    }
}