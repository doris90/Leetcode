package nowcoder;


import leetcode.AddTwoNumbers;
import leetcode.MergeTwoLists;

public class FindKthToTail {

    public static void main(String[] args) {
        ListNode l10 = new ListNode(1);
        ListNode l11 = new ListNode(5);
        ListNode l12 = new ListNode(8);
        ListNode l20 = new ListNode(2);
        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(9);

        l10.next = l11;
        l11.next = l12;
        l20.next = l21;
        l21.next = l22;
        System.out.println(Merge(null, l20));
    }

    public static ListNode FindKthToTail(ListNode head, int k) {
        if(head == null){return null;}

        ListNode first = head;
        ListNode last = head;

        for(int i=1; i<=k; i++) {
            if(last.next != null) {
                last = last.next;
            } else {
                return null;
            }

        }

        while(last != null) {
            first = first.next;
            last = last.next;
        }

        return first;

    }

    public static ListNode Merge(ListNode list1,ListNode list2) {

        if (list1 == null && list2 == null) return null;
        if (list1 != null && list2 == null) return list1;
        if (list1 == null && list2 != null) return list2;

        ListNode res = null;


        if(list1.val <= list2.val) {
            res = new ListNode(list1.val);
            res.next = Merge(list1.next, list2);
        } else {
            res = new ListNode(list2.val);
            res.next = Merge(list1, list2.next);
        }

        return res;

    }



public static class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
}
