class Solution {
    public int numDecodings(String s) {
        return dfs(s,0,new HashMap<Integer,Integer>());
    }
    
    public int dfs(String s, int start, HashMap<Integer,Integer> memo){
        if(start == s.length()) return 1;
        
        if(memo.containsKey(start)) return memo.get(start);
        if(s.charAt(start) == '0') return 0;
        
        int ans = 0;
        
        ans+= dfs(s,start+1,memo);
        
        if(start+2 <= s.length() && Integer.parseInt(s.substring(start,start+2))<= 26){
            ans += dfs(s,start+2,memo);
        }
        
        memo.put(start,ans);
        return ans;
    }
}