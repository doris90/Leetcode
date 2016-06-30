/*
 * ���󣺽������ź��������ϳ�һ����������
 * �㷨��1.ά��һ��������洢�ϳɵ���������
 * 		 2.���ù鲢������㷨�����жϸ������
 * */

package leetcode;

public class MergeTwoLists {
	
	public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if(l1 == null && l2 == null) return null;
    	if(l1 != null && l2 == null) return l1;
    	if(l1 == null && l2 != null) return l2;
    	ListNode t;
        if(l1.val <= l2.val) {
        	t = l1;
        	l1 = l1.next;
        }
        else{
        	t = l2;
        	l2 = l2.next;
        }
        t.next = mergeTwoLists(l1, l2);
        return t;
    }

}
