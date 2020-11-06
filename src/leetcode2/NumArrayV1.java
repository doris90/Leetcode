package leetcode2;


public class NumArrayV1 {
    SegmentTreeNode root;

    /**
     * Solution2: SegmentTree refer to resource/segment-tree1
     * https://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
     * https://leetcode.com/problems/range-sum-query-mutable/discuss/75724/17-ms-Java-solution-with-segment-tree
     */

    public static void main(String[] args) {
        int[] in = {0,9,5,7,3};

        NumArrayV1 numArray = new NumArrayV1(in);

        System.out.println(numArray.update(4, 5, numArray.root));
        System.out.println(numArray.update(1, 7, numArray.root));
        System.out.println(numArray.update(0, 8, numArray.root));
        System.out.println(numArray.sumRange(1, 2, numArray.root));

    }

    public class SegmentTreeNode {
        public int start;
        public int end;
        public int val;
        public SegmentTreeNode left;
        public SegmentTreeNode right;
        public SegmentTreeNode(){}

        public SegmentTreeNode(int start, int end, int val) {
            this.start = start;
            this.end = end;
            this.val = val;
        }
    }

    public NumArrayV1(int[] nums) {

        root = buildSegmentTree(nums, 0, nums.length-1);

    }

    private SegmentTreeNode buildSegmentTree(int[] nums, int start, int end) {
        SegmentTreeNode root = new SegmentTreeNode();
        root.start = start;
        root.end = end;

        if(start == end) {
            root.val = nums[start];
        } else {
            int mid = start + (end-start)/2;

            root.left = buildSegmentTree(nums, start, mid);
            root.right = buildSegmentTree(nums, mid+1, end);

            root.val = root.left.val + root.right.val;
        }

        return root;
    }

    public SegmentTreeNode update(int i, int val, SegmentTreeNode root) {

        if(i == root.start && i==root.end) {
            root.val = val;
            return root;
        }

        int mid = root.start + (root.end - root.start)/2;

        if(i <= mid) {
            root.left = update(i, val, root.left);
        } else {
            root.right = update(i, val, root.right);
        }

        root.val = root.left.val + root.right.val;

        return root;


    }

    public int sumRange(int i, int j, SegmentTreeNode root) {
        int res;
        if(i < root.start) i=root.start;
        if(j > root.end) j=root.end;

        if(root.start ==i && root.end==j) {
            return root.val;
        }

        int mid = root.start + (root.end - root.start)/2;

        if(j <= mid) {
            res = sumRange(i, j, root.left);
        } else if(i >= mid + 1) {
            res = sumRange(i, j, root.right);
        } else {
            res = sumRange(i, mid, root.left) + sumRange(mid+1, j, root.right);
        }

        return res;

    }

}
