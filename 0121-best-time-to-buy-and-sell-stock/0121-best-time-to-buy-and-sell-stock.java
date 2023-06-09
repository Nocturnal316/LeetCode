class Solution {
//     public int maxProfit(int[] prices) {
//         int[] dp = new int[prices.length];
//         dp[0] = 0;
//         int minVal = prices[0];
//         for(int i = 1; i < prices.length;i++){
//             if(minVal > prices[i]){
//                 minVal = prices[i];
//             }
//             dp[i] = Math.max(dp[i-1],prices[i] - minVal);
//         }
//         return dp[prices.length-1];
//     }
    
    
      public int maxProfit(int[] prices) {
          int min = Integer.MAX_VALUE;
          int maxProfit = 0;
          
          for(int i = 0; i < prices.length;i++){
              if(min > prices[i]){
                  min = prices[i];
              }
              
              if(prices[i] - min > maxProfit){
                maxProfit = prices[i] - min ;
              }
          }
          return maxProfit;
          
    }
}