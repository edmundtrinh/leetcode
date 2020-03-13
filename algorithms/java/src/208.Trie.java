/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Mar 12, 2020
    Update:     Mar 12, 2020
    Problem:    208. Implement Trie (Prefix Tree)
    Difficulty: Medium
    Source:     https://leetcode.com/problems/implement-trie-prefix-tree/
    
    Notes:
        Implement a trie with insert, search, and startsWith methods.
        Hint: Implement trie node as well in order to implement trie
        
    Examples:
        Trie trie = new Trie();

        trie.insert("apple");
        trie.search("apple");   // returns true
        trie.search("app");     // returns false
        trie.startsWith("app"); // returns true
        trie.insert("app");   
        trie.search("app");     // returns true
        
        You may assume that all inputs are consist of lowercase letters a-z.
        All inputs are guaranteed to be non-empty strings.
*/

class TrieNode {
    // R links to node children
    private TrieNode[] links;
    
    // assuming all inputs are lowercase letters a-z
    private final int CHARACTERS = 26;
    
    private boolean isWord;
    
    public TrieNode() {
        this.links = new TrieNode[CHARACTERS];
    }
    
    public boolean containsKey(char c) {
        return links[c - 'a'] != null;
    }
    
    public TrieNode get(char c) {
        return links[c - 'a'];
    }
    
    public void put(TrieNode node, char c) {
        links[c - 'a'] = node;
    }
    
    public void makeWord() {
        this.isWord = true;
    }
    
    public boolean isWord() {
        return this.isWord;
    }
}

class Trie {
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.containsKey(c)) {
                node.put(new TrieNode(), c);
            }
            node = node.get(c);
        }
        node.makeWord();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isWord();
    }
    
    // search a prefix or whole key in trie and
    // return node where search ends
    private TrieNode searchPrefix(String word) {
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.containsKey(c)) {
                node = node.get(c);
            } else {
                return null;
            }
        }
        return node;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */