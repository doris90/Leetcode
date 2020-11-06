/*
 * ���󣺲����������������������
 * ˼·��������������ͨ��ѭ��ǰ��������ص���ά������int ������ʵ�ֿ��
 * ���裺1���������������ֱ���ArrayList res װ������������ArrayList levelRes װÿһ��ı��������LinkedListQs nodesװ���б����Ľ��
 * 		 2���ص���ά������int curLevelCnt��nextLevelCnt������
 * 		 3��ͨ��ѭ��ʵ�������������ڵ����ڶ�������н���ѭ����ȡ����ǰ�����׽ڵ㣬ȥȡ���뼯�ϣ���������һ�������ж��ӽڵ㣬�ǿս��ӣ��ӽڵ�����һ��
 * 		 4��������������ܼ��ϣ�ͨ��ǰ��ʵ�ֵ��򣩣�ͨ��2��������ʵ�ֿ�㣻
 * 		 5��ѭ�����������ؽ��
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
