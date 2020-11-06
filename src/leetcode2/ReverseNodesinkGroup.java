package leetcode2;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public class ReverseNodesinkGroup {

    /**
     * https://leetcode.com/problems/reverse-nodes-in-k-group/
     *
     * 反转链表：
     * 1.全部反转： 三指针，pre=null; cur=first; last=first.next; 每次cur.next = pre; then 位置后移
     * 2.部分反转：先反转部分，剩下的递归本方法（大问题的子问题）， 注意边界问题
     */

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

        ListNode res = reverseBetween(l1, 4, 6);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }

    /**
     *
     * @param head
     * @param m
     * @param n
     * @return
     * Reverse a linked list from position m to n. Do it in one-pass
     * Note: 1 ≤ m ≤ n ≤ length of list.
     * Example:
     *
     * Input: 1->2->3->4->5->NULL, m = 2, n = 4
     * Output: 1->4->3->2->5->NULL
     */

    public static ListNode reverseBetween(ListNode head, int m, int n) {

        if(head == null || head.next == null || m>=n || m<1) return head;

        int count = 1;
        ListNode cur = head;
        ListNode tail = head;

        ListNode tmpTail = null;
        ListNode tmpHead = null;

        while (count < m) {
            if(count == m-1) tmpTail = cur;
            cur = cur.next;
            count++;
        }

        tail = cur;
        while (count < n) {
            tail = tail.next;
            count++;
        }

        tmpHead = tail.next;
        tail.next = null;

        List<ListNode> midList = reversListNode(cur);

        if(midList.size() == 0) {

            if(tmpTail != null) {
                tmpTail.next = tmpHead;
            } else {
                return tmpHead;
            }

        } else if(midList.size() == 1) {

            if(tmpTail != null) {
                tmpTail.next = midList.get(0);
            }
            midList.get(0).next = tmpHead;
        } else {
            midList.get(0).next = tmpHead;

            if(tmpTail != null) {
                tmpTail.next = midList.get(1);
            } else {
                return midList.get(1);
            }

        }

        return head;

    }


    public static ListNode reverseKGroup(ListNode head, int k) {

        if(head == null || head.next == null || k <= 0) return head;

        ListNode l = head;
        int size = 0;
        while(l != null) {
            size++;
            l = l.next;
        }

        if(size < k) return head;

        ListNode pre = null;
        ListNode cur = head;
        ListNode last = head.next;

        int count = 0;
        while(cur != null && count < k) {
            cur.next = pre;
            count++;

            if(count != k) {
                pre = cur;
                cur = last;
                if(last != null) last = last.next;
            }
        }


        while(pre!= null && pre.next != null) {
            pre = pre.next;
        }

        if(pre == null) {
            cur.next = reverseKGroup(last, k);
        } else {
            pre.next = reverseKGroup(last, k);
        }


        return cur;

    }

    public static List<ListNode> reversListNode(ListNode head) {
        ArrayList<ListNode> res = new ArrayList<>();
        res.add(head);

        if(head == null || head.next == null) {
            return res;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode last = head.next;

        while (cur != null) {
            cur.next = pre;

            pre = cur;
            cur = last;
            if(last != null) {
                last = last.next;
            }
        }
        res.add(pre);

        return res;

    }
}
