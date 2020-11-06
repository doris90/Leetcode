package leetcode2;

import common.ListNode;
import common.Node;
import nowcoder.List;


/**
 * 和链表路径有关的，快慢指针v1=v; v2=2v;
 */
public class ListCycle {

    /*public static void main(String[] args) {
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
//        l6.next = l1;

        ListNode res = middleNode(l1);

        System.out.println(res.getVal());

    }*/


    /**
     *
     * 链表有环，快慢指针是否相遇，有环的话，快两步，慢一步，有环快慢终归相遇
     *https://leetcode.com/problems/linked-list-cycle/
     * @param head
     * @return
     * Given a linked list, determine if it has a cycle in it.
     *
     * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
     */

    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode faster = head;
        ListNode slower = head;

        while(faster != null && faster.next != null) {
            faster = faster.next.next;
            slower = slower.next;

            if(faster == slower) return true;
        }

        return false;

    }


    /**
     * 链表有环，快慢指针
     *Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
     * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
     * Note: Do not modify the linked list.
     * @param head
     * @return
     *
     */
    public static ListNode detectCycle(ListNode head) {

        if(head == null || head.next == null) return null;

        ListNode faster = head;
        ListNode slower = head;
        ListNode p1 = head;
        ListNode p2 = null;


        while(faster != null && faster.next != null) {
            faster = faster.next.next;
            slower = slower.next;

            if(faster == slower) {

                p2 = faster;

                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }

                return p1;

            }
        }

        return null;

    }

    /**
     * 找链表中点， 快慢指针
     * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
     *
     * If there are two middle nodes, return the second middle node.
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode faster = head;
        ListNode slower = head;

        while (faster != null && faster.next!=null) {
            faster = faster.next.next;
            slower = slower.next;
        }

        return slower;

    }

    public static void main(String[] args) {
        Node p1 = new Node(1, null, null, null);
        Node p2 = new Node(2, null, null, null);
        Node p3 = new Node(3, null, null, null);
        Node p4 = new Node(4, null, null, null);
        Node p5 = new Node(5, null, null, null);
        Node p6 = new Node(6, null, null, null);

        Node p7 = new Node(7, null, null, null);
        Node p8 = new Node(8, null, null, null);
        Node p9 = new Node(9, null, null, null);
        Node p10 = new Node(10, null, null, null);

        Node p11 = new Node(11, null, null, null);
        Node p12 = new Node(12, null, null, null);

        p1.next = p2;
        p2.prev = p1;
        p2.next = p3;
        p3.prev = p2;
        p3.next = p4;
        p4.prev = p3;
        p4.next = p5;
        p5.prev = p4;
        p5.next = p6;
        p6.prev = p5;

        p3.child = p7;

        p7.next = p8;
        p8.prev = p7;
        p8.next = p9;
        p9.prev = p8;
        p9.next = p10;
        p10.prev = p9;

        p11.next = p12;
        p12.prev = p11;

        p4.child = p11;

        flatten(p1);

    }

    public static Node flatten(Node head) {
        if(head == null) return head;

        if(head.prev==null && head.next==null && head.child==null) return head;
        Node p1 = head;

        while(p1 != null && p1.child == null) {
            p1 = p1.next;
        }

        if(p1 != null) {
            Node tmpR = p1.next;

            Node p3 = flatten(p1.child);
            Node p2 = flatten(tmpR);

            p1.next = p3;
            p3.prev = p1;

            Node p3Tail = p3;
            while(p3Tail.next !=null) {
                p3Tail = p3Tail.next;
            }

            p3Tail.next = p2;
            if(p2 != null) {
                p2.prev = p3Tail;
            }

            p1.child=null;

        }

        return head;
    }

   /* public ListNode mergeKLists(ListNode[] lists) {


    }*/
}
