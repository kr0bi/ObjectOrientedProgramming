package objOrientProgr.exerciseMatrix;

import objOrientProgr.exerciseMatrix.exception.*;

import java.util.Vector;

public class MatricesTest {
    public static void test() throws dimensionsException,
            columnsIndexOutOfBoundsException, incompatibleSumMatrixException,
            incompatibleInsertMatrixException, incompatibleMultiplyMatrixException{
        Matrix theMatrix = new Matrix(3, 10);
        theMatrix.viewMatrix();
        Matrix theSecondMatrix = new Matrix(4, 4, new int[]{1, 2, 3, 4});
        Matrix theThirdMatrix = new Matrix(1, 1, new int[]{1});
        theSecondMatrix.viewMatrix();
        //Matrix theFourthMatrix = new Matrix(-1, 0);


        theMatrix.insert(0, 0, 10);
        theMatrix.insert(0, 0, 12);
        theMatrix.insert(1, 0, 10);
        theMatrix.insert(2, 0, 10);
        theMatrix.insert(0, 2, 2);

        theMatrix.viewMatrix();
        theSecondMatrix.transpose();
        theSecondMatrix.viewMatrix();
        theSecondMatrix.multiply(theSecondMatrix);
        theSecondMatrix.viewMatrix();

        theSecondMatrix.add(theSecondMatrix);

        theSecondMatrix.viewMatrix();
        theSecondMatrix.scalarProduct(1);
        theSecondMatrix.viewMatrix();
        for (int i = 0; i < theSecondMatrix.getRighe(); i++) {
            Vector<Integer> v = theSecondMatrix.extractVector(Matrix.Spaces.ROW, i);
            System.out.println(v.toString());
        }
        System.out.println();
        for (int i = 0; i < theSecondMatrix.getColonne(); i++) {
            Vector<Integer> v = theSecondMatrix.extractVector(Matrix.Spaces.COLUMN, i);
            System.out.println(v.toString());
        }
        System.out.println();
        for (int i = 0; i < theThirdMatrix.getRighe(); i++) {
            Vector<Integer> v = theThirdMatrix.extractVector(Matrix.Spaces.ROW, i);
            System.out.println(v.toString());
        }
    }
    public static void main(String[] args)  throws dimensionsException,
            columnsIndexOutOfBoundsException, incompatibleSumMatrixException,
            incompatibleInsertMatrixException, incompatibleMultiplyMatrixException{
        test();

    }
}
