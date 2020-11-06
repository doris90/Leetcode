package leetcode2;

import common.ListNode;
import nowcoder.List;

import javax.sound.sampled.Line;
import java.util.Stack;

public class LinkedListQs {

    public static void main(String[] args) {
        LinkedListQs linkedList = new LinkedListQs();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(7);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        ListNode listNode = linkedList.sortList(l1);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * ==============================奇数位链表在前偶数位在后===========================
     *
     * 通过三根指针拆分成奇数链表和偶数链表，两条链表，再把偶数链表链在奇数链表后面
     * 通过奇数个元素链表和偶数个元素链表，确认越界条件
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {

        if(head == null) return null;

        ListNode od = head;
        ListNode ev = head.next;
        ListNode evHead = head.next;

        while (ev != null && ev.next != null) {
            od.next = ev.next;
            ev.next = ev.next.next;
            od = od.next;
            ev = ev.next;
        }

        od.next = evHead;

        return head;


    }


    /**
     * ==============================链表排序===========================
     * 完完全全归并排序
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        //1. [Fast-slow pointer]cut the list into 2 at the middle point
        //lst1 is head(to pre), lst2 is slow (to null)

        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = head;

        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;


        //2. then, sort left side and right side recursively
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        //3. merge left and right lists

        return merge(l1, l2);

    }

    private static ListNode merge(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        while(l1 != null || l2 != null) {
            if(l1 == null) {
                p.next = l2;
                break;
            }

            if(l2 == null) {
                p.next = l1;
                break;
            }

            if(l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }

            p = p.next;
        }

        return dummy.next;

    }

    public ListNode lastKNode(ListNode head, int k) {

        if(head == null || k == 0) return null;

        int n = k-1;
        ListNode p1 = head;
        ListNode tail = head;

        while(n != 0 && tail != null) {
            tail = tail.next;

            if(tail == null) return null;

            n--;
        }

        while(tail.next != null) {

            p1 = p1.next;

            tail = tail.next;
        }

        return p1;

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = new ListNode(-1);
        ListNode pre = new ListNode(-1);
        ListNode cur = new ListNode(-1);

        while(s1.size() != 0 || s2.size() != 0 || carry != 0) {
            int re = 0;


            if((!s1.empty()) && (!s2.empty())) {
                re = s1.pop() + s2.pop() + carry;

            } else if((s1.empty()) && (!s2.empty())) {
                re = s2.pop() + carry;

            } else if((!s1.empty()) && (s2.empty())) {
                re = s1.pop() + carry;

            } else {

                if(carry != 0) {
                    re = carry;
                }
            }

            if(carry == 1) {
                carry = 0;
            }

            if(re > 9) {
                re = re%10;
                carry = 1;
            }

            cur = new ListNode(re);

            if(head.val == -1) head = cur;
            if(pre.val == -1) pre = cur;

            if(cur != pre) {
                cur.next = pre;
                pre = cur;
            }

        }



        return cur;


    }
}
