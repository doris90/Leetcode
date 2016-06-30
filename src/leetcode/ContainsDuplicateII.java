/*
 * ����:����һ�����飬��������������±��ľ���ֵ�����ڸ�������һ��ֵk������true�����򷵻�false
 * ˼·��1������HashMap������ֵΪ�����±�ֵΪֵ����Ϊֻ�ܴӼ��õ�ֵ��
 * 		2����������ļ���
 * 				�����У���ȡ�õ�ǰ�±��������ĸü���Ӧ��ֵ��֮ǰ���±꣩�ж��Ƿ�С��k�� �ǵĻ�������true���񣬷��ظ���ԭ�������꣨��Ϊ�����ܻ������ԭ���������������±��ˣ�
 * 				�������������*/

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
