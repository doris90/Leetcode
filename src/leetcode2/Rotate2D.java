package leetcode2;

public class Rotate2D {

    public void rotate(int[][] matrix) {

    }

    public static void main(String[] args) {
        int[][] in = {{1,2,3},{4,5,6},{7,8,9}};

        int[][] symetry = symetry(in);

        System.out.println(symetry);
    }
    public static int[][] symetry(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i <= n/2; i++) {

            for (int j = i+1; j < n; j++) {

                if(i != j) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }

            }
            
        }

        return matrix;

    }

}
