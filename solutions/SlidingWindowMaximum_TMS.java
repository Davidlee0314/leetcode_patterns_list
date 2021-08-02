class Solution {
    /*
    Maintain a tree map that maps element to the count. For each possible, we can get the
    maximum key by calling lastKey() api.
    time O(nlongk) space O(k)
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> ts = new TreeMap<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for(int i = 0; i < k; i++){
            ts.put(nums[i], ts.getOrDefault(nums[i] , 0) + 1);
        }
        res[0] = ts.lastKey();
        for(int right = k; right < n; right++){
            ts.put(nums[right - k], ts.get(nums[right - k]) - 1);
            if(ts.get(nums[right - k]) == 0) ts.remove(nums[right - k]);
            
            ts.put(nums[right], ts.getOrDefault(nums[right] , 0) + 1);
            res[right - k + 1] = ts.lastKey();
        }
        return res;
    }
}