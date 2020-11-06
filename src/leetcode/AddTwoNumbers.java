package leetcode;

import org.w3c.dom.NodeList;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */


public class AddTwoNumbers {
    private int a = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            if(a == 1) {
                return new ListNode(1);
            }else {
                return null;
            }
        }

//        if(l1 == null && l2 != null) {
//            if((l2.val+a) <= 9) {
//                ListNode ll = new ListNode(l2.val + a);
//                ll.next = l2.next;
//                return ll;
//            } else {
//                ListNode ll = new ListNode(0);
//                ll.next = addTwoNumbers(null, l2.next);
//                return ll;
//            }
//
//        }
//        if(l2 == null && l1 != null) {
//            if((l1.val+a) <= 9) {
//                ListNode ll = new ListNode(l1.val + a);
//                ll.next = l1.next;
//                return ll;
//            } else {
//                ListNode ll = new ListNode(0);
//                ll.next = addTwoNumbers(null, l1.next);
//                return ll;            }
//
//        }

        ListNode res = new ListNode(-1);

//        if(l2 != null && l1 != null){
            res.val = (l1.val + l2.val + a) % 10;

            if((l1.val + l2.val + a)>9) a = 1;
            else a = 0;
//        }

        res.next = addTwoNumbers(l1.next, l2.next);

        return res;

//        ListNode dummyHead = new ListNode(0);
//        ListNode p = l1, q = l2, curr = dummyHead;
//        int carry = 0;
//        while (p != null || q != null) {
//            int x = (p != null) ? p.val : 0;
//            int y = (q != null) ? q.val : 0;
//            int sum = carry + x + y;
//            carry = sum / 10;
//            curr.next = new ListNode(sum % 10);
//            curr = curr.next;
//            if (p != null) p = p.next;
//            if (q != null) q = q.next;
//        }
//        if (carry > 0) {
//            curr.next = new ListNode(carry);
//        }
//        return dummyHead.next;

    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        ListNode l10 = new ListNode(1);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(3);

        l10.next = l11;
        l11.next = l12;

        ListNode l20 = new ListNode(9);
        ListNode l21 = new ListNode(9);
        ListNode l22 = new ListNode(9);

        l20.next = l21;
        l21.next = l22;

        ListNode l = addTwoNumbers.addTwoNumbers(l10, l20);

        while(l != null) {
            System.out.println(l.val);
            l=l.next;

        }

    }
}
