/*
 * 需求：层序遍历二叉树结果逆序输出
 * 思路：创建队列链表，通过循环前序遍历；重点是维护两个int 变量来实现跨层
 * 步骤：1、分三个容器，分别是ArrayList res 装最终输出结果；ArrayList levelRes 装每一层的遍历结果；LinkedList nodes装所有遍历的结点
 * 		 2、重点是维护两个int curLevelCnt、nextLevelCnt变量来
 * 		 3、通过循环实现逐层遍历（父节点已在队列里，队列进入循环，取出当前队列首节点，去取进入集合，本层数减一；依次判断子节点，非空进队，子节点数加一）
 * 		 4、将逐层结果插入总集合（通过前插实现倒序），通过2中俩变量实现跨层；
 * 		 5、循环结束，返回结果
 * */


package leetcode;

import java.util.*;

public class LevelOrderBottom {
	
	public static void main(String[] args) {
		LevelOrderBottom lob = new LevelOrderBottom();
		TreeNode node1 = lob.new TreeNode(3);
		TreeNode node2 = lob.new TreeNode(9);
		TreeNode node3 = lob.new TreeNode(20);
		TreeNode node4 = lob.new TreeNode(15);
		TreeNode node5 = lob.new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		
		levelOrderBottom(node1);
	}
	
	public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
	
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
    	if(root == null) return null;
    	
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	List<Integer> levelres = new ArrayList<Integer>();
    	Queue<TreeNode> nodes = new LinkedList<TreeNode>();
    	int curLevelCnt = 1;
    	int nextLevelCnt = 0;
    	
    	nodes.add(root);
    	while(!nodes.isEmpty()) {
    		TreeNode temp = nodes.poll();
    		System.out.println(temp.val);
    		levelres.add(temp.val);
    		curLevelCnt--;

    		if(temp.left != null) {
    			nodes.add(temp.left);
    			nextLevelCnt++;
    		}
    		if(temp.right != null) {
    			nodes.add(temp.right);
    			nextLevelCnt++;
    		}
    		
    		if(curLevelCnt == 0) {
    			curLevelCnt = nextLevelCnt;
    			nextLevelCnt = 0;
    			res.add(0,levelres);
    			levelres  = new ArrayList<Integer>();
    		}
    	}
    	return res;

    }
}
