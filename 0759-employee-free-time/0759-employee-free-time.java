/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

// public class comparator implements Comparable<Interval>{
//      @Override
//     public int compareTo(Interval o, Interval b) {
       
//         return o.start - b.start;
//     }
    
//     @Override
//     public String toString() {
//         return "Interval{" +
//                 "start=" + start +
//                 ", end=" + end +
//                 '}';
//       }
// }

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        ArrayList<Interval> res  = new ArrayList<>();
        
        PriorityQueue<Interval> queue = new PriorityQueue<>((a,b)->(a.start-b.start));
        
        int sum = 0;
        
        for(List<Interval> intervals : schedule){
            for(Interval interval : intervals){
                queue.offer(interval);   
            }
        }
        
        int prev = queue.peek().start;
        
        while(!queue.isEmpty()){
            Interval interval = queue.poll();
            //System.out.println(interval.start +"," +interval.end);
            if(interval.start > prev){
                res.add( new Interval(prev,interval.start));
            }
            prev = Math.max(prev, interval.end);
        }
        return res;
    }
}