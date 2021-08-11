class Solution {
    /**
     * Use a boolean array to label the state and BFS the graph
     * 
     * time O(n ^ 2) space O(n)
     */
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        
        int res = 0;
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            res++;
            
            // BFS
            Deque<Integer> dq = new LinkedList<>();
            dq.addLast(i);
            while(!dq.isEmpty()){
                int cur = dq.pollFirst();
                visited[cur] = true;
                for(int next = 0; next < n; next++){
                    if(!visited[next] && isConnected[cur][next] == 1)
                        dq.addLast(next);
                }
            }
        }
        
        return res;
    }
}