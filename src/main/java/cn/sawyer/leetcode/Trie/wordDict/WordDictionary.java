package cn.sawyer.leetcode.Trie.wordDict;

/**
 * @program: LeetCode
 * @description: 添加与搜索单词，https://leetcode-cn.com/problems/add-and-search-word-data-structure-design/
 * @author: sawyer
 * @create: 2020-02-05 16:29
 **/
class WordDictionary {
    Trie trie;


    /** Initialize your data structure here. */
    public WordDictionary() {
       trie  = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        trie.insert(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return trie.search(word);
    }
}

class Trie {

    class TrieNode {

        private TrieNode[] links;

        private final int R = 26;

        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch -'a'] != null;
        }
        public TrieNode get(char ch) {
            return links[ch -'a'];
        }
        public void put(char ch, TrieNode node) {
            links[ch -'a'] = node;
        }
        public void setEnd() {
            isEnd = true;
        }
        public boolean isEnd() {
            return isEnd;
        }
        public TrieNode[] getLinks() {
            return links;
        }
    }

    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();

        TrieNode node = root;
        for (char c : chars) {
            if (!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    private TrieNode searchPrefix(String word, TrieNode root) {
        if (root == null) {
            return null;
        }
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // 遇到.的递归
            if (c == '.') {
                for (TrieNode node : root.getLinks()) {
                    TrieNode n = searchPrefix(word.substring(i + 1), node);
                    // 剪枝，非空意味着已经找到
                    if (n != null) {
                        return n;
                    }
                }
                return null;
            } else if (root.containsKey(c)) {
                root = root.get(c);
            } else {
                return null;
            }
        }
        return root;
    }

    public boolean search(String word) {
        TrieNode n = searchPrefix(word, root);
        return n != null && n.isEnd();
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
        System.out.println(wordDictionary.search("."));
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */