class Solution {
    HashMap<String,Integer> memo = new HashMap<>();
    public int uniquePaths(int m, int n) {
      
        return uniquePath(m-1,n-1);
    }
    
    public int uniquePath(int m, int n){
        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0) return 0;
        String curPos = m+"_"+n;
        
        if(memo.containsKey(curPos)) return memo.get(curPos);
        
        int moveLeft = uniquePath(m-1,n);
        int moveUp = uniquePath(m,n-1);
        
        memo.put(curPos,moveLeft+moveUp);
        
        return moveLeft+moveUp;
    }
}