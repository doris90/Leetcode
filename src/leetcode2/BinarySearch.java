package leetcode2;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {30,11,23,4,20};

        BinarySearch bs = new BinarySearch();
        int out1 = bs.minEatingSpeed(a, 6);

        System.out.println(out1);

    }

    public int minEatingSpeed(int[] piles, int H) {

        int l = 1;
        int r = getMax(piles);

        while (l <= r) {
            int mid = (r + l) / 2;

            if(eatAllUsing(piles, mid) <= H) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;

    }

    private int eatAllUsing(int[] piles, int amount) {
        int time = 0;

        for (int i = 0; i < piles.length; i++) {
            time += piles[i]/amount;

            if(piles[i]%amount != 0) time = time + 1;

        }
        return time;
    }

    private int getMax(int[] piles) {
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }

        return max;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int l = 0;
        int r = m*n-1;

        while(l <= r) {

            int mid = (l+r)/2;

            if(matrix[mid/m][mid%m] == target) {
                return true;
            }

            if(matrix[mid/m][mid%m] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;


    }

    public int mySqrt(int x) {

        if(x == 0) return 0;

        int left = 1;
        int right = x;

        while(left <= right) {
            int mid = left + (right - left)/2;

            if(mid == x/mid) return mid;

            if(mid > x/mid) {
                if((mid-1) <= x/(mid-1)) {
                    return mid-1;
                }

                right = mid -1;
            } else {
                left = mid + 1;
            }
        }

        return -1;

    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];

        if(nums.length == 0) {
            Arrays.fill(res, -1);

            return res;
        }

        int idx = searchRangeHelper(nums, target, 0, nums.length);

        if(idx == -1) {
            res[0] = -1;
            res[1] = -1;

            return res;
        }

        int lo = idx;
        int hi = idx;

        while(lo > 0) {
            if(nums[lo-1] != nums[idx]) {
                break;
            } else {
                lo--;
            }
        }

        while(hi < nums.length-1) {
            if(nums[hi+1] != nums[idx]) {
                break;
            } else {
                hi++;
            }
        }

        res[0] = lo;
        res[1] = hi;

        return res;
    }

    public int searchRangeHelper(int[] nums, int target, int lo, int hi) {
        if(hi < lo) return -1;

        int mid = lo + (hi-lo)/2;

        if(mid < 0 || mid > nums.length-1) return -1;

        if (nums[mid] < target) {
            return searchRangeHelper(nums, target, mid+1, hi);
        } else if(nums[mid] > target) {
            return searchRangeHelper(nums, target, lo, mid-1);
        } else {
            return mid;
        }

    }

    public int search(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length - 1;

        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;

            if(nums[mid] == target) return mid;
            //left sorted
            if(nums[mid] >= nums[lo]) {

                if(nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }

            } else {

                if(nums[hi] >= target && target > nums[mid]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }

            }
        }

        return -1;

    }
}
