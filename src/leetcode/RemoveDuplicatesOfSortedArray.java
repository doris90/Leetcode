/*
 * 需求：将排序数组中的相同时数值移除
 * 思路：1、维护一个重置数组的引用，和当前数组的引用；
 * 		 2、重置数组的第一位由当前第一位初始化；
 * 		 3、依次比较当前数组每一位为重置数组当前位，若不同，重置数组扩大以为，添入
 * */

package leetcode;

public class RemoveDuplicatesOfSortedArray {

	public static void main(String[] args) {
		int[] a = {1,1};
		System.out.print(removeDuplicates(a));

	}
	
    public static int removeDuplicates(int[] nums) {
    	/*
    	 * 处理边界*/
    	if(nums == null || nums.length == 0) return 0;
    	if(nums.length == 1) return 1;
    	//定义重置后数组长度-1位置
        int start = 0;
        //遍历数组
        for(int i=1; i<nums.length; i++) {
        	int temp = nums[start];  
        	if(temp != nums[i]) {//新数组（重置数值）的当期值与原数组的值依次比较，当不相等时
        		start++; // 重置数组扩大一位
        		nums[start] = nums[i];  //容纳不相等的值 		
        	}
        	
        }
        
        return start + 1 ; // 由于start指向重置数组末尾下标，长度需要+1
    }

}
