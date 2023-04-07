class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer,ArrayList<Integer>> stops = new HashMap<>();
        HashSet<Integer> seenStops = new HashSet<>();
        HashSet<Integer> seenRoutes = new HashSet<>();
        
        if(target == source) return 0;
        for(int i = 0; i < routes.length; i++){
            for(Integer stop : routes[i]){
                if(!stops.containsKey(stop)){
                    stops.put(stop,new ArrayList<>());
                }
                stops.get(stop).add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        
        for(Integer i : stops.get(source)){
             queue.offer(i);
            seenRoutes.add(i);
        }
        seenStops.add(source);
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size;i++){
                int bus = queue.poll();
                for(Integer stop : routes[bus]){
                    if(stop == target) return level;
                    seenStops.add(stop);
                    for(Integer b : stops.get(stop)){
                        if(!seenRoutes.contains(b)) queue.add(b);
                        seenRoutes.add(b);

                    }
                }   
            }
            level+=1;
        }
        return -1;
    }
}