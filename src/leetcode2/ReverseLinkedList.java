package leetcode2;

import common.ListNode;
import nowcoder.List;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode res = reverseList(l1);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }

    public static ListNode reverseList(ListNode l) {

        if(l==null || l.next==null) return l;

        ListNode pre = null;
        ListNode cur = l;
        ListNode last = l.next;

        while(cur != null) {
            cur.next = pre;

            pre = cur;
            cur = last;
            if(last != null) {
                last = last.next;
            }

        }

        return pre;

    }


}
