class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        
        int[][] efforts = new int[m][n];
        
        for(int i = 0; i< m; i++) 
        {
            for(int j = 0; j<n; j++) {
                efforts[i][j] = Integer.MAX_VALUE;
            }
        }
        
        int[] result = {0,0,0}; 
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        
        pq.offer(new int[]{0,0,0});
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        while(!pq.isEmpty()) 
        {
            int[] t = pq.poll();
            
            int dist = t[0], r = t[1], c = t[2];
           
            if(r == m-1 && c == n-1) {
                return dist;
            }
            
            if(dist > efforts[r][c]) {
                continue;
            }
            
            for(int[] d : dirs) {
                int newR = r + d[0];
                int newC = c + d[1];
                
                if(newR >= 0 && newR < m && newC >= 0 && newC < n) 
                {
                  
                    int newDist = Math.max(dist, Math.abs(heights[r][c] - heights[newR][newC]));
                    
                    if(newDist < efforts[newR][newC]) 
                    {
                        efforts[newR][newC] = newDist;
                        pq.offer(new int[]{newDist, newR, newC});
                    }
                }
            }
        }
        
        return 0;
    }
}
