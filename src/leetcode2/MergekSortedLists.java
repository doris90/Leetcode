package leetcode2;

import common.ListNode;
import leetcode.MergeTwoLists;
import nowcoder.List;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(6);
        n1.next = n2;

        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(2);
        ListNode m3 = new ListNode(3);

        m1.next = m2;
        m2.next = m3;

        ListNode[] lists = {n1, m1};

        ListNode node = mergeKLists(lists);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {


        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (o1, o2) -> {
            if(o1.val > o2.val) {
                return 1;
            } else if(o1.val == o2.val) {
                return 0;
            } else {
                return -1;
            }
        });

        for (ListNode list : lists) {
            queue.add(list);
        }

        ListNode head = queue.poll();
        queue.add(head.next);

        ListNode p = head;

        while (! queue.isEmpty()) {

            p.next = queue.poll();

            p = p.next;

            if(p != null && p.next != null) queue.add(p.next);

        }

        return head;


    }
}
