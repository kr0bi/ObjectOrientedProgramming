package objOrientProgr.agenziaImmobiliare;

import java.util.function.Predicate;

public class FiltroImplementazione implements Filtro {
    Abitazione theAbitazione;
    Predicate<Abitazione> predicate;
    public FiltroImplementazione (){
        predicate = ;
    }
    public Predicate<Abitazione> test (int min, int max){
        Predicate<Abitazione> p = (theAbitazione -> theAbitazione.rangePrezzo(min, max));
        return p;
    }
}
