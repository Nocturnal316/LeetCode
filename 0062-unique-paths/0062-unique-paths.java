class Solution {
    HashMap<String,Integer> memo = new HashMap<>();
    public int uniquePaths(int m, int n) {
        return uniquePath(m-1,n-1);
    }
    //Summation DP
    public int uniquePath(int m, int n){
        //hit goal return 1
        if(m == 0 && n == 0) return 1;
        //invalid move return 0
        if(m < 0 || n < 0) return 0;
        String curPos = m+"_"+n;
        //if calulated return prev calculation
        if(memo.containsKey(curPos)) return memo.get(curPos);
        
        int moveLeft = uniquePath(m-1,n);
        int moveUp = uniquePath(m,n-1);
        
        memo.put(curPos,moveLeft+moveUp);
        return moveLeft+moveUp;
    }
}