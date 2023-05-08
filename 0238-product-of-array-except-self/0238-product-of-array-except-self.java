class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        
        leftSum[0] = 1;
        for(int i = 1; i < nums.length;i++){
            leftSum[i] = nums[i-1] * leftSum[i-1];
        }
        
        rightSum[nums.length-1] = 1;
        for(int i = nums.length-2; i >= 0;i--){
            rightSum[i] = nums[i+1] * rightSum[i+1];
        }
        
        int[] ans = new int[nums.length];
        
        for(int i = 0; i < ans.length;i++){
            ans[i] = leftSum[i] * rightSum[i];
        }
        
        return ans;
    }
}