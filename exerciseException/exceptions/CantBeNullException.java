package objOrientProgr.exerciseException.exceptions;

public class CantBeNullException  extends Exception {
    public CantBeNullException (){
    }
    public CantBeNullException (String s){
        super(s);
    }
}
