package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sums3 {


    public static void main(String[] args) {
        Sums3 s1 = new Sums3();

        int[] t1 = new int[] {
                0, 0
        };

        printList(s1.threeSum(t1));
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            if(i>0 && nums[i] == nums[i-1]) continue;

            int target = -nums[i];

            int j = i+1;
            int k = nums.length - 1;

            while(j < k) {

                if(nums[j] + nums[k] == target) {
                    //Add nums to list
                    res.add(new ArrayList<>(
                            Arrays.asList(nums[i], nums[j], nums[k])
                    ));

                    k--;
                    j++;

                    while(j < k && nums[k] == nums[k+1]) k--;
                    while(j < k && nums[j] == nums[j-1]) j++;
                } else if(nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }

        }

        return res;

    }


    public static void printList(List<List<Integer>> lists) {

        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.println(integer);
            }

        }

    }
}
