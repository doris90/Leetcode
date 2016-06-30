/*
 * 需求：用栈实现队列
 * 思路：在压入栈操作时，将每次压入的元素放入栈底。通过创建一个临时栈，当压入元素时，将所有元素移入临时栈，压入
 * 再将所有元素移回来；当然栈为空的时候，直接压入。
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