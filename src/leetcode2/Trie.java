package leetcode2;


import sun.security.krb5.internal.Krb5;

import java.util.List;

public class Trie {

    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }


    public static class TrieNode{
        public char val;
        public int intVal = 0;
        public boolean isEnd;
        public TrieNode[] children = new TrieNode[26];

        public TrieNode() {
        }

        public TrieNode(char val) {
            this.val = val;
        }

    }

    /**
     *============================================208. Implement Trie (Prefix Tree)===============================
     */

    /** Inserts a word into the trie. */
    public void insert(String word) {

        TrieNode tmp = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if(null == tmp.children[c-'a']) {
                tmp.children[c-'a'] = new TrieNode(c);
            }

            tmp = tmp.children[c-'a'];

        }

        tmp.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        TrieNode tmp = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if(tmp.children[c-'a'] == null) {
                return false;
            }

            tmp = tmp.children[c-'a'];

        }

        return tmp.isEnd;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        TrieNode tmp = root;

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);

            if(tmp.children[c-'a'] == null) {
                return false;
            }

            tmp = tmp.children[c-'a'];

        }

        return true;

    }

    /**
     *============================================648. Replace Words===============================
     * @param dict
     * @param sentence
     * @return
     */

    public String replaceWords(List<String> dict, String sentence) {

        //1. create Tire tree by dict, and by requirement: shortest replacement, dic insert shortest common string
        Trie tire = buildTireTreeByDictList(dict);

        //2. find replacement of each word
        String res = replaceWithSuccessors(sentence, tire.root);

        return res;

    }

    private String replaceWithSuccessors(String sentence, TrieNode root) {
        String[] words = sentence.split(" ");
        StringBuilder res = new StringBuilder();


        for (int i = 0; i < words.length; i++) {
            String replacement = findRepalcement(words[i], root);
            res.append(replacement);

            if(1 != words.length-1) {
                res.append(" ");
            }
        }


        return res.toString();
    }

    private String findRepalcement(String word, TrieNode root) {
        StringBuilder re = new StringBuilder();
        TrieNode tmp = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if(tmp.children[c - 'a'] != null) {
                re.append(tmp.children[c - 'a'].val);

                if(tmp.children[c - 'a'].isEnd) {
                    return re.toString();
                }
                tmp = tmp.children[c - 'a'];

            } else {
                break;
            }
        }

        return word;

    }

    private Trie buildTireTreeByDictList(List<String> dict) {
        Trie trie = new Trie();

        for (String dic : dict) {

            TrieNode tmp = trie.root;

            for (int i = 0; i < dic.length(); i++) {

                char c = dic.charAt(i);

                if(tmp.children[c - 'a'] == null) {
                    tmp.children[c - 'a'] = new TrieNode(c);
                }

                tmp = tmp.children[c - 'a'];

            }

            tmp.isEnd = true;
        }

        return trie;
    }


    /**
     *============================================Undone 676. Implement Magic Dictionary===============================
     */

    class MapSum {
        Trie trie;

        /** Initialize your data structure here.  */
        public MapSum() {
            trie = new Trie();
        }

        public void insert(String key, int val) {
            TrieNode tmp = trie.root;

            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);

                if(tmp.children[c - 'a'] == null) {
                    tmp.children[c - 'a'] = new TrieNode(c);
                }

                tmp = tmp.children[c - 'a'];
            }

            tmp.isEnd = true;
            tmp.intVal = val;

        }

        public int sum(String prefix) {
            TrieNode tmp = trie.root;

            int res = 0;

            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);

                if(tmp.children[c - 'a'] != null) {
                    res = res + tmp.children[c - 'a'].intVal;
                }

                tmp = tmp.children[c - 'a'];
            }
            return 1;


        }
    }




}
