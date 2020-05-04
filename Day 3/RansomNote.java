class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> umap = new HashMap<>();
        for(int i=0; i<magazine.length(); i++){
            umap.put(magazine.charAt(i), umap.getOrDefault(magazine.charAt(i), 0)+1);
        }
        
        for(int i=0; i<ransomNote.length(); i++){
            if(umap.containsKey(ransomNote.charAt(i))){
                umap.put(ransomNote.charAt(i), umap.get(ransomNote.charAt(i))-1);
                if(umap.get(ransomNote.charAt(i)) == 0){
                    umap.remove(ransomNote.charAt(i));
                }
            }else{
                return false;
            }
        }
        return true;
    }
}