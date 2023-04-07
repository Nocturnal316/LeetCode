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
        
        queue.offer(source);
        seenStops.add(source);
        int level = 1;
       
        while(!queue.isEmpty()){
            System.out.println(queue);
            int size = queue.size();
            for(int i = 0; i < size;i++){
               int stop = queue.poll();
                for(Integer bus : stops.get(stop)){
                    if(seenRoutes.contains(bus))continue;
                    seenRoutes.add(bus);
                    for(Integer busStops: routes[bus]){
                        if(seenStops.contains(busStops))continue;
                        System.out.println(busStops+", level"+level );
                        seenStops.add(busStops);
                        if(target ==  busStops) return level;
                        queue.add(busStops);
                    }
                }
                
            }
            level+=1;
        }
        return -1;
    }
}