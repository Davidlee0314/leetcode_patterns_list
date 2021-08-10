class Solution {
    /**
     * We use the degrees array to record the course has prerequisite or not,
     * and the courseSchedule records what courses should be considered taken after
     * the current one is done
     * 
     * time O(n) space O(n^2)
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        while(!dq.isEmpty()){
            int cur = dq.pollFirst();
            finished++;
            if(courseSchedule[cur] != null){
                for(int next: courseSchedule[cur]){

                    // check whether the requirement is met
                    if(--degrees[next] == 0){
                        dq.addLast(next);
                    }
                }
            }
        }
        return finished == numCourses;
    }
}