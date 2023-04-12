class Solution {
    public int maxProfit(int[] prices) {
        int maxVal = 0;
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int minVal = prices[0];
        for(int i = 1; i < prices.length;i++){
            if(minVal > prices[i]) minVal = prices[i];
            maxVal = Math.max(dp[i-1],prices[i] - minVal);
            dp[i] = maxVal;
        }
        return dp[prices.length-1];
    }
}