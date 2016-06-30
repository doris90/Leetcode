/*
 * 需求：求出两条链表的交汇点
 * 思路1：求出两条链表的长度和其相差的长度，利用双指针，通过相差长度，使指针距交汇点等距，再同步查找前进
 * 思路2：保存链表路径于较短容器，遍历较长链表，看路径节点是否已存于容器，即为交汇点，否则无交汇点*/

package leetcode;

import java.util.*;

public class IntersectionofTwoLinkedLists {
	
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntersectionofTwoLinkedLists x = new IntersectionofTwoLinkedLists();
		ListNode a1 = x.new ListNode(2);
		ListNode a2 = x.new ListNode(3);
		ListNode b1 = a2;
		a1.next = a2;
		//b1.next = a2;
		System.out.println(getIntersectionNode(a1, b1).val);
	}
	/*
	 * public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        if(headA == headB) return headA;
        int la = 0;
        int lb = 0;
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA !=null) {
        	la++;
        	pA = pA.next;
        }
        while(pB !=null) {
        	lb++;
        	pB = pB.next;
        }
        pA = headA;
        pB = headB;
        int delta = Math.abs(la - lb);
                
        if(la > lb) {
        	while(delta-- != 0) {
        		pA = pA.next;
        	}
        }
        else if(la < lb) {
        	while(delta-- != 0) {
        		pB = pB.next;
        	}
        }
    	while(pA != null && pB != null){
        	if(pA == pB) return pA;
        	else {
        		pA = pA.next;
        		pB = pB.next;
        	}
    	}
        return null;
    }
    O(m+n) O(1)
    */
    
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {  //O(m+n) O(Math.min(la, lb))
        int la = 0;
        int lb = 0;
        ListNode pA = headA;
        ListNode pB = headB;
        Set<ListNode> set = new HashSet<ListNode>();
        //计算链表长度
        while(pA !=null) {
        	la++;
        	pA = pA.next;
        }
        while(pB !=null) {
        	lb++;
        	pB = pB.next;
        }
        //选择较短链表存入容器
        if(la <= lb) {
        	pA = headA;
        	pB = headB;
        }
        else {
        	pB = headA;
        	pA = headB;
        }
        while(pA != null) {
        	set.add(pA);
        	pA = pA.next;
        }
        //遍历较长链表，查找交点
        while(pB != null) {
        	if(set.contains(pB)) return pB;
        	pB = pB.next;
        }
        return null;
    } 
}
