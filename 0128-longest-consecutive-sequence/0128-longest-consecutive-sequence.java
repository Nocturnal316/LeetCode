class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        int max = 0;
        for(int num : nums){
            numSet.add(num);
        }
        
        
        
        for(int num:nums){
            if(!numSet.contains(num-1)){
                int longest = 1;
                while(numSet.contains(num+1)){
                    longest+=1;
                    num +=1;
                }
                max = Math.max(longest,max);
            }
            
        }
      
        
        return max;
      
    }
}