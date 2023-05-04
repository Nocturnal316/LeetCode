class Solution {
    int mod = (int) Math.pow(10,9)+7;
    HashMap<String,Integer> memo = new HashMap<>();
    public int numberOfWays(int startPos, int endPos, int k) {
        if(startPos == endPos &&  k == 0 ) return 1;
        if(k == 0) return 0;
        String combo = startPos+"_"+k;
        //int combo = Math.abs(startPos-endPos);
        if(memo.containsKey(combo)) return memo.get(combo);
        int left = numberOfWays(startPos - 1, endPos,  k - 1)%mod;
        int right = numberOfWays(startPos + 1, endPos,  k - 1)%mod;
        
        memo.put(combo,(left+right)%mod);
        return (left+right)%mod;
    }
}