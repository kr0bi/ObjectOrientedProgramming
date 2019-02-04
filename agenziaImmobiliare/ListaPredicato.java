package objOrientProgr.agenziaImmobiliare;

import objOrientProgr.agenziaImmobiliare.Interface.Abitazione;

import java.util.List;
import java.util.Vector;
import java.util.function.Predicate;

public class ListaPredicato {
    List<Predicate<Abitazione>> listaPredicati;

    public ListaPredicato (Predicate<Abitazione> predicato){
        List<Predicate<Abitazione>> result = new Vector<Predicate<Abitazione>>();
        ((Vector<Predicate<Abitazione>>) result).addElement(predicato);
        listaPredicati = result;
    }

}
