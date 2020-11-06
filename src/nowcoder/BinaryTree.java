package nowcoder;


import java.util.*;

public class BinaryTree {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(9);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);

        TreeNode t22 = new TreeNode(8);
        TreeNode t23 = new TreeNode(9);
        TreeNode t24 = new TreeNode(2);


        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t4.right = t7;

        t22.left= t23;
        t23.left= t24;

         FindPath(t1, 18);

    }

//    public static void main(String[] args) {
//        BinaryTree2 bt = new BinaryTree2();
//        int[] s = {1,4,7,6,3,13,14,10,8};
//
//        System.out.println(bt.VerifySquenceOfBST2(s));
//    }

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

    public static ArrayList<Integer> levelPrint(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> tmp = new LinkedList<>();

        tmp.add(root);

        while(tmp.size() != 0) {
            TreeNode treeNode = tmp.remove();
            res.add(treeNode.val);
            if(treeNode.left != null) tmp.add(treeNode.left);
            if(treeNode.right != null) tmp.add(treeNode.right);

        }

        return res;

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

    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {

        if(root2 == null || root1==null) return false;
        if(root2.left==null && root2.right==null && root1.val == root2.val) return true;

        if(root1.val == root2.val) {

            if(root2.right == null) {
                return HasSubtree(root1.left, root2.left);
            } else if(root2.left == null) {
                return HasSubtree(root1.right, root2.right);
            } else {
                if(!(HasSubtree(root1.left, root2.left) && HasSubtree(root1.right, root2.right))) {
                    return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
                } else {
                    return  true;
                }
            }

        } else {
            return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }

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

    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     * @param sequence
     * @return
     * 解法 1.从后往前遍历数组重建二叉树，生成后续遍历与输入数组对比
     *     2.（Best）数组最后元素为根结点，前半部分小于根结点的是左子树，大于根结点的是右子树，而左右子树又二叉树的后序遍历
     *     值得注意的是，过程中需判断子树是不是合规
     */
    public boolean VerifySquenceOfBST(int [] sequence) {

        if(sequence == null) return false;
        if(sequence.length == 1) return true;
        ArrayList<Integer> res = new ArrayList<>();

        TreeNode root  = new TreeNode(sequence[sequence.length-1]);
        TreeNode tmp = root;

        for (int i = sequence.length-2; i >= 0; i--) {
            tmp = insertBinaryTree(sequence[i], tmp);
        }

        System.out.println(root);

        post(tmp, res);

        for (int i = 0; i < sequence.length; i++) {
            if(sequence[i] != res.get(i)) {
                return false;
            }
        }
        return true;

    }

    public boolean VerifySquenceOfBST2(int [] sequence) {

        if(sequence == null || sequence.length==0) return false;
        if(sequence.length == 1) return true;

        int last = sequence[sequence.length-1];
        int indexOfMid = find(Arrays.copyOfRange(sequence, 0, sequence.length-1), last);


        if(indexOfMid > 0 && indexOfMid < sequence.length-1) {
            for (int i = 0; i < indexOfMid; i++) { if(sequence[i] > last) return false; }
            for (int i = indexOfMid; i < sequence.length-1; i++) { if(sequence[i] < last) return false; }

            return VerifySquenceOfBST2(Arrays.copyOfRange(sequence, 0, indexOfMid))
                    && VerifySquenceOfBST2(Arrays.copyOfRange(sequence, indexOfMid, sequence.length - 1));

        } else {

            if(indexOfMid == 0) {
                for (int i = indexOfMid; i < sequence.length-1; i++) { if(sequence[i] < last) return false; }
            } else if(indexOfMid == -1) {
                for (int i = 0; i < sequence.length-1; i++) { if(sequence[i] > last) return false; }
            }

            return VerifySquenceOfBST2(Arrays.copyOfRange(sequence, 0, sequence.length-1));

        }


    }

    public int find(int [] sequence, int target) {
        if(sequence == null || sequence.length==0) return -1;

        for (int i = 0; i < sequence.length; i++) {
            if(sequence[i] > target) {
                return i;
            }
        }

        return -1;

    }



    private void post(TreeNode root, ArrayList<Integer> res) {
        if(root == null) return;
        post(root.left, res);
        post(root.right, res);
        res.add(root.val);
    }

    private TreeNode insertBinaryTree(int x, TreeNode root) {
        if(root == null) return new TreeNode(x);

        if(x<root.val) root.left = insertBinaryTree(x, root.left);
        if(x>root.val) root.right = insertBinaryTree(x, root.right);

        return root;

    }

    /**
     *输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
     * @param root
     * @param target
     * @return
     */
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> re = new ArrayList<>();

        res.add(FindPath(root, target, res, re));


        return res;

    }

    public static ArrayList<Integer> FindPath(TreeNode root, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> re) {


        if(root == null) return re;

        int rest = target - root.val;
        re.add(root.val);

        if(rest == 0) {
            return re;
        }

        res.add(FindPath(root.left, rest, res, re));
        res.add(FindPath(root.right, rest, res, re));


        return re;

    }

    public TreeNode Mirror(TreeNode root) {

        TreeNode tmp = null;

        if(root==null || (root.left==null && root.right==null)) return root;

        tmp = root.left;
        root.left = Mirror(root.right);
        root.right = Mirror(tmp);

        return root;
    }


//    Definition for binary tree
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
