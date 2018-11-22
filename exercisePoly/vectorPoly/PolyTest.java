package objOrientProgr.exercisePoly.vectorPoly;

import objOrientProgr.exercisePoly.vectorPoly.exceptions.NegativeExponentException;
import objOrientProgr.exercisePoly.vectorPoly.exceptions.degreeNotFoundException;

public class PolyTest {
    public static void main(String[] args) throws NegativeExponentException, degreeNotFoundException {
        Poly thePoly = new Poly();
        thePoly.viewPoly();
        Poly thePoly2 = new Poly(thePoly);
        thePoly2.viewPoly();

        Poly thePoly3 = new Poly(1,1);
        thePoly3.viewPoly();

        Poly thePoly4 = new Poly(10,2);
        thePoly4.viewPoly();

        Poly thePoly5 = new Poly(4,6);
        thePoly5.viewPoly();

        Poly thePoly6 = thePoly5.add(thePoly4);
        thePoly6.viewPoly();
        System.out.println(thePoly6.coefficient(thePoly6.degree()));
        thePoly6.minus().viewPoly();
        thePoly6.differentiate().viewPoly();

        Poly thePoly7 = new Poly(2,2);
        thePoly7.viewPoly();
        thePoly3 = thePoly3.add(thePoly3.minus()).add(thePoly7);
        thePoly3.viewPoly();

        System.out.println(thePoly7.equals(thePoly3));
        System.out.println(thePoly7.equals(thePoly4));
        System.out.println(thePoly7.equals(thePoly));

        thePoly2.multiply(thePoly3).viewPoly();
        thePoly3.multiply(thePoly2).viewPoly();
        System.out.println("------------");
        thePoly4.viewPoly();
        thePoly3.viewPoly();
        System.out.println("------------");
        thePoly4.multiply(thePoly3).viewPoly();
        System.out.println("------------");
        thePoly5.viewPoly();
        thePoly4.viewPoly();
        System.out.println("------------");
        thePoly5 = thePoly5.multiply(thePoly4);
        thePoly5.viewPoly();
        thePoly5 = thePoly5.add(new Poly(5,2));
        thePoly5.viewPoly();

        Poly ciao = new Poly(5, 3);
        ciao.viewPoly();

    }
}
