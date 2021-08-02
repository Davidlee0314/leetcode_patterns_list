class Solution {
    /*
    For each possible critical point, we compare the max height maintain in the priority queue
    time O(n^2) space O(n)
    */
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        for(int[] b: buildings){
            // negative height for start index
            heights.add(new int[]{b[0], -b[2]});
            // positive height for end index
            heights.add(new int[]{b[1], b[2]});
        }
        
        // sort by index then height
        // if two start indices are the same, we return the higher one first (with less value since negativity)
        // so it will be add into the res list first
        // For the end indices, we return the lower one first, so it is remved before the maximum one is removed
        Collections.sort(heights, (a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->{ 
            return b - a; 
        });
        pq.add(0);

        // previous max height
        int prev = 0;
        
        for(int[] h: heights){
            if(h[1] < 0) pq.add(-h[1]);
            else pq.remove(h[1]);
            
            int cur = pq.peek();
            
            if(cur != prev){
                res.add(Arrays.asList(h[0], cur));
                prev = cur;
            }
        }
        
        return res;
    }
}