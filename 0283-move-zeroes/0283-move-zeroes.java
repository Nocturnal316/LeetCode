class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length == 1) return;
        int left = 0;
      
        
        for(int right = 1; right < nums.length;right++){
            while(nums[left] != 0 && left < right){
                left++;
            }
            
            if(nums[right] != 0 && nums[left] == 0){
                nums[left] = nums[right];
                nums[right] = 0;
            }
        }
    
    }
}