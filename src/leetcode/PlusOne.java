/*
 * ���󣺸���һ���������ʾ��������һ֮�󣬷�������
 * ˼·��ǰ�᣺ÿһλ��Ϊ0-9����
 * ����ÿһ��ǰλ����x����x+��λ����%10�Ա�ǰλ��ֵ����x+��λ����/10 ��ʾ��Ҫ��ǰ��λ��ֵ���Ӹ�λ��ǰ���η���
 * ÿһλ������������ɣ���λ����Ϊ1ʱ�����������飨��ԭ�����һλ������System.arraycopy����ԭ���飬����λΪ��λ����Ϊһ��
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
