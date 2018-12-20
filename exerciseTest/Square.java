package objOrientProgr.exerciseTest;

public class Square extends Rect{
    public void setBase(int b){
        super.setBase(b);
        this.height = b;
    }
    public void setHeight(int h){
        super.setHeight(h);
        this.base = h;
    }

    private static void fillAndPrint(Rect r1, int b, int h){
        System.out.format("b=%d h=%d ;", b, h);
        r1.setBase(b);
        r1.setHeight(h);
        System.out.println(r1);
    }

    public static void main(String[] args) {
        Rect r1 = new Rect();
        Rect r2 = new Square();
        Square s1 = new Square();

        fillAndPrint(r1,4,5);
        fillAndPrint(s1,10,10);
        fillAndPrint(r2,5,4);
        fillAndPrint(s1,4,5);

    }
}
