class Solution {
    /*
    We construct a hashmap to store the result for each index, so we don't need to recompute again
    time O(n^3) for each problem we loop, stubstring and call dfs for O(n)
    space O(n)
    */
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>();
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(String word: wordDict) dict.add(word);
        return dfs(s, dict, map, 0);
    }
    private boolean dfs(String s, HashSet<String> dict, HashMap<Integer, Boolean> map, int index){
        if(index == s.length()) return true;
        if(map.containsKey(index)) return map.get(index);
        
        for(int i = index + 1; i <= s.length(); i++){
            String sub = s.substring(index, i);
            if(dict.contains(sub) && dfs(s, dict, map, i)){
                map.put(index, true);
                return true;
            }
        }
        map.put(index, false);
        return false;
    }
}