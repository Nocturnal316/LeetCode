class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
   
        if(n == k) return nums;
        HashMap<Integer,Integer> counterMap = new HashMap<>();
        
        for(int num : nums){
            counterMap.put(num,counterMap.getOrDefault(num,0)+1);
        }
        
        
        Queue<Integer> que = 
            new PriorityQueue<>((a,b)->
            Integer.compare(counterMap.get(a),counterMap.get(b)));
        
        
        //que.addAll(counterMap.keySet());
        
        for(Integer a : counterMap.keySet()){
            que.add(a);
            if(que.size() > k) que.poll();
        }
        int[] ans = new int[k];
        
        for(int i = 0; i < k;i++){
            ans[i] = que.poll();
        }
        return ans;
    }
}