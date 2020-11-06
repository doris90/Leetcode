package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static leetcode.Sums3.printList;

public class Sum4 {

    public static void main(String[] args) {
        int[] t1 = new int[] {
                0,2,2,2,10,-3,-9,2,-10,-4,-9,-2,2,8,7
        };

        int target = 6;

        printList(fourSum(t1, target));

    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        if(nums == null || nums.length < 4) return new ArrayList<>();

        List<List<Integer>> res =  new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {

            if(i>0 && nums[i-1] == nums[i]) continue;

            for (int z = i+1; z < nums.length-2; z++) {

                if(z>i+1 && nums[z] == nums[z-1]) continue;

                int tgt = target - (nums[i] + nums[z]);

                int j = z+1;

                int k = nums.length-1;

                while(j<k) {
                    int tmp = nums[j] + nums[k];
                    if( tmp - tgt > 0) k--;
                    else if(tmp - tgt < 0) j++;
                    else {

                        List<Integer> list = Arrays.asList(nums[i], nums[z], nums[j], nums[k]);

//                        if(! isContains(list, res)) {
                            res.add(Arrays.asList(nums[i], nums[z], nums[j], nums[k]));
                        System.out.println(nums[i]+";" +nums[z]+ ";" +nums[j]+ ";" +nums[k]);
//                        }


                        j++;
                        k--;

                        while(j<k && nums[j-1]==nums[j]) j++;
                        while(j<k && nums[k+1]==nums[k]) k--;
                    }

                }

            }


            
        }

        return res;


    }

    private static boolean isContains(List<Integer> list, List<List<Integer>> res) {

        for (List<Integer> re : res) {

            if(re.containsAll(list)) {
                return true;
            }


        }

        return false;
    }


}
