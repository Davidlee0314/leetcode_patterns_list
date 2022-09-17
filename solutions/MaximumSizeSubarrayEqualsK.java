class Solution{
    /**
     * We use a hashmap to memorize the lefmost index of sum
     * then at each iteration, we look sum - k, if exists we know there's a subarray's sum equals to k
     * 
     * time O(n) space O(n), where n is array length
     */
    public static int MaximumSizeSubarrayEqualsK(int[] arr, int k) {
        if(arr.length == 0) return 0;

        // store the sum -> leftmost index
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int res = 0, sum = 0;
        // if sum equals 
        map.put(0, -1);
        for(int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if(map.containsKey(sum - k)) res = Math.max(res, i - map.get(sum - k));
            if(!map.containsKey(sum)) map.put(sum, i);
        }
        return res;
    }
}
