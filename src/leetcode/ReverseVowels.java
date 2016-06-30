/*
 * 需求：将字符串中的元音字母逆序
 * 思路：1、将字符串变成数组
 * 		 2、维护首位两个指针和一个元音字符串（三向切分思想）
 * 		 3、通过字符串str.charAt(char c)可判断字符数组中是否是元音字母
 * */

package leetcode;

public class ReverseVowels {
	public static void main(String[] args) {
		String t = ",.";
		System.out.println(reverseVowels(t));
	}
    public static String reverseVowels(String s) {
    	if(s.length() == 0) return null;
    	if(s.length() == 1) return s;
        int low = 0;
        int high = s.length()-1;
        char[] n = s.toCharArray();
        char temp;
        String vowels = "aeiouAEIOU";
        while(low <= high) {
        	while(low <= high && vowels.indexOf(n[low]) == -1)  low++;
            while(low <= high && vowels.indexOf(n[high]) == -1)  high--;
            if(low <= high) {
                temp = n[low];
                n[low++] = n[high];
                n[high--] = temp;
            }
        } 
        s = new String(n);
        return s;
    }
}
