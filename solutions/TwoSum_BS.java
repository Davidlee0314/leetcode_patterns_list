class Solution {
    // Sort + Binary Search
    // time O(logn) space O(n)
    private class Pair{
        public int index, val;
        public Pair(int _index, int _val){
            index = _index;
            val = _val;
        }
    }
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Pair[] arr = new Pair[n];
        for(int i = 0; i < n; i++) arr[i] = new Pair(i, nums[i]);
        
        Arrays.sort(arr, (a, b) -> a.val - b.val);
        for(int i = 0; i < n; i++){
            int j = binarySearch(arr, i + 1, n - 1, target - arr[i].val);
            if(j != -1) return new int[]{arr[i].index, arr[j].index};
        }
        return new int[0];
    }
    private int binarySearch(Pair[] arr, int left, int right, int target){
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid].val == target) return mid;
            else if(arr[mid].val > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}