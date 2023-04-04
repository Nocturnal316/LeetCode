class Solution {
    int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
    TrieNode root;
    public class TrieNode{
        Boolean isWord;
        HashMap<Character,TrieNode> children;
        TrieNode parent;
        String name;
        Boolean visited;
        int r, c;
        
        public TrieNode(){
            isWord = false;
            children = new HashMap<>();
            parent = null;
            visited = false;
        }
        
        public TrieNode(int r, int c){
            this.r =r;
            this.c =c;
            isWord = false;
            children = new HashMap<>();
            parent = null;
            visited = false;
        }
        
        public String toString(){
            return name;
        }
    }
    
     public void insertWord(String word) {
        TrieNode curr = root;
        for(Character c : word.toCharArray()){
            if(!curr.children.containsKey(c)){
                curr.children.put(c,new TrieNode());
            }
            curr =  curr.children.get(c);
        }
        curr.isWord = true;
    }
    
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        System.out.println(m);
        
        root = new TrieNode();
        insertWord(word);
        
        for(int row = 0; row < m;row++){
            for(int col = 0; col < n; col++){
                if(dfs(root,board,row,col))return true;
            }
        }
    
        return false;
    }
    
    public boolean dfs(TrieNode root,char[][] board, int i, int j){
        if(root.isWord) return root.isWord;
        
        if(i<0 || j < 0 || i >= board.length || j >= board[0].length ||
          !root.children.containsKey(board[i][j])) return false;
        
        Character temp = board[i][j];
        board[i][j] =  ' ';
       
        TrieNode child = root.children.get(temp);
        if(dfs(child,board,i+1,j)||dfs(child,board,i-1,j)
           ||dfs(child,board,i,j+1)||dfs(child,board,i,j-1)) return true;
        board[i][j]=temp;
        
        return false;
    }
    
}