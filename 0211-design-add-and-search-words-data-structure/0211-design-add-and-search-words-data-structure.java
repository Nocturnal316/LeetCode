class WordDictionary {
    class TrieNode{
        boolean isWord;
        HashMap<Character, TrieNode> children;
        
        public TrieNode(){
            isWord = false;
            children = new HashMap<>();
        }
    }
    
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode cur = root;
        
        for(Character c : word.toCharArray()){
            if(!cur.children.containsKey(c)){
                cur.children.put(c,new TrieNode());
            }
            
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        return searchHelper(root,word);
    }
    
    public boolean searchHelper(TrieNode root, String word){
         TrieNode cur = root;
        
        for(int i =  0; i < word.length();i++){
            Character c = word.charAt(i);
            if(!cur.children.containsKey(c) ){
                if(c == '.'){
                    for(char x: cur.children.keySet()){
                        TrieNode nextNode = cur.children.get(x);
                        if(searchHelper(nextNode,word.substring(i+1))) return true;
                    }                  
                }
                
                return false;
            }else{
                cur = cur.children.get(c);
            }
            
        }
        return cur.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */