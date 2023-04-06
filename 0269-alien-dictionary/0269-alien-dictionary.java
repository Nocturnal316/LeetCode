class Solution {
    HashMap<Character,Integer> count = new HashMap<>();
    HashMap<Character,GraphNode> dict = new HashMap<>();
    class GraphNode{
        HashMap<Character,GraphNode> adj;
        
        public GraphNode(){
            adj = new HashMap<>();
        }
        
        public String toString(){
            StringBuilder sb = new StringBuilder();
            
            for(Character c : adj.keySet()){
                sb.append(c);
                sb.append(" ");
            }
            
            return sb.toString();
        }
    }
    public String alienOrder(String[] words) {
        
        for(String word : words){
            for(Character c : word.toCharArray()){
                dict.put(c,new GraphNode());
                count.put(c,0);
            }
        }
        
        for(int i = 0; i < words.length-1;i++){
            String word1 = words[i];
            String word2 = words[i+1];
            
            //is word2 a prefix of word 1;
            //means its out of order
            if(word1.length() > word2.length() && word1.startsWith(word2)) return "";
            
            for(int j = 0; j < Math.min(word1.length(),word2.length());j++){
                //only need to match the first non same character
                if(word1.charAt(j) != word2.charAt(j)){
                    Character c1 = word1.charAt(j);
                    Character c2 = word2.charAt(j);
                    if(dict.get(c1).adj.containsKey(c2))break;
                    dict.get(c1).adj.put(c2,dict.get(c2));
                    count.put(c2,count.get(c2)+1);
                    break;//break
                }
              
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for(Character c : count.keySet()){
            if(count.get(c).equals(0)){
               queue.add(c); 
            } 
        }
        
        Character curChar;
        
        StringBuilder ans = new StringBuilder();
        while(!queue.isEmpty()){
            curChar = queue.poll();
            
            GraphNode curNode = dict.get(curChar);
            ans.append(curChar);
      
            for(Character childChar : curNode.adj.keySet()){
                count.put(childChar,count.get(childChar) - 1);
                if(count.get(childChar).equals(0)) queue.offer(childChar);
            }
        }
        
        //if(count.size() != 0) return "";
        if(ans.length() < count.size()) return "";
        
        return ans.toString();
        
    }
}