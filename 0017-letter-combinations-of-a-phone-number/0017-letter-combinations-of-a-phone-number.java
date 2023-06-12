class Solution {
    public List<String> ans = new ArrayList<>();
    public char[][] dict = {{},
                            {'a','b','c'},
                            {'d','e','f'},
                            {'g','h','i'},
                            {'j','k','l'},
                            {'m','n','o'},
                            {'p','q','r','s'},
                            {'t','u','v'},
                            {'w','x','y','z'},
                           };
    public List<String> letterCombinations(String digits) {
        if(digits.length() < 1) return ans;
        dfs(digits,0,new StringBuilder());
        return ans;
        
    }
    
    public  void  dfs(String digits, int start, StringBuilder sb){
        if(start >= digits.length()){
            ans.add(sb.toString());
            return;
        }
        
        int num = digits.charAt(start) - '0' - 1;
        
        for(char c : dict[num]){
            sb.append(c);
            dfs(digits,start+1,sb);
            sb.deleteCharAt(sb.length() -1);
        }
       
    }
}