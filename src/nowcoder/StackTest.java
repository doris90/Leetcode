package nowcoder;

import java.util.Stack;

public class StackTest {
    /**
     * 维护一个数据栈
     * 维护一个实时最小数据栈
     *  push 和 pop 实时维护
     */

    Stack dataStack = new Stack<Integer>();
    Stack minStack = new Stack<Integer>();

    public void push(int node) {
        dataStack.push(node);

        if(minStack.size() == 0) {
            minStack.push(node);
        } else if(!(node < (Integer) minStack.peek())) {
            minStack.push(node);
        }

    }

    public void pop() {
        int x = (Integer)dataStack.pop();
        if(x == (Integer) minStack.peek()) {
            minStack.pop();
        }

    }

    public int top() {

        return (Integer) dataStack.peek();
    }

    public int min() {
        return (Integer) minStack.peek();
    }

    /**
     * 第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序
     * 切记中间有进有出
     * 维护一个栈，一遍压栈数组A，当遇到数组B第一个数字pop, 压完再抛
     * 抛完并遍历完B数组，证明是出栈序列，否则不是
     */

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA==null || popA==null || pushA.length != popA.length)return false;

        Stack dataStack = new Stack<Integer>();
        int tmp = 0;
        for (int i = 0; i < pushA.length; i++) {
            dataStack.push(pushA[i]);
            if(pushA[i] == popA[tmp]) {
                dataStack.pop();
                tmp++;
            }
        }

        while(dataStack.size() != 0) {
            if((Integer)dataStack.pop() != popA[tmp]) {
                return false;
            } else {
                tmp++;
            }
        }

        return true;
    }

}
