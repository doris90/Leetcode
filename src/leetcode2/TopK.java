package leetcode2;

import common.TreeNode;

import java.util.*;

import static common.TreeNode.createBinaryTreeByArray;

public class TopK {

    public static void main(String[] args) {
        Integer[] in = {41,37,44,24,39,42,48,1,35,38,40,null,43,46,49,0,2,30,36,null,null,null,null,null,null,45,47,null,null,null,null,null,4,29,32,null,null,null,null,null,null,3,9,26,null,31,34,null,null,7,11,25,27,null,null,33,null,6,8,10,16,null,null,null,28,null,null,5,null,null,null,null,null,15,19,null,null,null,null,12,null,18,20,null,13,17,null,null,22,null,14,null,null,21,23};

        TreeNode root = createBinaryTreeByArray(in, 0);

        System.out.println(kthSmallest(root, 25));

    }

    public static List<Integer> topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> count = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i],0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n1).compareTo(count.get(n2)));

        for (Integer val : count.keySet()) {
            heap.add(val);

            if(heap.size() > k) {
                heap.poll();
            }
        }

        LinkedList<Integer> res = new LinkedList<>();

        while(!heap.isEmpty()) {
            res.add(heap.poll());
        }

        Collections.reverse(res);

        return res;

    }

    public static int kthSmallest(TreeNode root, int k) {
        TreeNode tmp = root;

        LinkedList<TreeNode> stack = new LinkedList<>();

        while(true) {

            while(tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            }

            tmp = stack.removeFirst();
            k--;

            if(k==0) return tmp.val;

            tmp = tmp.right;

        }




    }
}
