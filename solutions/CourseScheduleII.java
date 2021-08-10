class Solution {
    /**
     * time O(n) space O(n^2)
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] degrees = new int[numCourses];
        List<Integer>[] courseSchedule = new ArrayList[numCourses];
        for(int[] pre: prerequisites){
            degrees[pre[0]]++;
            if(courseSchedule[pre[1]] == null) courseSchedule[pre[1]] = new ArrayList<>();
            courseSchedule[pre[1]].add(pre[0]);
        }
        
        Deque<Integer> dq = new LinkedList<>();

        // courses can be taken first
        for(int c = 0; c < numCourses; c++){
            if(degrees[c] == 0) dq.addLast(c);
        }
        
        int finished = 0;
        int[] res = new int[numCourses];
        while(!dq.isEmpty()){
            int cur = dq.pollFirst();
            res[finished++] = cur;
            if(courseSchedule[cur] != null){
                for(int next: courseSchedule[cur]){

                    // check whether the requirement is met
                    if(--degrees[next] == 0){
                        dq.addLast(next);
                    }
                }
            }
        }
        return finished == numCourses ? res : new int[0];
    }
}