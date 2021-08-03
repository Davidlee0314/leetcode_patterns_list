class Twitter {
    /*
    OOD design with classes Tweet, User
    For each user, we design the tweet stream as a linked list.
    Then, the getNewsFeed will be just a Merge K Sorted List question.
    query: q
    user: n
    max follower size: f
    time O(q * flogf) space O(n * f)
    */
    private int timestamp = 0;
    private class Tweet{
        public int id;
        public int time;
        public Tweet next;
        public Tweet(int _id){
            id = _id;
            time = timestamp++;
            next = null;
        }
    }

    private class User{
        public int id;
        public Tweet head;
        public HashSet<Integer> followed;
        public User(int _id){
            id = _id;
            followed = new HashSet<>();
            follow(_id);
            head = null;
        }
        public void follow(int followeeId){
            followed.add(followeeId);
        }
        public void unfollow(int followeeId){
            followed.remove(followeeId);
        }
        public void tweet(int tweetId){
            Tweet t = new Tweet(tweetId);
            t.next = head;
            head = t;
        }
    }
    
    private HashMap<Integer, User> userMap;
    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)) userMap.put(userId, new User(userId));
        userMap.get(userId).tweet(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if(!userMap.containsKey(userId)) return res;
        
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> {
            return b.time - a.time;
        });
        for(int followeeId: userMap.get(userId).followed){
            if(!userMap.containsKey(followeeId)) continue;
            if(userMap.get(followeeId).head != null){
                pq.add(userMap.get(followeeId).head);
            }
        }
        
        int index = 0;
        while(!pq.isEmpty() && index < 10){
            Tweet t = pq.poll();
            res.add(t.id);
            index++;
            if(t.next != null) pq.add(t.next);
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)) userMap.put(followerId, new User(followerId));
        userMap.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        userMap.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */