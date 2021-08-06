class Solution {
    /*
    time O(nk^2)
    space O(n)
    */
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i = 0; i < words.length; i++) map.put(words[i], i);
        
        // empty string
        if(map.containsKey("")){
            int i = map.get("");
            for(int j = 0; j < words.length; j++){
                if(i != j && isPalindrome(words[j], 0, words[j].length() - 1)){
                    res.add(Arrays.asList(i, j));
                    res.add(Arrays.asList(j, i));
                }
            }
        }
        
        // whole string reverse
        for(int i = 0; i < words.length; i++){
            String t = reverse(words[i]);
            if(map.containsKey(t) && i != map.get(t)){
                res.add(Arrays.asList(i, map.get(t)));
            }
        }
        
        // contains s1[:index] reverse and s1[index + 1: ] is a palindrome
        // contains s1[index:] reverse and s1[:index - 1] is a palindrome
        // index from 1 ~ length - 1
        for(int i = 0; i < words.length; i++){
            String start = "", end = "";
            for(int j = 1; j < words[i].length(); j++){
                start = words[i].charAt(j - 1) + start;
                if(map.containsKey(start) && isPalindrome(words[i], j, words[i].length() - 1)){
                    res.add(Arrays.asList(i, map.get(start)));
                }
                
                end = end + words[i].charAt(words[i].length() - j);
                if(map.containsKey(end) && isPalindrome(words[i], 0, words[i].length() - j - 1)){
                    res.add(Arrays.asList(map.get(end), i));
                }
            }
        }
        
        return res;
    }
    private boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
    private String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}