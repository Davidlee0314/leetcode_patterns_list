class MagicDictionary {
    /**
     * We use the length as hash map key, so it doesn't need O(l) time 
     * to create hash key when searching.
     * 
     * time buildDict O(n) search O(n * l)
     * space O(n * l)
     */
    /** Initialize your data structure here. */
    HashMap<Integer, List<String>> map = new HashMap<>();
    public MagicDictionary() {
        
    }
    
    public void buildDict(String[] dictionary) {
        for(String word: dictionary){
            int len = word.length();
            if(!map.containsKey(len)) map.put(len, new ArrayList<>());
            map.get(len).add(word);
        }
    }
    
    public boolean search(String searchWord) {
        int len = searchWord.length();
        if(!map.containsKey(len)) return false;
        
        for(String s: map.get(len)){
            int count = 0;
            for(int i = 0; i < len; i++){
                if(s.charAt(i) != searchWord.charAt(i)){
                    count++;
                    if(count > 1) break;
                }
            }
            if(count == 1) return true;
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */