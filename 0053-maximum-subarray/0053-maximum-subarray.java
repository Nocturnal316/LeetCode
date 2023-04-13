class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];
  
        int[] prefix = nums.clone();
        
        for(int i = 1; i < prefix.length;i++){
            prefix[i] += prefix[i-1];
        }

        int max = Integer.MIN_VALUE;
        int min = 0;
        System.out.println(Arrays.toString(prefix));
        for(int i = 0;i < prefix.length;i++){
            max = Math.max(max,prefix[i]-min);
            min = Math.min(min,prefix[i]);
        }
        
        return max;
        
    }
}