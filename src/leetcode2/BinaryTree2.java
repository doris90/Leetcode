package leetcode2;

import common.DLinkedNode;
import common.TreeNode;

import java.util.*;
import java.util.LinkedList;

public class BinaryTree2 {

    Map<Integer, Integer> map = new HashMap<>();
    int maxCnt;

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(5);

        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(1);
//        TreeNode t6 = new TreeNode(0);
//        TreeNode t7 = new TreeNode(1);

        t1.left = t2;
        t1.right = t3;


        t2.left = t4;
        t2.right = t5;

//        t3.left = t6;
        t3.right = t6;

        BinaryTree2 binaryTree2 = new BinaryTree2();
        int rob = binaryTree2.rob(t1);

        System.out.println(rob);
    }

    public int rob(TreeNode root) {

        Map<TreeNode, Integer> map = new HashMap<>();

        return robHelper(root, map);

    }

    public int robHelper(TreeNode root, Map<TreeNode, Integer> map) {

        if(root == null) return 0;
        int val = 0;

        if(map.containsKey(root)) return map.get(root);

        if(root.left != null) {
            val = val +  robHelper(root.left.left, map) + robHelper(root.left.right, map);
        }

        if(root.right != null) {
            val = val +  robHelper(root.right.left, map) + robHelper(root.right.right, map);
        }

        val = Math.max(val + root.val, robHelper(root.left, map) + robHelper(root.right, map));
        map.put(root, val);

        return val;

    }

    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null) return null;

        if(key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if(key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {

            if(root.left == null) {
                return root.right;
            }

            if(root.right == null) {
                return root.left;
            }

            TreeNode rightMin = finMin(root.right);

            root.val = rightMin.val;

            root.right = deleteNode(root.right, rightMin.val);


        }

        return root;

    }

    public TreeNode finMin(TreeNode root) {

        if(root == null) return null;

        while(root.left != null) {
            root = root.left;
        }

        return root;

    }



    public boolean isValidBST(TreeNode root) {

        if(root == null) return true;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;

        while(root != null || !stack.isEmpty()) {

            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();

                if(pre != null && pre.val >= root.val) return false;
                pre = root;
                System.out.println(root.val);

                root = root.right;
            }

        }

        return true;

    }


    /**
     * =====================Convert Binary Search Tree to Sorted Doubly Linked List=============
     * @param root
     * @return
     */
    public static DLinkedNode BSTtoDoubleLinkedList(TreeNode root) {

        if(root == null) return null;
        if(root.left == root.right && root.left==null) {
            return new DLinkedNode(root.val);
        }

        DLinkedNode left = BSTtoDoubleLinkedList(root.left);
        DLinkedNode right = BSTtoDoubleLinkedList(root.right);

        DLinkedNode node = new DLinkedNode(root.val);

        node.post = right;
        node.pre = left;
        left.post = node;
        right.pre = node;

        return left;

    }

    /**
     * =================================Convert Sorted List to Binary Search Tree====================
     * @param head
     * @return
     */
