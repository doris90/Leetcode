package leetcode2;

import java.util.*;

/**
 * 跟找到所有的组合有关
 */
public class BackTracking {
    Map<String, String> phone = new HashMap<String, String>(){{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};



    public static void main(String[] args) {
        BackTracking backTracking = new BackTracking();
        List<String> strings = backTracking.letterCombinations("23");

        for (String string : strings) {
            System.out.println(string);
        }
    }


    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        letterCombinationsHelper(ans, "", digits);

        return ans;
    }

    public void letterCombinationsHelper(List<String> ans, String com, String remaining) {

        if(remaining.length() == 0) {
            ans.add(com);
            return;
        } else {
            String digit = remaining.substring(0, 1);
            String letters = phone.get(digit);

            for (int i = 0; i < letters.length(); i++) {
                letterCombinationsHelper(ans, com + letters.charAt(i), remaining.substring(1));
            }

        }

    }


    public static List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();

        backTrack(ans, "", 0,0, n);

        return ans;

    }

    public static void backTrack(List<String> ans, String cur, int open, int close, int max) {

        if (cur.length() == max*2) {
            ans.add(cur);
            return;

        } else {

            if(open < max) {
                backTrack(ans, cur+"(", open + 1, close, max);
            }
            if(close < open) {
                backTrack(ans, cur+")", open, close + 1, max);
            }


        }

    }

    /**
     * ====================================Combination sum================================
     * @param candidates
     * @param target
     * @return
     */

    public List<List<Integer>> combinationSumUnique(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();

        LinkedList<Integer> re = new LinkedList<>();

        Arrays.sort(candidates);

        combinationSumUniqueHelper(res, re, candidates, target, 0);

        System.out.println(res.size());
        for (List<Integer> rei : res) {

            for (Integer r : rei) {
                System.out.print(r);
            }

            System.out.println();
        }

        return res;

    }

    public void combinationSumUniqueHelper(List<List<Integer>> res, LinkedList<Integer> re, int[] candidates, int target, int start) {

        if(target == 0) {
            res.add(new ArrayList<>(re));
        } else {

            for (int i = start; i < candidates.length; i++) {

                if(i>start && candidates[i] == candidates[i-1]) continue;

                int remain = target - candidates[i];

                if(remain < 0) {
                    continue;
                }

                re.add(candidates[i]);

                combinationSumUniqueHelper(res, re, candidates, remain, i+1);

                re.removeLast();

            }
        }

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();

        LinkedList<Integer> re = new LinkedList<>();

        combinationSumHelper(res, re, candidates, target, 0);

        System.out.println(res.size());
        for (List<Integer> rei : res) {

            for (Integer r : rei) {
                System.out.print(r);
            }

            System.out.println();
        }

        return res;
    }

    public void combinationSumHelper(List<List<Integer>> res, LinkedList<Integer> re, int[] candidates, int target, int start) {

        if(target == 0) {
            res.add(new ArrayList<>(re));
        } else {

            for (int i = start; i < candidates.length; i++) {
                int remain = 0;

                for (int j = 1; j <= target; j++) {
                    remain = target - candidates[i]*j;

                    if(remain < 0) break;

                    for (int k = 0; k < j; k++) {
                        re.add(candidates[i]);
                    }

                    if(remain >= 0) {
                        combinationSumHelper(res, re, candidates, remain, i+1);
                    }

                    for (int k = 0; k < j; k++) {
                        re.removeLast();
                    }
                }



            }
        }

    }

    /**
     * ====================================全排列数组================================
     * @param nums
     * @return
     */

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        LinkedList<Integer> re = new LinkedList<>();

        int[] used = new int[nums.length];
        Arrays.fill(used, 0);

        Arrays.sort(nums);

        permuteUniqueHelper(res, re, nums, used);

        for (List<Integer> rei : res) {

            for (Integer r : rei) {
                System.out.print(r);
            }

            System.out.println();
        }

        return res;
    }

    /**
     * 标记每个元素是否被使用过 used[i]
     * @param res
     * @param re
     * @param nums
     * @param used
     */
    private void permuteUniqueHelper(List<List<Integer>> res, LinkedList<Integer> re, int[] nums, int[] used) {

        if(re.size() == nums.length) {
            res.add(new ArrayList(re));
        } else {

            for (int i = 0; i < nums.length ; i++) {

                if(i>0 && nums[i]==nums[i-1] && used[i-1]==1) continue;

                if(used[i] == 1) continue;

                re.add(nums[i]);
                used[i] = 1;

                permuteUniqueHelper(res, re, nums, used);

                re.removeLast();
                used[i] = 0;


            }
        }


    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        LinkedList<Integer> re = new LinkedList<>();

        permuteHelper(res, re, nums);

        for (List<Integer> rei : res) {

            for (Integer i : rei) {
                System.out.print(i);
            }

            System.out.println();
        }

        return res;


    }

    private void permuteHelper(List<List<Integer>> res, LinkedList<Integer> re, int[] nums) {

        if(re.size() == nums.length) {
            res.add(new LinkedList<>(re));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if(re.contains(nums[i])) continue;

                re.add(nums[i]);

                permuteHelper(res, re, nums);

                re.removeLast();
            }
        }

    }


    /**
     * ====================================数组集合的所有子集===========================
     *
     * @param nums
     * @return
     */

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> re = new LinkedList<>();

        //Important: 因为后续会根据比大小，来skip，所以数组应该有序
        Arrays.sort(nums);


        subsetsWithDupHelper(res, re, nums, 0);

        for (List<Integer> rei : res) {
            for (Integer i : rei) {
                System.out.print(i);
            }
            System.out.println();
        }

        return res;
    }

    /**
     *
     * @param res
     * @param re
     * @param nums
     * @param start
     */
    private void subsetsWithDupHelper(List<List<Integer>> res, LinkedList<Integer> re, int[] nums, int start) {

        res.add(new ArrayList<>(re));

        for (int i = start; i < nums.length; i++) {

            //每一次递归，新的起点都是 start
            if(i>start && nums[i]==nums[i-1]) continue;

            re.add(nums[i]);

            subsetsWithDupHelper(res, re, nums, i+1);

            re.removeLast();
        }


    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> re = new LinkedList<>();

        subsetsHelper(res, re, nums, nums.length);

        for (List<Integer> rei : res) {
            for (Integer i : rei) {
                System.out.print(i);
            }
            System.out.println();
        }

        return res;
    }

    private void subsetsHelper(List<List<Integer>> res, LinkedList<Integer> re, int[] nums, int k) {

        if(k == 0) {
            ArrayList<Integer> tmpList = new ArrayList<>();
            for (int i = 0; i < re.size(); i++) {
                if(re.get(i) != 0) {

                    tmpList.add(nums[i]);
                }
            }
            res.add(tmpList);
            return;

        } else {

            re.add(0);
            subsetsHelper(res, re, nums, k-1);

            re.removeLast();

            re.add(1);
            subsetsHelper(res, re, nums, k-1);

            re.removeLast();

        }
    }

}
