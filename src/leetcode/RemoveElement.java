/*
 * �����Ƴ������и�������ֵ
 * ˼·��ά������ָ�룬һ������ԭ���飬һ�����ø����飨���㿪ʼ�����η��������в�����ָ��ֵ�����������շ������鳤��
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
