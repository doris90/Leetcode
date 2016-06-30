/*
 * 需求：将两个排好序的链表合成一个有序链表
 * 算法：1.维护一个新链表存储合成的有序链表
 * 		 2.采用归并排序的算法依次判断各个结点
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
