class Solution {
    int[] dir = {0,1,0,-1,1,0,-1,0};
    TrieNode root;
    char[][] board;
    ArrayList<String> ans = new ArrayList<String>();
    public class TrieNode{
        HashMap<Character,TrieNode> children;
        TrieNode parent;
        String word;
        
        public TrieNode(){
            word = null;
            children = new HashMap<>();
            parent = null;
        }
        
        public String toString(){
            return word;
        }
    }
    public void insertWord(String word) {
        TrieNode curr = root;
        for(Character c : word.toCharArray()){
            if(!curr.children.containsKey(c)){
                curr.children.put(c,new TrieNode());
            }
            TrieNode child = curr.children.get(c);
            curr =  curr.children.get(c);
        }
        curr.word = word;
    }
   
    public void backTrack(TrieNode node,int row, int col){
      
        Character letter = board[row][col];
        TrieNode currNode = node.children.get(letter);
        //isGoal
        if(currNode.word != null){
            ans.add(currNode.word);
            currNode.word = null;
        }
        
        board[row][col] = ' ';
        //generate next valid moves
        //backtrack on those moves
        for(int i = 0; i < dir.length;i+=2){
            int newRow = row + dir[i];
            int newCol = col + dir[i+1];
            if(newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length) continue;
            if(currNode.children.containsKey(board[newRow][newCol])){
                backTrack(currNode,newRow,newCol);
            }
            
        }
        board[row][col] = letter;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        this.board = board;
        root = new TrieNode();
        for(String s : words){
             insertWord(s);
        }
        
        for(int row = 0; row < m;++row){
            for(int col = 0; col < n; ++col){
                if(root.children.containsKey(board[row][col])){
                      backTrack(root,row,col);
                }
            }
        }
        return ans;
    }
}