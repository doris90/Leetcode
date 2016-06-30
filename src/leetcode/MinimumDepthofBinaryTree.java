/*
 * 需求：求解二叉树最短路径
 * 思路：1、根节点空，返回0；
 * 2、根节点左右都不为空，返回1；
 * 3、根节点左子树为空右不为空，返回其右子树最短路径+1
 * 4、根节点右子树为空左不为空，返回其左子树最短路径+1
 * 5、根节点左右子树都不为空，返回左右子树最短路径的最小值+1
 * */

package leetcode;

public class MinimumDepthofBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right != null) return minDepth(root.right) + 1;
        if(root.right == null && root.left != null) return minDepth(root.left) + 1;
        if(root.left != null && root.right != null)return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        else return 1;
    }

}
