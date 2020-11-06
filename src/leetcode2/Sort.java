package leetcode2;

public class Sort {

    public static void main(String[] args) {
        int[] s = {3,3,3};
        Sort sort = new Sort();

        sort.quickSort(s);

        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i]);
        }
    }

    /**
     * ===============================归并排序===========================
     */
    //1. 归并一个两部分有序数组
    private void merge(int[] a, int lo, int hi) {
        int[] aux = new int[a.length];

        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        int i = lo;
        int mid = lo + (hi-lo)/2;
        int j = mid+1;

        for (int k = lo; k <= hi; k++) {
            if(i > mid) a[k] = aux[j++];
            else if(j > hi) a[k] = aux[i++];
            else if(aux[i] < aux[j]) a[k] = aux[i++];
            else if(aux[i] >= aux[j]) a[k] = aux[j++];
        }

    }

    //2. 归并排序
    public void mergeSort(int[] a) {
        mergeSort(a, 0, a.length-1);
        System.out.println("Done");
    }

    private void mergeSort(int[] a, int lo, int hi) {

        if(hi <= lo) return;
        int mid = lo + (hi - lo)/2;

        mergeSort(a, lo, mid);
        mergeSort(a, mid+1, hi);

        merge(a, lo, hi);
    }

    /**
     * ===============================快速排序===========================
     */

    public void quickSort(int[] a) {
        quickSortHelper(a, 0, a.length-1);
    }

    private void quickSortHelper(int[] a, int lo, int hi) {
        if(hi <= lo) return;
        int k = partition(a, lo, hi);
        System.out.println(k);
        quickSortHelper(a, lo, k-1);
        quickSortHelper(a, k+1, hi);

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

    /**
     * ===============================堆排序===========================
     * Reference： https://www.youtube.com/watch?v=HqPJF2L5h9U
     * Code: https://blog.csdn.net/yellojesse/article/details/90731395
     *
     * 1. 堆有序
     * 2. delete max then 堆有序
     */

    public void heapSort(int[] a) {
        int len = a.length;

        //堆有序
        for (int i = (a.length/2-1); i >= 0; i--) {
            sink(a, i, a.length);
        }

        while (len > 1) {
            swap(a, 0, len-1);
            len--;
            sink(a, 0, len);
        }



    }

    private void sink(int[] a, int i, int len) {

        while(true) {

            int maxPosition = i;
            int leftKid = 2*i + 1;
            int rightKid = 2*i + 2;

            if(leftKid<len && a[leftKid] > a[i]) {
                maxPosition = leftKid;
            }

            if(rightKid<len && a[rightKid] > a[maxPosition]) {
                maxPosition = rightKid;
            }

            if(maxPosition == i) break;
            else {
                swap(a, i, maxPosition);
                 i = maxPosition;
            }

        }

    }

    private void swap(int[] a, int i, int j) {

        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
