package objOrientProgr.exerciseMatrix;

public class Utilities {
    public static void viewMatrices(float[][] arr1) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                System.out.format("%10.1f", arr1[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
