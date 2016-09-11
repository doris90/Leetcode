/*
 * 需求：将两个排序好的数组合并
 * 思路：从后往前的归并排序；在目标数组中直接归并
 * 		该思路同试用于两排序好链表合并*/

package leetcode;

public class MergeSortedArray {

	public static void main(String[] args) {
		int[] a = new int[2];
		a[0] = 2;
		int[] b = {1};
		merge(a, 1, b, 1);
		//System.out.println();
		/*
		 *		for(int i=0; i<3; i++) {
			System.out.print(a[i]);
		} */

	}
	
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
    	if(m == 0) {
    		for(int i=0; i<n; i++) {
    			nums1[i] = nums2[i];
    		}
    	}
    	int p = m-1;
    	int q = n-1;
    	for(int i=(m+n-1); i>=0; i--) {
    		if(p >= 0 && q >= 0) {
    			if(nums1[p] >= nums2[q]) {
    				nums1[i] = nums1[p];
    				p--;
    				continue;
    			}
    			else{
    				nums1[i] = nums2[q];
    				q--;
    				continue;
    			}
    		}
    		if(q >= 0) {
				nums1[i] = nums2[q];
				q--;
				continue;
    		}
    	}
    	sop(nums1);
	}
    
    public static void sop(int[] a) {
    	for(int i=0; i<a.length; i++) {
    		System.out.print(a[i] + " ");
    	}
    }

}
