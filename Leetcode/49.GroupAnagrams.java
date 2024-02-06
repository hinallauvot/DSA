class Solution {
    private String sortString(String str) {
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) map.computeIfAbsent(sortString(str), k -> new ArrayList<>()).add(str);
        return new ArrayList<>(map.values());
    }
}