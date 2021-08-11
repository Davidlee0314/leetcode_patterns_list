class Solution {
    /**
     * We use an list of hashmap to record the map. Then the prority queue
     * is used to ensure smaller weight paths are considered first, and we 
     * use the boolean array to avoid loop.
     * 
     * time O(VlogV + E) space O(V + E)
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, Integer>[] map = new HashMap[n + 1];
        for(int time[]: times){
            if(map[time[0]] == null) map[time[0]] = new HashMap<>();
            map[time[0]].put(time[1], time[2]);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        pq.offer(new int[]{0, k});
        int res = 0;
        boolean[] visited = new boolean[n + 1];
        while(!pq.isEmpty() && n > 0){
            int[] cur = pq.poll();
            if(visited[cur[1]]) continue;
            visited[cur[1]] = true;
            res = cur[0];
            n--;
            if(map[cur[1]] == null) continue;
            for(int next: map[cur[1]].keySet()){
                int dist = cur[0] + map[cur[1]].get(next);
                pq.offer(new int[]{dist, next});
            }
        }
        return n == 0 ? res : -1;
    }
}