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
        /**
        *   Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);    
            var heap = new PriorityQueue<int[]>((i1, i2) -> i1[1] - i2[1]);
            for (var meeting: intervals) {
              heap.offer(meeting);
              if (heap.peek()[1] <= meeting[0]) heap.poll();      
            }
            return heap.size();
        }*/
        
        
    }
}