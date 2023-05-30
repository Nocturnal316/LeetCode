/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialDFS(root,sb);
        return sb.toString();
    }
  public  void serialDFS(TreeNode root, StringBuilder sb) {
    // WRITE YOUR BRILLIANT CODE HERE
    if(root == null){
        sb.append("x ");
        return;
    }
    sb.append(root.val);
    sb.append(' ');
    serialDFS(root.left,sb);
    serialDFS(root.right,sb);
}

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = new ArrayList<>( Arrays.asList(data.split(" ")));
        return deserialDFS(list);
    }
    
     public  TreeNode deserialDFS(List<String> list) {    
        String root =  list.remove(0);
        if(root.equals("x")) return null;
        TreeNode  newNode = new TreeNode(Integer.parseInt(root));
        newNode.left = deserialDFS(list);
        newNode.right = deserialDFS(list);
        return newNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));