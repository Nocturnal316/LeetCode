class Solution {
    HashMap<Integer,Integer> memo = new HashMap<>();
    public int climbStairs(int n) {
        if(n == 0) return 1;
        if(n < 0 ) return 0;
        
        if(memo.containsKey(n)) return memo.get(n);
        
        int once = climbStairs(n-1);
        int twice = climbStairs(n-2);
        
        memo.put(n,once+twice);
        return memo.get(n);
    }
}