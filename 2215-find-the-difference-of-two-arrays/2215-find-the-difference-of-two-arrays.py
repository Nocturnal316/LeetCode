class Solution:
    def findDifference1(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:
        
        unique1 = set()
        unique2 = set()
        
        for i in nums1:
            if i not in nums2:
                unique1.add(i)
                
        for i in nums2:
            if i not in nums1:
                unique2.add(i)
        
        return unique1,unique2
    
    
    def findDifference(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:
        
        unique1 = set(nums1)
        unique2 = set(nums2)
        
        
        
        return [unique1-unique2,unique2 - unique1]
        