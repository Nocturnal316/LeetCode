class Solution {
    HashMap<Integer,Integer> memo = new HashMap<>();
    
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) {
            memo.put(0,0);
            return 0;
        }
        memo.put(amount,Integer.MAX_VALUE);
        for(int coin : coins){
            if(amount - coin < 0) continue;
            if(!memo.containsKey(amount-coin)) coinChange(coins,amount-coin);
       
            if(memo.get(amount-coin)!= -1){
                memo.put(amount,Math.min(memo.get(amount),
                                  memo.getOrDefault(amount-coin,Integer.MAX_VALUE)+1));
            }
            
        }
        if(memo.get(amount) == Integer.MAX_VALUE)   memo.put(amount, -1);
        
        return memo.get(amount);
    }
}