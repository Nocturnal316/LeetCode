class Solution {
    HashMap<Integer,Integer> memo = new HashMap<>();
    
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            memo.put(0,0);
            return 0;
        }
        //Fresh Value fill with default / unseeen
        memo.put(amount,Integer.MAX_VALUE);
        //for all the coints in the bag and the current target amount
        for(int coin : coins){
            //if subtracting would make it negative skip
            int remain = amount - coin;
            if(remain < 0) continue;
            //if we didn calculate yet. do so
            if(!memo.containsKey(remain)) coinChange(coins,remain);
            //if the previous sub problem has been solved;
            if(memo.get(remain) != -1){
                //update the current problem with the minum
                // of the keeping same amount or takes previosu sub problem + 1;
                // it might not have been solved yet so use Intermagx val
                // increase by 1;
                memo.put(amount, Math.min(memo.get(amount),
                        memo.getOrDefault(remain,Integer.MAX_VALUE)+1));
            }
           
        }
        
        if(memo.get(amount) == Integer.MAX_VALUE)   memo.put(amount, -1);
        
        return memo.get(amount);
    }
}