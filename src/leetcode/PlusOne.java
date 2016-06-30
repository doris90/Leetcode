/*
 * 需求：给定一个以数组表示的数，加一之后，返回数组
 * 思路：前提：每一位均为0-9的数
 * 对于每一当前位的数x，（x+进位量）%10仍表当前位的值，（x+进位量）/10 表示需要向前进位的值，从各位向前依次访问
 * 每一位数，当访问完成，进位量仍为1时，创建新数组（比原数组多一位），用System.arraycopy复制原数组，第零位为进位量（为一）
 * */

package leetcode;

public class PlusOne {

	public static void main(String[] args) {
		int[] a = {9};
		int[] b = plusOne(a);
		for(int i=0; i<b.length; i++) {
			System.out.print(b[i]);
		}
		

	}
	
    public static int[] plusOne(int[] digits) {
    	int carry = 1;
    	int n = digits.length;
    	
    	for(int i=n-1; i>=0; i--) {
    		int temp = digits[i];
    		digits[i] = (temp + carry) % 10;
    		carry = (temp + carry) / 10;
    		
    		if(carry == 0) break;
    	}
    	
    	if(carry == 1) {
    		int[] newDigits = new int[n+1];
    		System.arraycopy(digits, 0, newDigits, 1, n);
    		newDigits[0] = carry;
    		return newDigits;
    	}else return digits;		
    }
}
