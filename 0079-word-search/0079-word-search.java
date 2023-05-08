class Solution {
    int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
    TrieNode root = new TrieNode();
    class TrieNode{
        HashMap<Character,TrieNode> children;
        Boolean isWord;
        TrieNode(){
            children = new HashMap<>();
            isWord = false;
        }
    }
    
    public void insertWord(String word){
        TrieNode cur = root;
        for(Character c : word.toCharArray()){
            if(!cur.children.containsKey(c)){
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }
    public boolean exist(char[][] board, String word) {
        insertWord(word);
        
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(board,root,i,j)) return true;
            }
        }
        return false;
    }
    
    
    public boolean dfs(char[][] board, TrieNode root, int m, int n){
        if(root.isWord) return true;
        
        
        if(m < 0 || m >= board.length || n < 0 
           || n >= board[0].length || !root.children.containsKey(board[m][n])) return false;
        
        Character temp = board[m][n];
        board[m][n] =  ' ';
        TrieNode cur = root.children.get(temp);
        for(int[] dir : directions){
            int newR = m + dir[0];
            int newC = n + dir[1];
            if(dfs(board,cur,newR,newC)) return true;
        }
        
        board[m][n] =  temp;
        return false;
    }
}