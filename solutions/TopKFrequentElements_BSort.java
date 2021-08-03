class Solution {
    /*
    We use bucket sort to solve this problem. For each freqency,
    there is a list record all the elements.
    time O(n) space O(n)
    */
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List<Integer>[] buckets = new List[n + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(int num: map.keySet()){
            int freq = map.get(num);
            if(buckets[freq] == null) buckets[freq] = new ArrayList<>();
            buckets[freq].add(num);
        }

        int bucketIndex = n, index = 0;
        while(index < k){
            while(buckets[bucketIndex] == null) bucketIndex--;
            for(int num: buckets[bucketIndex]) res[index++] = num;
            bucketIndex--;
        }
        return res;
    }
}