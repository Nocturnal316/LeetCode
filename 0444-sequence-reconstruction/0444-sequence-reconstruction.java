class Solution {
    HashMap<Integer,Integer> inDegree = new HashMap<>();
    HashMap<Integer,List<Integer>> graph = new HashMap<>();
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        contructGraph(nums, sequences);
        System.out.println(graph);
        System.out.println(inDegree);
        
        Queue<Integer> que = new LinkedList<>();
        List<Integer> res = new ArrayList<Integer>();
        
        for(Map.Entry<Integer,Integer> entry : inDegree.entrySet()){
            if(entry.getValue() == 0) que.offer(entry.getKey());
        }
        
        while(!que.isEmpty()){
            int size = que.size();
            if(size > 1) return false;
            Integer node = que.poll();
            res.add(node);
            for(Integer child : graph.get(node)){
                inDegree.put(child,inDegree.get(child)-1);
                if(inDegree.get(child) == 0 ){
                    que.offer(child);
                }
            }
        }
     
        if(inDegree.size() != res.size()) return false;
        
        for(int i = 0; i < nums.length;i++){
            if(nums[i] != res.get(i)) return false;
        }
        
        return true;
    }
    
    public void contructGraph(int[] nums, List<List<Integer>> sequences){
        for(int i : nums){
            graph.put(i,new ArrayList<>());
            inDegree.put(i,0);
        }
        
        for(List<Integer> list : sequences){
            for(int i = 1; i < list.size();i++){
                graph.get(list.get(i-1)).add(list.get(i));
                inDegree.put(list.get(i),inDegree.get(list.get(i))+1);
                
            }
        }
    }
}