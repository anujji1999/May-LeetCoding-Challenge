#include<bits/stdc++.h>
using namespace std;

class Trie {
public:
    /** Initialize your data structure here. */
    struct TrieNode{
        char val;
        int count;
        int endsHere;
        TrieNode* childs[26];
    };
    TrieNode *root;

    TrieNode *createNode(int index){
        TrieNode *node = new TrieNode;
        node->val = 'a'+index;
        node->count = node->endsHere = 0;
        for(int i=0; i<26; i++){
            node->childs[i] = NULL;
        }
        return node;
    }

    Trie() {
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
        root = createNode('/'-'a');
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        TrieNode* curr = root;
        int index = 0;
        for(int i=0; i<word.size(); i++){
            index = word[i]-'a';
            if(curr->childs[index] == NULL){
                curr->childs[index] = createNode(index);
            }
            curr->childs[index]->count++;
            curr = curr->childs[index];
        }
        curr->endsHere++;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        TrieNode* curr = root;
        int index = 0;
        for(int i=0; i<word.size(); i++){
            index = word[i]-'a';
            if(curr->childs[index] == NULL){
                return false;
            }
            curr = curr->childs[index];
        }
        return (curr->endsHere > 0);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string word) {
        TrieNode* curr = root;
        int index = 0;
        for(int i=0; i<word.size(); i++){
            index = word[i]-'a';
            if(curr->childs[index] == NULL){
                return false;
            }
            curr = curr->childs[index];
        }
        return (curr->count > 0);
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */