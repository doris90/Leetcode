package leetcode;

public class MergeSortedArray {

	public static void main(String[] args) {
		int[] a = new int[1];
		//a[0] = 1;
		int[] b = {1};
		merge(a, 0, b, 1);
		//System.out.println();
		/*
		 *		for(int i=0; i<3; i++) {
			System.out.print(a[i]);
		} */

	}
	
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] res = new int[nums1.length];
		int p = 0;
		int q = 0;
		for(int i=0; i<res.length; i++) {
			if(p != m && q != n) {
				if(nums1[p] <= nums2[q]){
					res[i] = nums1[p];
					p++;
					continue;
				}
				else {
    				res[i] = nums2[q];
    				q++;
    				continue;
				}
			}
			
			if(p == m && q != n) {
				res[i] = nums2[q];
				q++;
				continue;
			}
			if(p != m && q == n) {
				res[i] = nums1[p];
				p++;
				continue;
			}
		}
		nums1 = res;
		//for(int k=0; k<res.length; k++) {
		  //  nums1[k] = res[k];
		//}
		sop(nums1);
	}
    
    public static void sop(int[] a) {
    	for(int i=0; i<a.length; i++) {
    		System.out.print(a[i]);
    	}
    }

}
