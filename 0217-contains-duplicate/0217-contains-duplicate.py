class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
#         numSet = set()
#         for num in nums:
#             if num in numSet:
#                 return True
#             numSet.add(num)
#         return False


        # return len(nums) > len(set(nums))
        
        hash_map = dict()
        for i in nums:
            if  i in hash_map:
                 return True
            else:
                 hash_map[i] =1
        return False