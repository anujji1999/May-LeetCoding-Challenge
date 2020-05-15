class Trie {

    /** Initialize your data structure here. */
    class TrieNode{
        char val;
        int count;
        int endsHere;
        TrieNode[] childs = new TrieNode[26];
    }
    TrieNode root;

    public TrieNode createNode(int index){
        TrieNode node = new TrieNode();
        node.val = (char)('a'+index);
        node.count = node.endsHere = 0;
        for(int i=0; i<26; i++){
            node.childs[i] = null;
        }
        return node;
    }

    public Trie() {
        root = createNode('/'-'a');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        int index = 0;
        for(int i=0; i<word.length(); i++){
            index = word.charAt(i)-'a';
            if(curr.childs[index] == null){
                curr.childs[index] = createNode(index);
            }
            curr.childs[index].count++;
            curr = curr.childs[index];
        }
        curr.endsHere++;        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        int index = 0;
        for(int i=0; i<word.length(); i++){
            index = word.charAt(i)-'a';
            if(curr.childs[index] == null){
                return false;
            }
            curr = curr.childs[index];
        }
        return (curr.endsHere > 0);        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
        TrieNode curr = root;
        int index = 0;
        for(int i=0; i<word.length(); i++){
            index = word.charAt(i)-'a';
            if(curr.childs[index] == null){
                return false;
            }
            curr = curr.childs[index];
        }
        return (curr.count > 0);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */