package leetcode2;

import java.util.HashMap;

public class Plalindrome {


    public static void main(String[] args) {
        System.out.println(isPermutationOfPlalindrome("Tact Coa "));
    }

    /**
     * Given a string, your task is to count how many palindromic substrings in this string.
     * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
     * Input: "abc"
     * Output: 3
     * Explanation: Three palindromic strings: "a", "b", "c".
     * Input: "aaa"
     * Output: 6
     * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
     * @param s
     * @return
     */
//    public int countPalindromicSubstrings(String s) {
//
//    }

    public static boolean isPermutationOfPlalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        String target =  s.toLowerCase().trim();
        int len = s.replace(" ", "").trim().length();
        int countOfOdd = 0;

        for (Character c : target.toCharArray()) {
            if(c.equals(' ')) continue;
            if(!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        for (Character c : map.keySet()) {
            if(map.get(c)%2 != 0) {
                countOfOdd++;
            }
        }

        if(len%2 == 0 && countOfOdd>0) return false;
        if(len%2 !=0 && countOfOdd>1) return  false;
        else return true;
    }

}
