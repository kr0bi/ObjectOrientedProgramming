package objOrientProgr.exerciseException.exception;

public class CantBeNullException  extends Exception {
    public CantBeNullException (){
    }
    public CantBeNullException (String s){
        super(s);
    }
}
