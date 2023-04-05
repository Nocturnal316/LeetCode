class Solution {
    
    public int minMeetingRooms(int[][] intervals) {
        //line sweep
          Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);    
    var heap = new PriorityQueue<int[]>((i1, i2) -> i1[1] - i2[1]);
    for (var meeting: intervals) {
      heap.offer(meeting);
      if (heap.peek()[1] <= meeting[0]) heap.poll();      
    }
    return heap.size();
  
    }
}