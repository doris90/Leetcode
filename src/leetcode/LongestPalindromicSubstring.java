package leetcode;


import com.sun.tools.javac.util.StringUtils;

import java.util.*;
import java.util.stream.IntStream;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {


        Long start = System.currentTimeMillis();
        String s = longestPalindrome("ccd");
        System.out.println(s);
        System.out.println(System.currentTimeMillis() - start);

    }


    public static String longestPalindrome(String s) {

        if(s == null || s.length() == 1) return s;
        if(isPalindrome(s)) return s;
        String ans = "";


        for (int i = s.length()-1; i >= 0; i--) {
            int start = 0;

            while(start != i) {
                start = s.indexOf(s.charAt(i), start);

                if(start == -1) break;

                if(isPalindrome(s.substring(start, i+1))) {
                    if(i-start+1 > ans.length()) {
                        ans = s.substring(start, i+1);
                    }
                    break;
                }

                start++;
            }


        }
//            String ss = s.substring(i);
//
//            HashSet<Integer> set = getIndex(ss, ss.charAt(0));
//            if(set.size() == 1) {
//                if(1 > ans.length()) {
//                    ans = ss.substring(0, 1);
//                    continue;
//                }
//            }
//
//            while(set.size() > 1 ) {
//                count++;
//                int mi = Collections.min(set);
//                int ma = Collections.max(set)+1;
//
//                if(isPalindrome(ss.substring(mi, ma))) {
//                    if(ma-mi > ans.length()) {
//                        ans = ss.substring(mi, ma);
//                        break;
//                    }
//                }
//
//                set.remove(ma-1);
//            }
//
//
//        }
//        System.out.println(count);
        return ans;

    }

    public static boolean isPalindrome(String s) {
        if(s == null) return false;
        return s.equals(new StringBuilder(s).reverse().toString());
    }

//    public static HashSet<Integer> getIndex(String s, char a) {
//
//        HashSet<Integer> set = new HashSet<>();
//        int i = s.indexOf(a);
//        set.add(i);
//        while(i >= 0) {
//            i = s.indexOf(a, i+1);
//            if(i != -1)set.add(i);
//
//        }
//        return set;
//    }
}
