class Solution {
    public int maxProfit(int[] prices) {
        
        int left = 0;
        int maxVal = 0;
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int minVal = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length;i++){
            if(minVal > prices[i]){
                minVal = prices[i];
            }else{
                maxVal = Math.max(maxVal,prices[i] - minVal);
            }
        }
        return maxVal;
    }
}