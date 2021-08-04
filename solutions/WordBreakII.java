class Solution {
    /*
    Instead of recording the true of false in dp status, we store the list of results
    time O(n^3) space O(n^2)
    */
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        map.put(0, new ArrayList<>());
        map.get(0).add("");
        
        HashSet<String> set = new HashSet<>();
        set.addAll(wordDict);
        
        for(int i = 1; i <= s.length(); i++){
            List<String> res = new ArrayList<>();
            for(int j = 0; j < i; j++){
                String sub = s.substring(j, i);
                if(map.containsKey(j) && set.contains(sub)){
                    for(String preString: map.get(j)){
                        if(j == 0) res.add(sub);
                        else res.add(preString + " " + sub);
                    }
                }
            }
            map.put(i, res);
        }
        return map.get(s.length());
    }
}