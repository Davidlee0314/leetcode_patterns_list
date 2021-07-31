class Solution {
    /*
    We want to locate the m + n / 2 element in the merge array, thus we create a function
    getKthElement to find the k element of the merge array. 
    time O(log(m + n)) as k = (m + n) / 2 and we discard k / 2 each iteration, 
    space O(log(m + n)) if we consider function stacks, otherwise O(1)
    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return 0;
        
        int m = nums1.length, n = nums2.length;
        int l = (m + n + 1) / 2,
            r = (m + n + 2) / 2;
        return (getKthElement(nums1, nums2, 0, 0, l) + getKthElement(nums1, nums2, 0, 0, r)) / 2;
    }
    private double getKthElement(int[] nums1, int[] nums2, int start1, int start2, int k){
        // exhaust one array, we use the other array's k element
        if(start1 >= nums1.length) return nums2[start2 + k - 1];
        if(start2 >= nums2.length) return nums1[start1 + k - 1];
        
        // if k == 1, just return the smallest element of two start indices
        if(k == 1) return Math.min(nums1[start1], nums2[start2]);

        // if start1 + half k is greater than nums1 length, we will search the nums2 only, and vice versa
        // Otherwise, we compare the mid1 and mid2 value
        int mid1 = Integer.MAX_VALUE, mid2 = Integer.MAX_VALUE;
        if(start1 + k / 2 - 1 < nums1.length) mid1 = nums1[start1 + k / 2 - 1];
        if(start2 + k / 2 - 1 < nums2.length) mid2 = nums2[start2 + k / 2 - 1];
        
        if(mid1 < mid2){
            // discard nums1 left part, cuz the mid1 is smaller than mid2, 
            // which means mid1 max index will be k - 1, as k / 2 + 1 elements is bigger than mid1
            return getKthElement(nums1, nums2, start1 + k / 2, start2, k - k / 2); 
        }else{
            // discard nums2 left part
            return getKthElement(nums1, nums2, start1, start2 + k / 2, k - k / 2);
        }
    }
}