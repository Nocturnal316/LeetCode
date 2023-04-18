class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String,Integer> dict = new HashMap<>(); 
        for(int i = 0; i < words.length;i++){
            dict.put(words[i],i);
        }
        
        ArrayList ans = new ArrayList<>();
        for(int i = 0; i < words.length;i++){
            String curWord = words[i];
            if(dict.containsKey("") && isPali(curWord)){
                if(i != dict.get("")){
                    ans.add(Arrays.asList(i,dict.get("")));
                    ans.add(Arrays.asList(dict.get(""),i));
                }
            }
            
            String revWord = reverseWord(curWord);
            int indx = dict.getOrDefault(revWord,-1);
            if(dict.containsKey(revWord) && indx != i){
                ans.add(Arrays.asList(i,indx));
            }
            
            for(int cut = 1; cut < curWord.length();cut++){
                String sub1 = revWord.substring(0,cut);
                String sub2 = revWord.substring(cut);
                if(isPali(sub2) && dict.containsKey(sub1)){
                    int pos = dict.get(sub1);
                    ans.add(Arrays.asList(pos,i));
                }
                if(isPali(sub1) && dict.containsKey(sub2)){
                    int pos = dict.get(sub2);
                    ans.add(Arrays.asList(i,pos));
                }
            }
        }
        
        return ans;
    }
    
    public String reverseWord(String s){
        StringBuilder sb = new StringBuilder();
        return sb.append(s).reverse().toString();
    }
    
    public boolean isPali(String word){
        if(word.length() <= 1) return true;
        
        int left = 0;
        int right = word.length()-1;
        
        while(left < right){
            if(word.charAt(left) != word.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}