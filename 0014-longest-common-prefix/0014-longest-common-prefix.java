class Solution {
    class TrieNode{
        private HashMap<Character,TrieNode> children;
        private boolean isWord;
        public Character letter;
        
         public TrieNode(){
            isWord = false;
            children = new HashMap<>();
            letter = null;
        }
          public TrieNode(Character ch){
            isWord = false;
            children = new HashMap<>();
            letter = ch;
        }
    }
    
    class Trie{
        TrieNode root;
        
        public Trie(){
            root = new TrieNode();
        }
        
        public void insert(String s){
            TrieNode cur = root;
            for(Character ch : s.toCharArray()){
                if(!cur.children.containsKey(ch)){
                    cur.children.put(ch,new TrieNode());
                }
                cur = cur.children.get(ch);
            }
            cur.isWord = true;
        }
        
        public String count(String s){
            TrieNode cur = root;
            StringBuilder sb = new StringBuilder();
            
            for(Character ch : s.toCharArray()){
                if(cur.children.size() != 1 || cur.isWord ) return sb.toString();
                cur = cur.children.get(ch);
                sb.append(ch);
            }
            return sb.toString();
        }
    }
    
    public String longestCommonPrefix(String[] strs) {
        Trie root = new Trie();
        
        for(String s : strs){
            root.insert(s);
        }
        
        return root.count(strs[0]);
    }
}