package objOrientProgr.agenziaImmobiliare;

import java.util.Date;

public interface Abitazione {
    public boolean rangePrezzo(double min, double max);
    public boolean tipoCaldaia(KindOfCaldaia tipoCaldaia);
    public boolean rangeEtaAbitazione(Date min, Date max);
    public Double calculatePrice();
}
