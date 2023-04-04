class Trie {
    TrieNode root;
    class TrieNode{
        Boolean isWord;
        HashMap<Character,TrieNode> children;
        TrieNode parent;
        String name;
        
        
        public TrieNode(){
            isWord = false;
            children = new HashMap<>();
            parent = null;
        }
        
        public String toString(){
            return name;
        }
    }
   
    
    public Trie() {
        root = new TrieNode();
        root.name = "Root";
    }
    
    public void insert(String word) {
        if(word.length() == 0) return;
        
        Character c = word.charAt(0);
        TrieNode child = root.children.getOrDefault(c,new TrieNode());
        child.name = c.toString();
        child.parent = root;
        
        if(!root.children.containsKey(c)){
            root.children.put(c,child);
        }
        
        String subString = word.substring(1);
        
        insertHelper(subString,child);
    }
    
    public boolean search(String word) {
        if(word.length() == 0)return true;
        return searchHelper(word,root);
    }
    
    public boolean searchHelper(String word,TrieNode root){
        if(word.length() == 0 && root != null) return root.isWord;
        if(root == null) return false;
        return searchHelper(word.substring(1),
                            root.children.getOrDefault(word.charAt(0),null));
    }
    
    public boolean startsWith(String prefix) {
        if(prefix.length() == 0) return true;
        return startHelper(prefix,root);
    }
    
    public boolean startHelper(String word,TrieNode root){
        if(root == null) return false;
        if(word.length() == 0) return root.children.size() > 0 || root.isWord;
        
        return startHelper(word.substring(1),
                            root.children.getOrDefault(word.charAt(0),null));
    }
    
    public void insertHelper(String word, TrieNode parent){
        if(word.length() == 0){
            parent.isWord = true;
            return;
        }
      
        Character c = word.charAt(0);
        TrieNode child = parent.children.getOrDefault(c,new TrieNode());
        child.name = c.toString();
        child.parent = parent;
        
        if(!parent.children.containsKey(c)){
            parent.children.put(c,child);
        }
        String subString = word.substring(1);
        
        insertHelper(subString,child);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */