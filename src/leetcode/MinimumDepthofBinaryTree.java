/*
 * ���������������·��
 * ˼·��1�����ڵ�գ�����0��
 * 2�����ڵ����Ҷ���Ϊ�գ�����1��
 * 3�����ڵ�������Ϊ���Ҳ�Ϊ�գ����������������·��+1
 * 4�����ڵ�������Ϊ����Ϊ�գ����������������·��+1
 * 5�����ڵ�������������Ϊ�գ����������������·������Сֵ+1
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
