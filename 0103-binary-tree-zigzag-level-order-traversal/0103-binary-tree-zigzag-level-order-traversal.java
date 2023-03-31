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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        int level = 0;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> levelList = new ArrayList<>();
           
            for(int i = 0; i < size;i++){
                TreeNode  node = q.poll();
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
                levelList.add(node.val);
            }
            
            if(level%2 != 0){
                Collections.reverse(levelList);
            }
            ans.add(levelList);
            level++;
        }
        return ans;
    }
}