package leetcode2;

import common.Point;

import java.util.*;

public class DP {


    public static void main(String[] args) {

        DP dp = new DP();
        int[][] ins = {{1,3,1},{1,5,1},{4,2,1}};

        int i = dp.minPathSum(ins);

        System.out.println(i);
    }


    public int minPathSum(int[][] grid) {

        int[][] res = new int[grid.length][grid[0].length];

        int i = minPathSum(res, grid, grid.length - 1, grid[0].length - 1);
        return i;

    }

    public int minPathSum(int[][] res, int[][] grid, int i, int j) {

        if(i < 0 || j < 0) return 0;

        if(res[i][j] > 0) return res[i][j];

        if(i==0 && j==0) return grid[i][j];

        if(i==0 && j > 0) {
            res[i][j] += grid[i][j] + minPathSum(res, grid, i, j-1);
        } else if(j==0 && i > 0) {
            res[i][j] += grid[i][j] + minPathSum(res, grid, i-1, j);
        } else {
            res[i][j] += grid[i][j] + Math.min(minPathSum(res, grid, i, j-1), minPathSum(res, grid, i-1, j));
        }


        return res[i][j];

    }



    public static int minimumDeleteSumNonRecursive(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        int[][] dp = new int[l1+1][l2+1];

        for (int i = 1; i < l1; i++) {

            for (int j = 1; j < l2; j++) {

                if(s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]);
                }

            }
        }

        return dp[l1][l2];
    }

    public static int minimumDeleteSumRecursive(String s1, String s2) {

        return minimumDeleteSumRecursive(s1, s2, s1.length()-1, s2.length()-1);
    }

    public static int minimumDeleteSumRecursive(String s1, String s2, int i, int j) {

        if(i<0 && j>=0) {
            char[] chars = s2.substring(0, j + 1).toCharArray();
            int sum=0;
            for (int c : chars) {
                sum = sum + c;
            }
            return sum;
        } else if(i>=0 && j<0) {
            char[] chars = s1.substring(0, i + 1).toCharArray();
            int sum=0;
            for (int c : chars) {
                sum = sum + c;
            }
            return sum;
        } else if(i<0 && j<0) {
            return 0;
        }

        if(s1.charAt(i) == s2.charAt(j)) {
            return minimumDeleteSumRecursive(s1, s2, i-1, j-1);
        } else {
            return Math.min(minimumDeleteSumRecursive(s1, s2, i, j-1)+s2.charAt(j), minimumDeleteSumRecursive(s1, s2, i-1, j)+s1.charAt(i));
        }

    }



    /**
     * ============================================最长公共子序列个数==============================================================================
     * @param text1
     * @param text2
     * @return
     */

    public static int lcsRecusive(String text1, String text2, int i, int j) {
        int m = text1.length();
        int n = text2.length();

        if(i > m-1 || j>n-1) return 0;

        if(text1.charAt(i) == text2.charAt(j)) {
            return 1 + lcsRecusive(text1, text2, i+1, j+1);
        } else {
            return Math.max(lcsRecusive(text1, text2, i, j+1), lcsRecusive(text1, text2, i+1, j));
        }

    }

    public static int lcsNonRecursive(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }

            }

        }


        for (int i = 0; i <= n; i++) {

            for (int j = 0; j <= m; j++) {
                System.out.print(dp[j][i]);
            }

            System.out.println();
        }

        return dp[m][n];

    }


    /**
     * ============================================机器人走方格==============================================================================
     * https://leetcode.com/problems/unique-paths-ii/solution/
     * @param obstacleGrid
     * @return
     */
    private static int getPathsWithObs2(int[][] obstacleGrid) {
        System.out.println(new Date());

        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;

        if(obstacleGrid[0][0] == 1) return 0;

        //基准一定要set啊
        obstacleGrid[0][0] = 1;

        for (int i = 1; i < c; i++) {

            if(obstacleGrid[0][i] == 1) {
                obstacleGrid[0][i] = 0;
            } else {
                obstacleGrid[0][i] = obstacleGrid[0][i-1];
            }
        }

        for (int j = 1; j < r; j++) {

            if(obstacleGrid[j][0] == 1) {
                obstacleGrid[j][0] = 0;
            } else {
                obstacleGrid[j][0] = obstacleGrid[j-1][0];
            }
        }

        for (int i = 1; i < c; i++) {
            for (int j = 1; j < r; j++) {

                if(obstacleGrid[j][i] == 1) {
                    obstacleGrid[j][i] = 0;
                } else {
                    obstacleGrid[j][i] = obstacleGrid[j][i-1] + obstacleGrid[j-1][i];
                }
            }

        }
        System.out.println(new Date());
        return obstacleGrid[r-1][c-1];

    }

    /**
     * 递归+散列表 -》 效率太差
     * @param r
     * @param c
     * @param cash
     * @param obstacleGrid
     * @return
     */
    private static int getPathsWithObs(int r, int c, int[][] cash, int[][] obstacleGrid) {

        if(r<=0 || c<=0) return 0;
        if(obstacleGrid[r-1][c-1] == 1) return 0;

        if(r==1 && c==1 && obstacleGrid[0][0] != 1) return 1;


        int res = 0;
        if(cash[r][c-1] != -1 && cash[r-1][c] != -1) {
            return cash[r][c-1] +  cash[r-1][c];
        } else if(cash[r][c-1] == -1 && cash[r-1][c] != -1) {
            res = getPathsWithObs(r, c-1, cash, obstacleGrid);
            cash[r][c-1] = res;
            return res + cash[r-1][c];
        } else if(cash[r][c-1] != -1 && cash[r-1][c] == -1) {
            res = getPathsWithObs(r-1, c, cash, obstacleGrid);
            cash[r-1][c] = res;
            return res + cash[r][c-1];
        } else {
            return getPathsWithObs(r, c-1, cash, obstacleGrid) + getPathsWithObs(r-1, c, cash, obstacleGrid);
        }

    }

    /**
     * @param c column count
     * @param r row count
     * @return
     */

    public static int uniquePaths(int m, int n) {
        HashMap<Point, Integer> cash = new HashMap<>();
        return getPaths(n, m, cash);
    }

    /**
     *============================================机器人走方格==============================================================================
     * @param r
     * @param c
     * @param cash
     * @return
     */
    private static int getPaths(int r, int c, HashMap<Point, Integer> cash) {
        if(r==0 || c==0) return 0;
        if(r==1 && c==1) return 1;
        Point point = new Point(r, c);

        if(cash.containsKey(point)) return cash.get(point);
        else {
            int res = getPaths(r , c-1, cash) + getPaths(r-1, c, cash);
            cash.put(point, res);
            return res;
        }

    }


    /**
     *============================================找所有矩阵中所有的子方阵==============================================================================
     * 遍历每一个点，如果是1，那就枚举以该点为正方形左上角的所有正方形边长，判断这个这个边长的正方形内是不是全为1。
     *
     * 极限情况，如果刚好给的正方形是全1的话，那么复杂度会是O(N*M*min(N,M)*min(N,M))，这样子的话，分析复杂度应该会超时才对，但是最后提交时，居然没有超时。
     *
     * 所以应该是测试数据没有考虑极限情况。
     * ————————————————
     * 版权声明：本文为CSDN博主「Mikchy」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/Mikchy/article/details/103394348
     *
     * 解法2： DP https://blog.csdn.net/Mikchy/article/details/103394348#AC%E4%BB%A3%E7%A0%81%EF%BC%88C%2B%2B%EF%BC%89
     * @param matrix
     * @return
     */
    public static int countSquares(int[][] matrix) {

        int r = matrix.length;
        int c = matrix[0].length;
        int count = 0;

        for (int i = 0; i < r ; i++) {
            for (int j = 0; j < c; j++) {

                if(matrix[i][j] == 1) {
                    count++;

                    for (int k = 2; k <= Math.min(r-i,c-j); k++) {

                        if(isSquare(matrix, i, j, k)) {
                            count++;
                        }
                    }

                }

            }
        }

        return count;

    }

    private static boolean isSquare(int[][] matrix, int i, int j, int k) {

        for (int l = 0; l < k ; l++) {
            for (int m = 0; m < k; m++) {
                if(matrix[i+l][j+m] == 0) return false;
            }

        }

        return true;

    }

    /**
     *============================================找数组中子集和最大的和==============================================================================
     * 子问题dp[i]是以i为重点的子集的sum最大的值，max(dp[i-1], dp[i-1] + nums[i])
     * i 从1 开始
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        if(nums == null) return -1;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
        }

        for (int i = 0; i < dp.length; i++) {
            if(dp[i] > maxSum) maxSum = dp[i];
        }

        return maxSum;
    }

    /**
     *
     * @param num
     * @return
     */
//    public int[] countBits(int num) {
//
//    }


}
