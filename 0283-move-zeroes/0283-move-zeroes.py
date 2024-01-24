class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        size = len(nums)
        if size < 2 : return
        
        last_non_zero = 0
        last_non_zero = 0
        for right in range(size):
            if nums[right] != 0:
                nums[last_non_zero], nums[right] = nums[right],         nums[last_non_zero]
                last_non_zero += 1

            
                
                
            
            
        
        