package leetcode;

public class PathSum {

	public static void main(String[] args) {
		PathSum ps = new PathSum();
		TreeNode node5 = ps.new TreeNode(5);
		TreeNode node4 = ps.new TreeNode(4);
		TreeNode node8 = ps.new TreeNode(8);
		TreeNode node11 = ps.new TreeNode(11);
		TreeNode node13 = ps.new TreeNode(13);
		TreeNode node44 = ps.new TreeNode(4);
		TreeNode node7 = ps.new TreeNode(7);
		TreeNode node2 = ps.new TreeNode(2);
		TreeNode node1 = ps.new TreeNode(1);
		node5.left = node4;
		node5.right = node8;
		node4.left = node11;
		node11.left = node7;
		node11.right = node2;
		node8.left = node13;
		node8.right = node44;
		node44.right = node1;
		
		System.out.println(hasPathSum(node5, 18));

	}
	
	public class TreeNode {
		int val;
		TreeNode left , right;
		TreeNode(int x) {
			this.val = x;
		}
	}
	
    public static boolean hasPathSum(TreeNode root, int sum) {
    	if(root == null) return false;
    	if(root.left == null && root.right == null) {
    		if(root.val == sum) return true;
    	}
    	return hasPathSum(root.left , sum - root.val) || hasPathSum(root.right , sum - root.val);
    }

}
