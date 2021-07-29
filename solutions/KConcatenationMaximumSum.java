class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        /* 
        check for subarray max, prefix max (always start from index 0), suffix max sum (always end at the last index)
        if k == 1 return subarray max
        else we check if subarray max > 0, if so, we know we can add in an option with n - 2 array concatenated in the middle.
        Otherwise we only compare the subarray max with the prefix max + suffix max
        */
        int n = arr.length;
        long max = 0, preMax = 0, sufMax = 0, sum = 0; // sum variable is the same as preMaxSoFar, but i retain it for better readibility
        long maxSoFar = 0, preMaxSoFar = 0, sufMaxSoFar = 0;
        
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            
            // Kadane's algo on subarray sum
            maxSoFar = Math.max(maxSoFar + arr[i], arr[i]);
            max = Math.max(max, maxSoFar);
            
            preMaxSoFar += arr[i];
            preMax = Math.max(preMax, preMaxSoFar);
            
            sufMaxSoFar += arr[n - i - 1];
            sufMax = Math.max(sufMax, sufMaxSoFar);
        }
        
        int mod = (int)1e9 + 7;
        if(k == 1) return (int)(max % mod);
        if(sum > 0){
            long res = Math.max(preMax + sufMax, preMax + (k - 2) * sum + sufMax);
            res = Math.max(res, max);
            return (int)(res % mod);
        }else{
            long res = Math.max(preMax + sufMax, max);
            return (int)(res % mod);
        }
    }
}