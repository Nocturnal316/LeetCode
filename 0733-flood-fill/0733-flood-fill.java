class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        boolean[][] fillSeen = new boolean[m][n];
        
        int[] dir = new int[]{0,1,1,0,-1,0,0,-1};
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair<>(sr,sc));
        while(!queue.isEmpty()){
            Pair cell = queue.poll();
            int r = (int)cell.getKey();
            int c = (int)cell.getValue();
            
            fillSeen[r][c] = true;
            for(int i = 0; i < dir.length; i+=2 ){
                int row = r+dir[i];
                int col = c+dir[i+1];
                if(row >= 0 && row < m && col >= 0 && col < n && !fillSeen[row][col]){
                    if(image[r][c] == image[row][col]){
                        queue.offer(new Pair<>(row,col));
                    }
                }
            }
            image[r][c] = color;
        }
        return image;
    }
}