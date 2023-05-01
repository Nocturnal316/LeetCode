class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length == 1) return;
        int left = 0;
        for(int right = 1; right < nums.length;right++){
            //lets move left to the first non zero
            while(nums[left] != 0 && left < right){
                left++;
            }
            //swap if right isn't 0 and left is
            if(nums[right] != 0 && nums[left] == 0){
                nums[left] = nums[right];
                nums[right] = 0;
            }
        }
    }
}