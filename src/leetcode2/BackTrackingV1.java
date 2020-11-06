package leetcode2;

import java.util.*;

/**
 * 跟找到所有的组合有关
 */
public class BackTrackingV1 {
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
        BackTrackingV1 backTracking = new BackTrackingV1();

        List<String> strings = backTracking.countSubstrings("aaa");

        for (String string : strings) {
            System.out.println(string);
        }
    }


    public List<String> countSubstrings(String s) {
        if(s == null) return null;
        List<String> res = new LinkedList<>();

        countSubstringsHelper(res, "", s, 0);

        return res;

    }

    public void countSubstringsHelper(List<String> res, String re, String s, int x) {
            res.add(re);

            for (int j = x; j < s.length(); j++) {

                re = re + s.charAt(j);

                countSubstringsHelper(res, re, s, x + 1);

                if (re.length() > 0) re = re.substring(0, re.length() - 1);
            }
    }
    /**
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();

        generateParenthesisHelper(res, "", n, 0, 0);

        return res;


    }

    public void generateParenthesisHelper(List<String> res, String re, int n, int open, int close) {

        if(re.length() == 2*n) {
            res.add(re);
            return;
        } else {

            if(open < n) {
                generateParenthesisHelper(res, re+"(", n, open+1, close);
            }

            if(close < open){
                generateParenthesisHelper(res, re+")", n, open, close+1);
            }

        }

    }

    /**
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> re = new LinkedList<>();

        boolean[] used = new boolean[nums.length];


        permuteHelper(res, re, nums, used);

        return res;

    }

    public void permuteHelper(List<List<Integer>> res, List<Integer> re, int[] nums, boolean[] used) {

        if(re.size() == nums.length) {
            res.add(new ArrayList<>(re));
            return;
        } else {

            for (int i = 0; i < nums.length; i++) {


                if(used[i] == true || (i>0 && nums[i] == nums[i-1] && !used[i-1])) continue;

                re.add(nums[i]);
                used[i] = true;

                permuteHelper(res, re, nums, used);

                re.remove(re.size()-1);
                used[i] = false;

            }

        }

    }

    /**
     * ====================================Combination Sum III================================
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> re = new LinkedList<>();


        combinationSum3Helper(res, re, k, n,1);

        return res;

    }

    public void combinationSum3Helper(List<List<Integer>> res, List<Integer> re, int k, int target, int start) {

        if(re.size()==k && target==0) {
            res.add(new ArrayList<>(re));
            return;
        } else if(target < 0) {
            return;
        } else {

            for (int i = start; i < 10; i++) {

                re.add(i);
                combinationSum3Helper(res, re,  k,target-i, i+1);

                re.remove(re.size() - 1);

            }

        }

    }

    /**
     * ====================================Subsets================================
     * @param nums
     * @return
     * Input: nums = [1,2,3]
     * Output:
     * [
     *   [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     */
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> re = new LinkedList<>();


        subsetsHelper(res, re, nums, 0);

        return res;


    }

    public void subsetsHelper(List<List<Integer>> res, List<Integer> re, int[] nums, int start) {

        res.add(new LinkedList<>(re));

        for (int i = start; i < nums.length; i++) {

            if(i>start && nums[i] == nums[i-1]) {continue;}

            re.add(nums[i]);
            subsetsHelper(res, re, nums, i+1);

            re.remove(re.size() - 1);

        }

    }



    /**
     * ====================================Combinations================================
     * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
     * @param n
     * @param k
     * @return
     * Input: n = 4, k = 2
     * Output:
     * [
     *   [2,4],
     *   [3,4],
     *   [2,3],
     *   [1,2],
     *   [1,3],
     *   [1,4],
     * ]
     */
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> re = new LinkedList<>();

        if(k>n) return res;

        combineHelper(res, re, 1, k, n);

        return res;

    }

    public void combineHelper(List<List<Integer>> res, List<Integer> re, int start, int k, int n) {

        if(re.size() == k) {
            res.add(new LinkedList<>(re));
            return;
        } else {

            for (int i = start; i <= n; i++) {
                re.add(i);
                combineHelper(res, re, i+1, k, n);

                re.remove(re.size()-1);
            }
        }

    }

    /**
     * ====================================Combination Sum================================
     * @param candidates
     * @param target
     * @return
     * candidates = [2,3,6,7], target = 7,
     * [
     *   [7],
     *   [2,2,3]
     * ]
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        LinkedList<Integer> re = new LinkedList<>();
        Arrays.sort(candidates);

        combinationSumHelper(candidates, 0, target, ans, re);

        return ans;
    }

    public void combinationSumHelper(int[] candidates, int start, int target, List<List<Integer>> res, List<Integer> re) {

        if(target == 0) {
            res.add(new LinkedList<>(re));
            return;
        } else if(target < 0) {
            return;
        } else {

            for (int i = start; i < candidates.length; i++) {

                if(i>start && candidates[i]==candidates[i-1]) {
                    continue;
                }

                re.add(candidates[i]);

                combinationSumHelper(candidates, i+1, target-candidates[i], res, re);

                re.remove(re.size()-1);

            }

        }

    }

    /**
     * ====================================Letter Combinations================================
     * input(combinations, remaining, res)
     * @return
     */
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


}
