package objOrientProgr.exerciseMatrix;

import objOrientProgr.exerciseMatrix.exceptions.*;

import java.util.Vector;

public class MatrixTest {
    public static void test() throws DimensionsException,
            ColumnsIndexOutOfBoundsException, IncompatibleSumMatrixException,
            IncompatibleInsertMatrixException, IncompatibleMultiplyMatrixException {
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
        Matrix prima=new Matrix(3,3);
        prima.insert(0, 0,0);
        prima.insert(0, 1,0);
        prima.insert(0, 2,1);
        prima.insert(1, 0,0);
        prima.insert(1, 1,1);
        prima.insert(1, 2,-1);
        prima.insert(2, 0,1);
        prima.insert(2, 1,-1);
        prima.insert(2, 2,0);

        Matrix seconda=new Matrix(3,3);
        seconda.insert(0, 0,0);
        seconda.insert(0, 1,2);
        seconda.insert(0, 2,1);
        seconda.insert(1, 0,1);
        seconda.insert(1, 1,-4);
        seconda.insert(1, 2,0);
        seconda.insert(2, 0,3);
        seconda.insert(2, 1,0);
        seconda.insert(2, 2,0);

        Matrix terza=new Matrix(3,3);
        terza.insert(0, 0,1);
        terza.insert(0, 1,1);
        terza.insert(0, 2,1);
        terza.insert(1, 0,1);
        terza.insert(1, 1,1);
        terza.insert(1, 2,0);
        terza.insert(2, 0,1);
        terza.insert(2, 1,0);
        terza.insert(2, 2,0);

        prima.multiply(seconda);
        prima.viewMatrix();
        prima.multiply(terza);
        prima.viewMatrix();
    }
    public static void main(String[] args)  throws DimensionsException,
            ColumnsIndexOutOfBoundsException, IncompatibleSumMatrixException,
            IncompatibleInsertMatrixException, IncompatibleMultiplyMatrixException {
        test();

    }
}
