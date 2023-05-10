class Solution {
    TrieNode root = new TrieNode();
    HashSet<Integer> indexSeen = new HashSet<>();
          
    class TrieNode{
        Boolean isWord;
        HashMap<Character, TrieNode> children;
        
        public TrieNode(){
            isWord = false;
            children = new HashMap<>();
        }
    }
     
    public void insertWord(String word){
        TrieNode cur = this.root;
        for(Character c : word.toCharArray()){
            if(!cur.children.containsKey(c)){
                cur.children.put(c,new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        for(String word : wordDict){
            insertWord(word);
        }
        return dfsBreak(s,root,0);
    }
    
    public boolean dfsBreak(String s, TrieNode root, int pos){
        if(pos  == s.length() ) return true;
    
        if(indexSeen.contains(pos))return false;
        indexSeen.add(pos);
        TrieNode cur = root;
        for(int i = pos; i < s.length();i++){
            Character c = s.charAt(i);
           
            cur = cur.children.get(c);
           
            if(cur == null) return false;
         
            if(cur.isWord && dfsBreak(s,root,i+1)) return true;
        }
        return false;
    }
}