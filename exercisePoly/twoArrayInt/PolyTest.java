package objOrientProgr.exercisePoly.twoArrayInt;

import objOrientProgr.exercisePoly.twoArrayInt.exceptions.degreeNotFoundException;
import objOrientProgr.exercisePoly.twoArrayInt.exceptions.negativeExpException;

public class PolyTest {
    public static void main(String[] args) throws negativeExpException, degreeNotFoundException {
        Poly thePoly = new Poly(5,0);
        thePoly.viewPoly();
        thePoly = thePoly.sum(1,2);

        thePoly = thePoly.sum(3,2);
        thePoly.viewPoly();
        thePoly = thePoly.sum(3,2);
        thePoly.viewPoly();

        Poly thePoly2 = new Poly(-1,3);
        thePoly = thePoly.add(thePoly2);
        thePoly.viewPoly();
        thePoly2 = thePoly2.sum(1,2);
        thePoly2.viewPoly();
        thePoly  = thePoly.add(thePoly2);
        thePoly.viewPoly();
        thePoly  = thePoly.add(thePoly);
        thePoly.viewPoly();

        Poly thePoly3 = new Poly();
        thePoly = thePoly.add(thePoly3);
        thePoly.viewPoly();
        thePoly = thePoly.add(thePoly3);
        thePoly.viewPoly();

        Poly thePoly4 = new Poly(12,1);
        thePoly4.viewPoly();
        thePoly = thePoly.add(thePoly4);
        thePoly.viewPoly();

        Poly thePoly5 = new Poly(5,0);
        thePoly5 = thePoly5.sum(1,1);
        thePoly5 = thePoly5.sum(3,2);
        thePoly5.viewPoly();

        Poly thePoly6 = new Poly(2,1);
        thePoly6 = thePoly6.sum(1,0);
        thePoly6.viewPoly();

        thePoly5 = thePoly5.multiply(thePoly6);
        thePoly5.viewPoly();

        Poly thePoly7 = new Poly(3,2);
        thePoly7 = thePoly7.sum(1,1);
        thePoly7 = thePoly7.sum(5,0);

        Poly thePoly8 = new Poly(4,2);
        thePoly8 = thePoly8.sum(0,0);
        thePoly8.viewPoly();

        thePoly7 = thePoly7.multiply(thePoly8);
        thePoly7.viewPoly();

        Poly thePoly9 = new Poly(3,2);
        thePoly9 = thePoly9.sum(1,1);
        thePoly9 = thePoly9.sum(5,0);

        Poly thePoly10 = new Poly(0,0);
        thePoly10.viewPoly();

        thePoly9 = thePoly9.multiply(thePoly10);
        thePoly9.viewPoly();

        thePoly.viewPoly();
        System.out.println(thePoly.degree());
        System.out.println(thePoly.coeff(1));
        thePoly2.viewPoly();
        System.out.println(thePoly2.degree());
        System.out.println(thePoly2.coeff(2));
        thePoly3.viewPoly();
        System.out.println(thePoly3.degree());
        System.out.println(thePoly3.coeff(0));
        thePoly4.viewPoly();
        System.out.println(thePoly4.degree());
        System.out.println(thePoly4.coeff(1));
        thePoly5.viewPoly();
        System.out.println(thePoly5.degree());
        System.out.println(thePoly5.coeff(2));
        thePoly6.viewPoly();
        System.out.println(thePoly6.degree());
        System.out.println(thePoly6.coeff(1));
        thePoly7.viewPoly();
        System.out.println(thePoly7.degree());
        System.out.println(thePoly7.coeff(2));
        thePoly7 = thePoly7.add(thePoly7.minus());
        thePoly7.viewPoly();
        thePoly8.viewPoly();
        System.out.println(thePoly8.degree());
        System.out.println(thePoly8.coeff(2));
        thePoly9.viewPoly();
        System.out.println(thePoly9.degree());
        System.out.println(thePoly9.coeff(0));
        thePoly10.viewPoly();
        System.out.println(thePoly10.degree());
        System.out.println(thePoly10.coeff(0));

        Poly polyEquals1 = new Poly (3,1);
        Poly polyEquals2 = new Poly (2,1);
        Poly polyEquals3 = polyEquals1.minus();
        polyEquals1.viewPoly();
        polyEquals2.viewPoly();
        polyEquals3.viewPoly();
        Poly polyEquals4 = polyEquals1.add(polyEquals3);
        polyEquals4.viewPoly();
        System.out.println(polyEquals4.degree());

        System.out.println(polyEquals1.equals(polyEquals2));
        System.out.println(polyEquals1.equals(polyEquals3));

        Poly p1 = new Poly(1,1);
        p1.viewPoly();
        Poly p2 = new Poly(1,2);
        p1.add(p2);
        Poly p3 = p1.add(p2);
        p1.viewPoly();
        p3.viewPoly();

    }
}
