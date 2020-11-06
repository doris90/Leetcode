package leetcode2;

import java.util.*;

public class Array {

    public static void main(String[] args) {
        int[] nums = {5,1,3,4,7};
        Array array = new Array();
//        int[]integers = array.dailyTemperatures(nums);

//        System.out.println(integers);

    }

    //todo
//    public int[] dailyTemperatures(int[] T) {
//
//    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> list = new LinkedList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[list.size()][]);
    }

    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;

        if(n > 0 && k >= 1 && k <= (n*n)) {
            PriorityQueue<Tuple> que = new PriorityQueue<>();

            for (int i = 0; i < n; i++) {
                que.offer(new Tuple(0, i, matrix[0][i]));
            }

            for (int i = 0; i < k-1; i++) {
                Tuple tuple = que.poll();

                if(tuple.x == n) continue;
                System.out.println(tuple.val);

                que.offer(new Tuple(tuple.x + 1, tuple.y, matrix[tuple.x + 1][tuple.y]));
            }

            return que.poll().val;
        }

        return -1;

    }

    class Tuple implements Comparable<Tuple> {

        int x;
        int y;
        int val;

        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple o) {
            return this.val - o.val;
        }
    }


    /**
     * =========================找数组里面重复的数字===========================
     *
     * 将数组转化成，index和val 组成的链表。例如{1,2,3,2,2}
     * 0->1->2->3->2
     *
     *重复数子是链表环的入口点
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {

        if(nums.length > 1) {

            int slow = nums[0];
            int fast = nums[nums[0]];

            while(slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;

            while (fast != slow) {
                fast = nums[fast];
                slow = nums[slow];
            }

            return fast;

        }

        return -1;

    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;


        for (int i = 0; i < n/2; i++) {

            for (int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = tmp;
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i > j) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                } else {
                    continue;
                }
            }
        }

    }

    public void quickSort(int[] a, int lo, int hi) {
        if(lo <= hi) return;

        int j = partition(a, lo, hi);

        quickSort(a, lo, j-1);
        quickSort(a, j+1, hi);
    }


    public int findKthLargest(int[] nums, int k) {

        int lo = 0;
        int hi = nums.length - 1;
        k  = nums.length - k;

        while(hi > lo) {
            int j = partition(nums, lo, hi);
//            System.out.println(j);

            if(k > j) {
                lo = j+1;
            } else if(k < j) {
                hi = j-1;
            } else {
                break;
            }
        }

        return nums[k];

    }

    private int partition(int[] a, int lo, int hi) {

        if(hi <= lo) return 0;

        int v = a[lo];
        int i = lo+1;
        int j = hi;

        while(true) {
            while(a[i] <= v) {
                if(i==hi) break;
                i++;
            }
            while(a[j] > v) {
                if(j==lo) break;
                j--;
            }

            if(i >= j) break;

            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;

        }

        a[lo] = a[j];
        a[j] = v;

        return j;

    }

    private void exch(int[] nums, int m, int n) {

        if(nums[m] == nums[n]) return;

        int tmp = nums[m];
        nums[m] = nums[n];
        nums[n] = tmp;
    }

    private boolean less(int v, int w) {
        return v < w;
    }
}
