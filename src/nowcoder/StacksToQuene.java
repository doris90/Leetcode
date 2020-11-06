package nowcoder;

import java.util.Arrays;
import java.util.Stack;

public class StacksToQuene {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {

        stack1.push(node);
    }

    public int pop() {

        if(!stack2.empty()) {
            return stack2.pop();
        } else {
            while(!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }

    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        StacksToQuene stacksToQuene = new StacksToQuene();

        for (int i = 0; i < a.length; i++) {
            stacksToQuene.push(a[i]);
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(stacksToQuene.pop());
        }
    }
}
