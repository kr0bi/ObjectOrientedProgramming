package objOrientProgr.exerciseLambda;

import java.util.function.BiFunction;

// Java program to demonstrate working of lambda expressions
public class Test
{
    private int H (int a, int b, BiFunction<Integer, Integer, Integer> f, BiFunction<Integer, Integer, Integer> g){
        if (b == 0){
            return f.apply(a,b);
        } else {
            return g.apply(a, H(a,b-1, f,g));
        }
    }

    private BiFunction<Integer, Integer, >

    private BiFunction<Integer, Integer, Integer> increment (){
        return (x,y)->y+1;
    }

    private BiFunction<BiFunction<Integer, Integer, Integer>, Integer, Integer> add (){

    }

    public static void main(String args[]) {
        Test tobj = new Test();
        tobj.increment().apply(0,1);

        BiFunction<Integer, Integer, Integer> meme = (x,y) -> x;

        BiFunction<Integer, Integer, BiFunction<Integer, Integer, Integer>> addition = (x,y) -> increment;

        int add = tobj.H(2,10,meme, increment);


        System.out.println("Addition is " + tobj.H(2,10,meme, increment));
        //System.out.println("Multiply is " + tobj.H(2,10, meme2, addition));

        /*System.out.println("Multiplication is " +
                tobj.operate(6, 3, multiply));*/
        //FuncInter1 multiply = (int x, int y) -> x * y;
    }
    /**
     * (define s2 (lambda (u v) (+ v 1)))
     * (define H
     *  (lambda (f g)   ;procedure da numero -> numero
     *      (lambda (a b) ;val: numeri interi
     *          (if (= b 0)
     *              (f a)
     *              (g a ((H f g) a (- b 1))))
     )))
     (define add (H (lambda (x) x) s2))
     (define mul (H (lambda (x) 0) add))
     (define pow (H (lambda (x) 1) mul))
     */
}