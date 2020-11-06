package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    public static void main(String[] args) {

        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};

        TreeNode treeNode = reConstructBinaryTree(pre, in);

        System.out.println(treeNode);
    }

    public static void preOrderPrint(TreeNode root) {

        if(root == null) {
            return;
        }

        System.out.print(root.val);
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }

    public static void inOrderPrint(TreeNode root) {

        if(root == null) {
            return;
        }

        inOrderPrint(root.left);
        System.out.print(root.val);
        inOrderPrint(root.right);
    }

    public static void postOrderPrint(TreeNode root) {

        if(root == null) {
            return;
        }

        postOrderPrint(root.left);
        postOrderPrint(root.right);
        System.out.print(root.val);
    }

    public static TreeNode levelPrint(TreeNode root) {

        if(root == null || (root.left==null && root.right==null)) return root;

        Queue<TreeNode> que = new LinkedList();

        que.add(root);

        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            System.out.println(node.val);

            levelPrint(node.left);
            levelPrint(node.right);
        }


        return root;
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        if((pre==null || pre.length==0) && (in==null||in.length==0)) return null;

        int rootVal = pre[0];
        int index = searchIndex(in, rootVal);
        TreeNode treeNode = new TreeNode(rootVal);

        int[] tmpInLeft = Arrays.copyOfRange(in,0, index);
        int[] tmpPreLeft = Arrays.copyOfRange(pre,1, tmpInLeft.length+1);
        treeNode.left = reConstructBinaryTree(tmpPreLeft, tmpInLeft);

        int[] tmpInRight = Arrays.copyOfRange(in,index+1, in.length);
        int[] tmpPreRight = Arrays.copyOfRange(pre,pre.length-tmpInRight.length, pre.length);
        treeNode.right = reConstructBinaryTree(tmpPreRight, tmpInRight);

        return treeNode;
    }

    private static int searchIndex(int[] a, int key) {
        if(a == null || a.length==0) return -1;

        for (int i = 0; i < a.length; i++) {
            if(a[i] == key) {
                return i;
            }
        }

        return -1;
    }



//    Definition for binary tree
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
