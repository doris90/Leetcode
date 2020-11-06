package leetcode2;

public class ValidAnagram {

    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {

        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isValidAnagram("sjkdfak", "kjkdfas"));
        System.out.println(validAnagram.isValidAnagram("ssdfak", "kjkdfas"));
    }

    /**
     * Given two strings s and t , write a function to determine if t is an anagram of s.
     * @param s
     * @param t
     * @return
     * Solution here is: Due to there are only lower case, we can have a int[] which contains count of each character
     * Then loop the second String, deduct the count for the appearance for each character
     */
    private boolean isValidAnagram(String s,  String t) {
        /**
         * Please verify length and blank
         */

        if(s.length() != t.length()) return false;

        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int[] ints = new int[26];

        for (int i = 0; i < chars.length; i++) {
            int sIndex = LOWER_CASE.indexOf(chars[i]);
            ints[sIndex]++;
        }

        for (int i = 0; i < chart.length; i++) {
            int tIndex = LOWER_CASE.indexOf(chart[i]);
            ints[tIndex]--;
        }


        for (int i = 0; i < ints.length; i++) {
            if(ints[i] > 0 ) return false;
        }

        return true;

    }
}
