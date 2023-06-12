class Solution {
    public List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n < 1) return ans;
        dfs(n,0,0,new StringBuilder());
        return ans;
        
    }
    
    public void dfs(int n, int left, int right,StringBuilder sb){
        if(sb.length() == 2*n){
            ans.add(sb.toString());
            return;
        }
        
        if(left < n){
            sb.append('(');
            dfs(n,left+1,right,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        
        if(right < left){
            sb.append(')');
            dfs(n,left,right+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}