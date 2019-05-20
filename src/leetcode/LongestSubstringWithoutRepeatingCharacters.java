package leetcode;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class LongestSubstringWithoutRepeatingCharacters {


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    public static int lengthOfLongestSubstring(String s) {

        int maxLength = 0;

        if(s == null || s.length() == 0) return maxLength;
        if(s.length() == 1) return 1;

        Set<Integer> set = new TreeSet<>();
        int count =  1;


        for(int m=0; m<s.length(); m++) {

            for (int i=m+1; i<s.length(); i++) {
                if(!s.substring(m,i).contains(String.valueOf(s.charAt(i)))) {
                    count++ ;
                    if(s.length() == i+1) set.add(count);
                    if(count == s.length()) return count;
                    continue;
                } else {
                    set.add(count);
                    count = 1;
                    break;
                }

            }

            set.add(count);
            count = 1;


        }

        return Collections.max(set);
    }
}
