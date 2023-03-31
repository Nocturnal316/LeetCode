class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> ans = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray()){
            sb.append(c);
            if(sb.length() == 10 ){
                String dna = sb.toString();
                if(set.contains(dna)){
                    ans.add(dna);
                }else{
                    set.add(dna);
                }
                sb.deleteCharAt(0);
            }
        }
        
      
            
        return new ArrayList<String>(ans);
    }
}