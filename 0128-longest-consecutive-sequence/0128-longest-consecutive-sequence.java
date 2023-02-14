class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for(int num : nums){
            numSet.add(num);
        }
        int max = 0;
        int curLongest;
        int currentNum;
        
        for(int num:nums){
            if(!numSet.contains(num-1)){
                curLongest = 1;
                currentNum = num;
                while(numSet.contains(currentNum+1)){
                    curLongest+=1;
                    currentNum +=1;
                }
                max = Math.max(curLongest,max);
            }
        }   
        return max;
    }
}