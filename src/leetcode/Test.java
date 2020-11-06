package leetcode;
import java.util.*;

public class Test {
	
	public static void main(String[] args) {
		AddTwoNumbers.ListNode l10 = new AddTwoNumbers.ListNode(1);
		AddTwoNumbers.ListNode l11 = new AddTwoNumbers.ListNode(4);
		AddTwoNumbers.ListNode l12 = new AddTwoNumbers.ListNode(3);

		l10.next = l11;
		l11.next = l12;
		System.out.println(printListFromTailToHead(l10));
		
	}

		public static boolean Find(int target, int [][] array) {

			boolean isFound = false;

			for (int i = 0; i < array.length; i++) {

				if(isFound) break;

				int[] tmp = array[i];

				for (int j = 0; j < tmp.length; j++) {

					int cur = tmp[j];

					if(cur == target) {
						isFound = true;
						break;
					}
				}

			}

			return isFound;

		}

	public static String replaceSpace(StringBuffer str) {
		String res = "";

		if(str==null || str.length()==0) return res;

		res = str.toString().replace(" ","%20");

		return res;
	}

	public static ArrayList<Integer> printListFromTailToHead(AddTwoNumbers.ListNode listNode) {

		AddTwoNumbers.ListNode pre = null;
		AddTwoNumbers.ListNode cur = listNode;
		AddTwoNumbers.ListNode n = listNode.next;

		while(cur != null) {
			cur.next = pre;
			pre = cur;
			cur = n;
			if(n != null)n = n.next;
		}
		listNode = pre;

		ArrayList<Integer> res = new ArrayList<>();

		while (listNode != null) {
			res.add(listNode.val);
			listNode = listNode.next;
		}

		return res;
	}

}
