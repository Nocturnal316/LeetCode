class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        int max = 0;
        for(int num : nums){
            numSet.add(num);
        }
        
        int longest;
        int currentNum;
        
        
        for(int num:nums){
            if(!numSet.contains(num-1)){
                longest = 1;
                currentNum = num;
                while(numSet.contains(currentNum+1)){
                    longest+=1;
                    currentNum +=1;
                }
                max = Math.max(longest,max);
            }
            
        }
      
        
        return max;
      
    }
}