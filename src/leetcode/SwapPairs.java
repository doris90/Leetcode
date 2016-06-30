package leetcode;

import leetcode.MergeTwoLists.ListNode;

public class SwapPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ListNode swapPairs(ListNode head) {
    	if(head == null) return null;
    	if(head != null && head.next == null) return head;
    	ListNode t;
    	t = head.next;
    	head.next = t.next;
    	t.next = head;
    	head = t;
    	head.next.next = swapPairs(head.next.next);
    	return head;
    }

}
