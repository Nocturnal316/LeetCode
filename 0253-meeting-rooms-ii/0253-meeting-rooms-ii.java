class Solution {
    
    public int minMeetingRooms(int[][] intervals) {
        //line sweep
        
        TreeMap<Integer,Integer> destruct = new TreeMap<>();
        for(int[] interval : intervals){
            destruct.put(interval[0],destruct.getOrDefault(interval[0],0)+1);
            destruct.put(interval[1],destruct.getOrDefault(interval[1],0)-1);
        }
        int cur=0;
        int ans=0;
        
        for(Integer p : destruct.values()){
            cur += p;
            ans = Math.max(ans,cur);
        }
        return ans;
    }
}