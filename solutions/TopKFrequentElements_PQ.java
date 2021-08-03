class Solution {
    /*
    Maintain a k size priority queue.
    time O(nlogk) space O(n)
    */
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> { return map.get(a) - map.get(b); });
        for(int num: map.keySet()){
            pq.add(num);
            if(pq.size() > k) pq.poll();
        }
        for(int i = 0; i < k; i++) res[i] = pq.poll();  
        return res;
    }
}