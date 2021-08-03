class MedianFinder {
    /*
    We use a min heap and a max heap to track the median related elements
    time addNum O(logn) findMedian O(1)
    space O(n)
    */
    private PriorityQueue<Integer> minHeap, maxHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> (b - a));
    }
    
    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        
        if(maxHeap.size() > minHeap.size()) minHeap.offer(maxHeap.poll());
    }
    
    public double findMedian() {
        if(maxHeap.size() != minHeap.size()) return (double)minHeap.peek();
        else return (double)(minHeap.peek() + maxHeap.peek()) / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */