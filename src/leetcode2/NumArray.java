package leetcode2;

public class NumArray {
    int[] sum;
    int[] storedNums;

    public static void main(String[] args) {
        int[] nums = {1,3,5};

        NumArray numArray = new NumArray(nums);

        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));

    }

    /**
     * Solution1: fomular f(i,j) = sum(j)-sum(i-1)
     * sum[i] means sum of 0 to i and i must >=1 sum[0]
     */

    public NumArray(int[] nums) {
        sum = new int[nums.length];
        storedNums = nums;

        for (int i = 0; i < storedNums.length; i++) {
            if(i == 0) {
                sum[i] = storedNums[i];
                continue;
            }

            sum[i] = sum[i-1] + storedNums[i];
        }

    }

    public void update(int i, int val) {
        storedNums[i] = val;
        int k=i;

        if(i==0) {
            sum[i] = val;
            k=1;
        }
        for (int j = k; j < storedNums.length; j++) {
            sum[j] = sum[j-1] + storedNums[j];
        }

    }

    public int sumRange(int i, int j) {

        if(i == 0) return sum[j];

        return sum[j]-sum[i-1];

    }
}
