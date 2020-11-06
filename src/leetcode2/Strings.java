package leetcode2;

public class Strings {

    public static void main(String[] args) {

        Strings strings = new Strings();
        int abc = strings.countSubstrings("aaa");

        System.out.println(abc);
    }

    public int countSubstrings(String s) {

        int count = 0;

        if(s == null || s.length() == 0) return count;

        for (int i = 0; i < s.length(); i++) {
            count = count + countPalindromic(s, i, i);
            count = count + countPalindromic(s, i, i+1);
        }

        return count;

    }

    public int countPalindromic(String s, int left, int right) {
        int count = 0;

        while(left >= 0 && right < s.length() && s.charAt(left)==s.charAt(right)) {
            count++;

            left--;
            right++;
        }

        return count;
    }
}
