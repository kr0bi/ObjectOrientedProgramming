package objOrientProgr.testClasses;

public class Test {
    public static void main(String[] args) {
        long ciao = 1000;
        Contatore theContatore = new Contatore();
        Contatore2 theCoonnt = new Contatore2();

        System.out.println(theContatore.count(1));
        try {
            System.out.println(theCoonnt.count(ciao));
        } catch (Exception e){
            System.out.println("ciao");
        }
    }
}
