/*
 * 需求:给定一个数组，若两个相等数的下标差的绝对值不大于给定的另一个值k，返回true；否则返回false
 * 思路：1、定义HashMap，数组值为键，下标值为值（因为只能从键得到值）
 * 		2、遍历数组的键，
 * 				若含有，则取得当前下标和容器里的该键对应的值（之前的下标）判断是否小于k。 是的话，返回true；否，返回覆盖原来的坐标（因为不可能会出现与原来坐标符合命题的下标了）
 * 				否则添加入容器*/

package leetcode;

import java.util.*;

public class ContainsDuplicateII {

	public static void main(String[] args) {
		int[] a = {1,0,1,1};
		System.out.println(containsNearbyDuplicate(a, 1));


	}
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		if(nums == null || nums.length == 0) return false;
		
		Map<Integer , Integer> a = new HashMap<Integer , Integer>();
		a.put(nums[0] , 0);
        for(int i=1; i<nums.length; i++) {
        	if(a.containsKey(nums[i])) {
        		if(Math.abs(a.get(nums[i])-i) <= k) return true;
        		else a.put(nums[i] , i);
        	}
        	else {
        		a.put(nums[i] , i);
        	}
        }
        return false;
    }
	
   

}
