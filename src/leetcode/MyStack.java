/*
 * �����ö���ʵ��ջ
 * ˼·����ɾ�Ĳ�Ķ���Ϊ������λԪ�ؼ��ɣ�
 */


package leetcode;
import java.util.*;

public class MyStack {
	LinkedList<Integer> q = new LinkedList<Integer>(); 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    // Push element x onto stack.
    public void push(int x) {
        q.addFirst(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        q.removeFirst();
    }

    // Get the top element.
    public int top() {
    	return q.peekFirst();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }

}
