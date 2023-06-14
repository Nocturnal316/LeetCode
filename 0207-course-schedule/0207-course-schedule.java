class Solution {
    HashMap<Integer,List<Integer>> graph;
    int[] edges;
    public boolean canFinish(int numCourses, int[][] prerequisites){
        graph = new HashMap<>();
        edges = new int[numCourses];
        for(int i = 0; i < numCourses;i++){
             graph.put(i,new ArrayList<>());
        }
        for(int[] relation : prerequisites){
            graph.get(relation[1]).add(relation[0]);
            edges[relation[0]]+=1;
        }
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < numCourses;i++){
            if(edges[i] == 0) que.offer(i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!que.isEmpty()){
            int size = que.size();
            for(int i = 0; i < size; i++){
                int curCourse = que.poll();
                ans.add(curCourse);
                for(int child : graph.get(curCourse)){
                    edges[child]-=1;
                    if(edges[child] == 0) que.offer(child);
                }
            }
        }
        return ans.size() == numCourses;
    }
}