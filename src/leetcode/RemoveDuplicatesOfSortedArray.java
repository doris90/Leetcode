/*
 * ���󣺽����������е���ͬʱ��ֵ�Ƴ�
 * ˼·��1��ά��һ��������������ã��͵�ǰ��������ã�
 * 		 2����������ĵ�һλ�ɵ�ǰ��һλ��ʼ����
 * 		 3�����αȽϵ�ǰ����ÿһλΪ�������鵱ǰλ������ͬ����������������Ϊ������
 * */

package leetcode;

public class RemoveDuplicatesOfSortedArray {

	public static void main(String[] args) {
		int[] a = {1,1};
		System.out.print(removeDuplicates(a));

	}
	
    public static int removeDuplicates(int[] nums) {
    	/*
    	 * ����߽�*/
    	if(nums == null || nums.length == 0) return 0;
    	if(nums.length == 1) return 1;
    	//�������ú����鳤��-1λ��
        int start = 0;
        //��������
        for(int i=1; i<nums.length; i++) {
        	int temp = nums[start];  
        	if(temp != nums[i]) {//�����飨������ֵ���ĵ���ֵ��ԭ�����ֵ���αȽϣ��������ʱ
        		start++; // ������������һλ
        		nums[start] = nums[i];  //���ɲ���ȵ�ֵ 		
        	}
        	
        }
        
        return start + 1 ; // ����startָ����������ĩβ�±꣬������Ҫ+1
    }

}
