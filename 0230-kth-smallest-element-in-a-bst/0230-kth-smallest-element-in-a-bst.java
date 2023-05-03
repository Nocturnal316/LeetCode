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
    PriorityQueue<Integer> que = new PriorityQueue<>((a,b)->b-a);
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root,k);
        System.out.println(que);
        return que.peek();
    }
    
    public void inOrder(TreeNode root,int k){
        if(root == null) return;
        
        inOrder(root.left,k);
       
        que.add(root.val);
        if(que.size() > k) que.poll();
        inOrder(root.right,k);
    }
}