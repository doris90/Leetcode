package nowcoder;

import java.util.ArrayList;
import java.util.List;

public class Matrix {
    public static void main(String[] args) {
        int[][] a = {{1,2,3,4}};
        ArrayList<Integer> res = printMatrix(a);

        for (Integer re : res) {
            System.out.print(re);
        }
    }

    public static ArrayList<Integer> printMatrix(int [][] matrix) {

        if (matrix == null ) return null;
        ArrayList<Integer> res = new ArrayList<>();

        int lenR = matrix.length;
        int lenC = matrix[0].length;
        int tmp = 0;

        while (lenR > 0 && lenC>0) {

            for (int i = tmp; i < lenC; i++) {
                if(!res.contains(matrix[tmp][i])) {
                    res.add(matrix[tmp][i]);
                }
            }

            for (int i = tmp+1; i < lenR; i++) {
                if(!res.contains(matrix[i][lenC - 1])) {
                    res.add(matrix[i][lenC - 1]);
                }
            }

            for (int i = lenC - 2; i >= tmp; i--) {
                if(!res.contains(matrix[lenR - 1][i])) {
                    res.add(matrix[lenR - 1][i]);
                }
            }

            for (int i = lenR - 2; i > tmp; i--) {
                if(!res.contains(matrix[i][tmp])) {
                    res.add(matrix[i][tmp]);
                }
            }

            lenR = lenR -1;
            lenC = lenC -1;
            tmp++;

        }


        return res;

    }

}
