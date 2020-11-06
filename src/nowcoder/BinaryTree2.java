package nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree2 {

    /**
     *
     * @param pRootOfTree 输入一棵二叉搜索树
     * @return 将该二叉搜索树转换成一个排序的双向链表
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向
     */

    public static TreeNode Convert(TreeNode pRootOfTree) {

        if(pRootOfTree == null) return null;
        if(pRootOfTree.left == null && pRootOfTree.right==null) return pRootOfTree;

        if(pRootOfTree.left.left == null && pRootOfTree.left.right == null) {
            pRootOfTree.left.right = pRootOfTree;
        }

        if(pRootOfTree.right.left == null && pRootOfTree.right.right == null) {
            pRootOfTree.right.left = pRootOfTree;
        }

        TreeNode lNode = Convert(pRootOfTree.left);

        TreeNode tmp = lNode;
        while (tmp.right != null) {
            tmp = tmp.right;
        }
        tmp.right = pRootOfTree;
        pRootOfTree.left = tmp;

        TreeNode rNode = Convert(pRootOfTree.right);
        rNode.left = pRootOfTree;
        pRootOfTree.right = rNode;

        return lNode;
    }

    private ArrayList<Integer> re = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    /**
     * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     * (注意: 在返回值的list中，数组长度大的数组靠前)
     * @param root
     *
     * 解法：定义两个篮子，大篮子和小篮子。小篮子ArrayList<Integer> re 装当时当刻的路径结果；大篮子装总结果。
     * 二叉树所有路径做先序遍历，到叶子节点判断此路径是否合规，是加入res，or not.加入时应该重新new
     * 注意，每遍历完一条路径，要删除re的最后节点
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {

        if(root == null) return res;
        re.add(root.val);

        if(root.val == target && root.left==null && root.right==null) {
            res.add(new ArrayList<>(re));
        }

        int remain = target - root.val;

        FindPath(root.left, remain);
        FindPath(root.right, remain);

        re.remove(re.size()-1);

        return res;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(14);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(8);
        TreeNode t6 = new TreeNode(12);
        TreeNode t7 = new TreeNode(16);

        TreeNode t22 = new TreeNode(8);
        TreeNode t23 = new TreeNode(9);
        TreeNode t24 = new TreeNode(2);


        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        t22.left= t23;
        t23.left= t24;

        TreeNode x =Convert(t1);
        System.out.println("");

    }




//    Definition for binary tree
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
