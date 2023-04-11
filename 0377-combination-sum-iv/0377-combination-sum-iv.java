class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        
        for(int total = 1; total <=target; total++){
            for(int num : nums){
                if(total >=num){
                    dp[total] += dp[total-num];
                }
            }
        }
     
        
        return dp[target];
    }
}