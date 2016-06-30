/*
 * ���󣺽��ַ����е�Ԫ����ĸ����
 * ˼·��1�����ַ����������
 * 		 2��ά����λ����ָ���һ��Ԫ���ַ����������з�˼�룩
 * 		 3��ͨ���ַ���str.charAt(char c)���ж��ַ��������Ƿ���Ԫ����ĸ
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
