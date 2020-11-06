package leetcode2;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Stack;

public class BSTIterator {
    ArrayDeque<TreeNode> stack = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
        if(root != null) {
            fullFillStack(root);
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(7);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(9);
        TreeNode t5 = new TreeNode(20);

        t1.left = t2;
        t1.right = t3;

        t3.left = t4;
        t3.right = t5;

        BSTIterator iterator = new BSTIterator(t1);

        System.out.println(iterator.next());    // return 3
        System.out.println(iterator.next());    // return 7
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.next());    // return 9
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.next());    // return 15
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.next());    // return 20
        System.out.println(iterator.hasNext()); // return false
    }

    private void fullFillStack(TreeNode root) {
        if(root == null) return;
        fullFillStack(root.left);
        stack.add(root);
        fullFillStack(root.right);

    }

    /** @return the next smallest number */
    public int next() {
        if(!stack.isEmpty()) {
            return stack.pop().val;
        } else {
            return -1;
        }

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
