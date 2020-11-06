package leetcode2;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] in = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> lists = groupAnagrams(in);

        System.out.println(lists);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        if(strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] chars = str.toCharArray();

            Arrays.sort(chars);
            String s = String.valueOf(chars);

            if( ! map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }

            map.get(s).add(str);

        }


        return new ArrayList<>(map.values());

    }
}
