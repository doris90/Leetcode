package leetcode;


import java.util.Arrays;

public class SearchInsertPosition {

    public static void main(String[] args) {

        int[] t1 = new int[] {
                1,3
        };

        int target = 3;

//        Assert.assertEquals(searchInsert(t1, target), 2);
//        Assert.assertEquals(searchInsert(t1, 2), 1);

        System.out.println(searchInsert(t1, target));
        System.out.println(searchInsert(t1, 2));
        System.out.println(searchInsert(t1, 7));
        System.out.println(searchInsert(t1, 0));



    }

    public static int searchInsert(int[] nums, int target) {

        return searchPosition(nums, 0, nums.length-1, target);
    }

    private static int searchPosition(int[] nums, int low, int hig, int target) {

        if(nums==null || nums.length==0) return -1;

        if(nums[hig] < target) return hig+1;
        if(nums[low] > target) return low;

        if(hig-low==1 && nums[low]<target && nums[hig]>target) {
            return hig;
        }
        if(hig-low==1 && nums[low]==target ) {
            return low;
        }
        if(hig-low==1 && nums[hig]==target ) {
            return hig;
        }

        int mid = (low+hig)/2;
        int res = -1;

        if(nums[mid]< target) {
            res = searchPosition(nums, mid, hig, target);
        } else if(nums[mid]> target) {
            res = searchPosition(nums, low, mid, target);
        } else {
            res = mid;
        }

        return res;

    }


}
