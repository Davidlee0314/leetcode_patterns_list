class Solution {
    /**
     * We count all occurence in the words array, and loop every possible
     * indices to check whether the substring can be concatenated out.
     * 
     * time O(n * wordNum * wordLen) space O(wordNum)
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(s.length() == 0 || words.length == 0) return res;
        
        HashMap<String, Integer> counts = new HashMap<>();
        for(String word: words){
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        
        int n = s.length(), wordNum = words.length, wordLen = words[0].length();
        for(int i = 0; i < n - wordNum * wordLen + 1; i++){
            String sub = s.substring(i, i + wordNum * wordLen);
            if(canConcat(sub, counts, wordNum, wordLen)) res.add(i);
        }
        return res;
    }
    private boolean canConcat(String sub, HashMap<String, Integer> counts, int wordNum, int wordLen){
        HashMap<String, Integer> seen = new HashMap<>();
        for(int i = 0; i < wordNum; i++){
            String t = sub.substring(i * wordLen, (i + 1) * wordLen);
            seen.put(t, seen.getOrDefault(t, 0) + 1);
            if(!counts.containsKey(t) || seen.get(t) > counts.get(t)) return false;
        }
        return true;
    }
}