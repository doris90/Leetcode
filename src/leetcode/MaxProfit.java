package leetcode;

public class MaxProfit {

	public static void main(String[] args) {
		int[] a = {1};
		//maxProfit(a);
		System.out.println(maxProfit(a));

	}
	
    public static int maxProfit(int[] prices) {
    	int[] a = new int[prices.length];
    	int[] b = new int[prices.length-1];
    	a[0] = prices[0];
    	for(int i=1; i<=prices.length-1; i++) {
    		a[i] = prices[i] - prices[i-1];
    		b[i-1] = a[i];
    		//System.out.println(b[i-1]);
    	}
        return maxProfit(b , 0 , b.length - 1);
    }
    
    public static int maxProfit(int[] a , int low , int high) {
        if(low == high) return a[low];
        int leftmax;
        int rightmax;
        int crossmax;
        	int mid = (int)Math.ceil((low + high)/2);
        	leftmax  = maxProfit(a , low , mid);
        	rightmax  = maxProfit(a , mid + 1 , high);
        	crossmax = maxProfitOfcrossSubarray(a , low , mid , high);
        	if(Math.max(leftmax, rightmax) > crossmax ) return Math.max(leftmax, rightmax);
        	else return crossmax;
    }
    
    public static int maxProfitOfcrossSubarray(int[] a , int low , int mid , int high) {
    	int leftsum = 0;
    	int rightsum = 0;
    	int sum = 0;
    	
    	for(int i=mid; i>=low; i--) {
    		sum  += a[i];
    		if(leftsum < sum) leftsum = sum;
    	}
    	sum = 0;
    	for(int i=mid+1; i<high; i++) {
    		sum  += a[i];
    		if(rightsum < sum) leftsum = sum;
    	}
    	return leftsum + rightsum;
    }

}
