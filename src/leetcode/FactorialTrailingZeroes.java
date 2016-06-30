package leetcode;

public class FactorialTrailingZeroes {

	public static void main(String[] args) {
		System.out.println(trailingZeroes(30));

	}
	
    public static int trailingZeroes(int n) {
    	if(n == 0) return 0;
        int cnt = 0;
        while(n>0) {
        	cnt += n/5;
        	n /= 5;
        }
        return cnt;
    }

}
