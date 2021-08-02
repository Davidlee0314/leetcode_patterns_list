class Solution {
    /*
    Maintain a k size deque for indices and do the following steps:
    1. Take out the elements are outside the window
    2. Take out the elements are smaller than nums[i]
    Then, the first element in deque will be the maximum, since the smaller ones
    are all cleaned with the second step

    time O(n) space O(k)
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length, index = 0;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(!dq.isEmpty() && dq.peekFirst() < i - k + 1) dq.pollFirst();
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();
            dq.addLast(i);
            if(i - k + 1 >= 0){
                res[index++] = nums[dq.peekFirst()];
            }
        }
        return res;
    }
}