//    public static TreeNode sortedListToBST(ListNode head) {
//
//
//    }



    /**
     * =================================Flatten Binary Tree to Linked List====================
     * DFS -> Stack
     * @param root
     * @return
     */
    public static TreeNode flattenDFS(TreeNode root) {

        if(root == null) return null;
        if(root.left == root.right && root.right== null) return new TreeNode(root.val);

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {

            TreeNode cur = stack.pop();

            if(cur.right != null) {stack.push(cur.right);}
            if(cur.left != null) {stack.push(cur.left);}

            cur.left = null;
            if(!stack.isEmpty()) {cur.right = stack.peek();}
        }

        return root;


    }

    public TreeNode flatten(TreeNode root) {

        if(root == null) return null;
        if(root.left == root.right && root.right== null) return new TreeNode(root.val);


        TreeNode left = flatten(root.left);
        TreeNode right = flatten(root.right);

        root.right = left;
        root.left = null;

        if(left != null) {
            TreeNode tmp = left;
            while(tmp.right != null) { tmp = tmp.right; }
            tmp.right = right;
        }
        else {root.right = right; }

        return root;
    }

    public static TreeNode reverseBinaryTree(TreeNode root) {
        if(root == null || (root.left==null && root.right==null)) return root;

        TreeNode p1 = reverseBinaryTree(root.left);
        root.left = reverseBinaryTree(root.right);
        root.right = p1;

        return root;
    }

    public static List<Integer> rightSideViewBFS(TreeNode root) {

        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) return res;

        Queue<TreeNode> que = new LinkedList();

        que.add(root);

        while (!que.isEmpty()) {
            int size = que.size();

            while(size-- > 0) {

                TreeNode node = que.poll();

                if(size == 0) {
                    res.add(node.val);
                }

                if(node.left != null) que.add(node.left);
                if(node.right != null) { que.add(node.right); }
            }

        }

        return res;
    }

    public static List<Integer> leftSideViewBFS(TreeNode root) {

        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) return res;

        Queue<TreeNode> que = new LinkedList();

        que.add(root);

        while (!que.isEmpty()) {
            int size = que.size();

            while(size-- > 0) {

                TreeNode node = que.poll();

                if(size == 0) {
                    res.add(node.val);
                }

                if(node.right != null) que.add(node.right);
                if(node.left != null) { que.add(node.left); }
            }

        }

        return res;
    }


    public static List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> res = new LinkedList<>();
        List<Integer> re = new LinkedList<>();

        if(root == null) return res;

        pathSumDFS(root, sum, re, res);

        return res;

    }

    public static void pathSumDFS(TreeNode root, int sum, List<Integer> re, List<List<Integer>> res) {

        if(root == null) return;

        if(root.val == sum && root.left==null && root.right==null) {
            re.add(root.val);
            res.add(new LinkedList<>(re));
            re.remove(re.size()-1);
            return;
        }

        int remaining = sum - root.val;

        if(remaining <= 0) return;

        re.add(root.val);
        pathSumDFS(root.left, remaining, re, res);

        pathSumDFS(root.right, remaining, re, res);
        if(re.size() != 0) re.remove(re.size()-1);


    }


    public static void preOrderPrintNonRecursive(TreeNode root) {

        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(! stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            System.out.print(tmp.val);

            if(tmp.right != null) stack.push(tmp.right);
            if(tmp.left != null) stack.push(tmp.left);
        }

    }

    public static void inOrderPrintNonRecursive(TreeNode root) {

        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {

            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();

                System.out.println(pop.val);

                root = pop.right;
            }

        }


    }

    public static void level(TreeNode root) {
        if(root == null) return;

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode tmp = queue.remove();

            System.out.println(tmp.val);

            if(tmp.left != null) {
                queue.add(tmp.left);
            }

            if(tmp.right != null) {
                queue.add(tmp.right);
            }
        }

    }

    /**
     * ==============================================层序遍历二叉树===================
     * 层序遍历，利用queue进出， 分别是进，出
     * 重点是进出都是按层level 的
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();

        if(root == null) return res;


        queue.add(root);

        while( ! queue.isEmpty()) {

            int levelNum = queue.size();
            List<Integer> re = new LinkedList<>();

            for (int i = 0; i < levelNum; i++) {
                TreeNode cur = queue.removeFirst();
                re.add(cur.val);

                if(cur.left != null) {queue.add(cur.left);}
                if(cur.right != null) {queue.add(cur.right);}
            }

            res.add(re);
        }

        return res;

    }

    public static TreeNode pruneTree(TreeNode root) {

        if(root.left != null) {
            root.left = pruneTree(root.left);
        }

        if(root.right != null) {
            root.right = pruneTree(root.right);
        }

        if(root.left == null && root.right == null) {
            if(root.val == 0) {return null;}
            if(root.val == 1) {return root;}
        }

        return root;
    }

    public int sumNumbers(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        dfsHelper(res,"", root);

        int result=0;

        for (Integer re : res) {
            result = result + re;
        }

        return result;

    }

    public void dfsHelper(List<Integer> res, String re, TreeNode root) {

        if(root == null) return;

        if(root.left == null && root.right == null) {
            re = re + root.val;
            res.add(Integer.valueOf(re));
            return;
        } else {

            dfsHelper(res, re + root.val, root.left);
            dfsHelper(res, re + root.val, root.right);

        }

        return;

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || p==null || q==null) return null;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) return root;
        else if(left == null && right != null) return right;
        else if(left != null && right == null) return left;
        else {
            return null;
        }

    }


    public int[] findFrequentTreeSum(TreeNode root) {

        findFrequentTreeSumHelper(root);
        List<Integer> res = new LinkedList<>();

        for (Integer sum : map.keySet()) {

            if(map.get(sum) == maxCnt) {
                res.add(sum);
            }
        }

        int[] out = new int[res.size()];

        for (int i = 0; i < out.length; i++) {
            out[i] = res.get(i);
        }


        return out;
    }


    public int findFrequentTreeSumHelper(TreeNode root) {

        if(root == null) return 0;

        int leftSum = findFrequentTreeSumHelper(root.left);
        int rightSum = findFrequentTreeSumHelper(root.right);

        int sum = root.val + leftSum + rightSum;

        map.put(sum, map.getOrDefault(sum, 0) + 1);

        maxCnt = Math.max(maxCnt, map.get(sum));

        return sum;


    }





}
