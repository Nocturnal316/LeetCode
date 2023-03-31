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
//     public void  helper(TreeNode root, boolean goRight,ArrayList<Integer> levelList,int level){
//         if(root == null) return;
        
//         if(goRight){
//             helper(root.left,false);
//             helper(root.right,false);
//         }else{
//             helper(root.right,true);
//             helper(root.left,true);
//         }
//    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ans = new ArrayList<>();
        if(root==null) return ans;
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            
            int size = q.size();
            ArrayList<Integer> newList = new ArrayList<>();
           
            for(int i = 0; i < size;i++){
                TreeNode  node = q.poll();
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
                newList.add(node.val);
            }
            if(level%2 != 0){
                Collections.reverse(newList);
            }
            ans.add(newList);
            level++;
        }
        return ans;
    }
}