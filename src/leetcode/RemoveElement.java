/*
 * 需求：移除数组中给定的数值
 * 思路：维护两个指针，一个遍历原数组，一个重置该数组（从零开始，依次放置数组中不等于指定值的数），最终返回数组长度
 * */

package leetcode;

public class RemoveElement {

	public static void main(String[] args) {
		int[] a = {3 , 2 , 2 , 3};
		
    		System.out.println(removeElement(a, 3));
	}
	
    public static int removeElement(int[] nums, int val) {
    	if(nums == null || nums.length == 0) return 0;
    	int start = 0;
    	for(int i=0; i<nums.length; i++) {
    		if(nums[i] != val) {
    			if(nums[start] != nums[i]) {
        			nums[start] = nums[i];
        			start++;
    			}

    		}
    	}
    	return start;
    }


}
