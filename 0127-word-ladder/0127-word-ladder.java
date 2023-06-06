class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        char[] ALPHABETS = new char[26];
         for (int i = 0; i < 26; i++) {
            ALPHABETS[i] = (char) (i + 'a');
        }
        HashSet<String> dict = new HashSet<>(wordList);
        
        if(!dict.contains(endWord)) return 0;
        HashSet<String> seen = new HashSet<>();
        seen.add(beginWord);
        Queue<String> que = new LinkedList<>();
        que.offer(beginWord);
        int steps = 1;
      
        while(!que.isEmpty()){
            int size = que.size();
           
            for(int i = 0; i < size;i++){
                String node = que.poll();
                for(int pos = 0; pos < beginWord.length();pos++){
                    for(char c : ALPHABETS){
                        StringBuilder sb = new StringBuilder(node);
                        sb.setCharAt(pos,c);
                        String newWord = sb.toString();
                        if(dict.contains(newWord) && !seen.contains(newWord)){
                            if(newWord.equals(endWord)) return steps +1 ;
                            seen.add(newWord);
                            que.offer(newWord);
                        }
                    }
                }
            } 
            steps+=1;
        }
        return 0;
    }
}