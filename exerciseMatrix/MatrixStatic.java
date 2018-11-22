package objOrientProgr.exerciseMatrix;

import static objOrientProgr.exerciseMatrix.Utilities.viewMatrices;

public class MatrixStatic {
    /**
     * The mission of this class is to provide a number of * standalone procedures that can be useful for manipulating * n x m matrices of floats.
     **/
    public static void main(String args[]) {
        float[][] arr1 = {{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4,4,4,4}};
        float[][] arr2 = {{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4,4,4,4}};

        float[][] res = transpose(arr1);
        float[][] res2 = multiply(arr1, arr2);
        viewMatrices(res2);
    }

    /**
     * compute the transpose matrix of m: result[i,j]=m[j,i]
     */
    public static float[][] transpose(float[][] m) {
        float[][] result = doTranspose(m);
        return result;
    }

    private static float[][] doTranspose(float[][] m) {
        float[][] result = new float[m[0].length][m.length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = m[j][i];
            }
        }
        return result;
    }

    /**
     * compute matrix multiplication of m1 with m2: result[i,j] = sum_over_h(m1[i,h]*m2[h,j])
     */
    public static float[][] multiply(float[][] m1, float[][] m2) {
        float[][] m3 = new float[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                float sumOverH = 0;
                for (int h = 0; h < m2.length; h++) {
                    sumOverH = sumOverH + m1[i][h] * m2[h][j];
                }
                m3[i][j] = sumOverH;
            }
        }
        return m3;
    }



}
