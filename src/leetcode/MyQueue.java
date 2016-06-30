/*
 * ������ջʵ�ֶ���
 * ˼·����ѹ��ջ����ʱ����ÿ��ѹ���Ԫ�ط���ջ�ס�ͨ������һ����ʱջ����ѹ��Ԫ��ʱ��������Ԫ��������ʱջ��ѹ��
 * �ٽ�����Ԫ���ƻ�������ȻջΪ�յ�ʱ��ֱ��ѹ�롣
 * */

package leetcode;

import java.util.*;

class MyQueue {
	
	Stack<Integer> s = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        if(s.size() == 0) s.push(x);
        else{
        	Stack<Integer> temp = new Stack<Integer>();
        	while(!s.isEmpty()) {
        		temp.push(s.pop());
        	}
        	s.push(x);
        	while(!temp.isEmpty()) {
        		s.push(temp.pop());
        	}
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        s.pop();
    }

    // Get the front element.
    public int peek() {
        return s.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
       return s.isEmpty();
    }
}