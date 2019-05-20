package leetcode;

import java.util.Arrays;

public class Sum3Closest {

    public static void main(String[] args) {
        Sum3Closest s1 = new Sum3Closest();

        int[] t1 = new int[] {
                1,1,-1,-1,3
        };

        System.out.println(s1.threeSumClosest(t1, -1));
    }

    public int threeSumClosest(int[] nums, int target) {

        //ask for the result for illegal input
        if(nums==null || nums.length<3) return Integer.MIN_VALUE;

        int res = nums[0] + nums[1] + nums[2];

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {


            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {

                int tmp = nums[i] + nums[j] + nums[k];

                if(Math.abs(target - tmp) < Math.abs(res-target)) {
                    res = tmp;
                }

                if(tmp > target) k--;
                else {
                    j++;
                }

            }

        }

        return res;


    }
}
