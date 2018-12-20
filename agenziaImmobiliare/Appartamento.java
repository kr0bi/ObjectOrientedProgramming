package objOrientProgr.agenziaImmobiliare;

import java.util.Date;

public class Appartamento implements Abitazione{
    public boolean rangePrezzo(double min, double max){
        return true;
    }
    public boolean tipoCaldaia(KindOfCaldaia tipoCaldaia){
        return true;
    }
    public boolean rangeEtaAbitazione(Date min, Date max){
        return true;
    }
    public Double calculatePrice(){
        return 0.0;
    }
}
