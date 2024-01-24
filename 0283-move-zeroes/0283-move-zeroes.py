class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        size = len(nums)
        if size < 2 : return
        
     
        left = 0
        for right in range(1, len(nums)):
            # Move left to the first non-zero
            while left < right and nums[left] != 0:
                left += 1

            # Swap if right isn't 0 and left is
            if nums[right] != 0 and nums[left] == 0:
                nums[left], nums[right] = nums[right], 0
            
                
                
            
            
        
        