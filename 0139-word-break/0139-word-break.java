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
       return dfs(s,wordDict,0,new Boolean[s.length()]);
    }
    
    public boolean dfsBreak(String s, TrieNode root, int pos){
        if(pos  == s.length() ) return true;
        //if we seen this character used already return false;
        // the case that root letter was already used
        //aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa  -> a,aa,aaaaaa,aaa,aaaaa,
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
    
    public  boolean dfs(String s,  List<String> words, int start,Boolean[] memo ){
        if(start >= s.length()){
            return true;
        }
        if (memo[start] != null) return memo[start];
        boolean ans = false;
        
        for(int endP = start+1; endP <= s.length(); endP++){
            if(words.contains(s.substring(start,endP))){
                // System.out.println("Start "+start);
                // System.out.println("end "+ endP);
                // System.out.println(s.substring(start,endP));
                ans = ans || dfs(s,words,endP,memo);
            
            }
        }
        
        memo[start] = ans;
        return ans;
    }

}