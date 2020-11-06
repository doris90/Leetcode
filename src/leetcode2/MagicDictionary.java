package leetcode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MagicDictionary {
    Map<Integer, ArrayList<String>> buckets;

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        String[] in = {"hello","hallo","leetcode","judge"};
        magicDictionary.buildDict(in);

//        System.out.println(magicDictionary.search("hello"));
        System.out.println(magicDictionary.search("juage"));
    }

    /** Initialize your data structure here. */
    public MagicDictionary() {
        buckets = new HashMap<Integer, ArrayList<String>>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {

        for (String dic : dict) {

            if(! buckets.containsKey(dic.length())) {
                buckets.put(dic.length(), new ArrayList<>());
            }
            buckets.get(dic.length()).add(dic);

        }

    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if(!buckets.containsKey(word.length())) return false;

        for (String wds : buckets.get(word.length())) {
            int count = 0;

            for (int i = 0; i < wds.length(); i++) {

                if(wds.charAt(i) != word.charAt(i)) {
                    count++;
                }
            }

            if(count == 1) return true;

        }

        return false;

    }
}
