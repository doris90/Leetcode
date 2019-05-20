package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {

        int s = 0;
        int res = 0;

        for (int i = 0; i < height.length; i++) {

            for (int j = height.length-1; j >=0 ; j--) {

                if(j>i) {
                    s = (j-i)*Math.min(height[i], height[j]);
                    res = Math.max(res,s);

                }else {
                    break;
                }

            }

        }

        return res;

    }

    public static void main(String[] args) {
        int[] a = new int[]{1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(a));
    }
}
