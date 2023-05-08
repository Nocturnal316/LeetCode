class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        
        dp[nums.length-1] = true;
        
        for(int i = nums.length-2; i >= 0; i--){
            int j =  i;
            dp[i] = false;
            while(j < (i+nums[i]) && j < dp.length){
                if(nums[i] == 0) break;
                j+=1;
                if(dp[j] == true){
                    dp[i] = true;
                    break;
                } 
            }
            
        }
        return dp[0];
    }
}

