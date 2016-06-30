package leetcode;

public class PalindromeNumber {

	public static void main(String[] args) {
		System.out.println(isPalindrome(1000021));

	}
	
    public static boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x / 10 == 0) return true;
        
        int len = 1;
        int t = x;
        while(t >= 10) {
        	len *= 10;
        	t /= 10;
        }
        t = x;
        while(t > 0) {
            if((t/len) != (t%10)) return false;
            else {
            	t = (t%len)/10;
            	len /= 100;	
            }
        }
        return true;
        
    }

}
