package objOrientProgr.agenziaImmobiliare.Implementazioni;

import objOrientProgr.agenziaImmobiliare.Interface.Abitazione;
import objOrientProgr.agenziaImmobiliare.Interface.Filtro;
import objOrientProgr.agenziaImmobiliare.RegistroAbitazioni;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FiltroImplementazione implements Filtro {

    List<Predicate<Abitazione>> listaPredicati;
    public FiltroImplementazione(){
        listaPredicati = null;
    }
    //todo creare un costruttore per copiare i registri
    public FiltroImplementazione(List<Predicate<Abitazione>> listaP){
        listaPredicati = listaP;
    }

    /**
     * aggiungi un predicato alla lista dei predicati esistenti
     * @param predicato predicato da aggiungere
     * @return il filtro con il predicato aggiunto
     */
    public void addPredicato(Predicate<Abitazione> predicato){
        List<Predicate<Abitazione>> list = new Vector<Predicate<Abitazione>>();
        ((Vector<Predicate<Abitazione>>) list).addElement(predicato);
        listaPredicati = list;
    }

    /**
     * setRegistroFiltrato: agisce sul registro abitazioni e lo filtra;
     * @return
     */
    public List<Abitazione> setRegistroFiltrato (RegistroAbitazioni reg){
        Iterator<Predicate<Abitazione>> it = listaPredicati.iterator();
        List<Abitazione> result = reg.ottieniRegistroAbitazioni();
        while (it.hasNext()){
            result = result.stream().filter(it.next()).collect(Collectors.toList());
        }
        return result;
    }
}
