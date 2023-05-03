class Solution {
  
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer>  que = new PriorityQueue<>((a,b)->{
            if(a == b){
                return a-b;
            }else{
                return Math.abs(b-x) - Math.abs(a-x);
            }
        });
        
        for(int num : arr){
            if(que.size() < k){
                que.offer(num);
            }else{
                if(Math.abs(que.peek()-x) > Math.abs(num-x)){
                    que.poll();
                    que.offer(num);
                }
            }
        }
        for(int i = 0; i < k;i++){
            ans.add(que.poll());
        }
        Collections.sort(ans);
        return ans;
    }
}