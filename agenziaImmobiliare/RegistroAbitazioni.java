package objOrientProgr.agenziaImmobiliare;

import java.util.List;
import java.util.Vector;
import java.util.stream.Stream;

public class RegistroAbitazioni implements Registro{
    List<Abitazione> abitazioni;

    /**
     * costruttore che aggiunge una singola abitazione
     * @param theAbitazione abitazione da aggiungere
     */
    public RegistroAbitazioni(Abitazione theAbitazione){
        List<Abitazione> abitazioni = new Vector<Abitazione>();
        ((Vector<Abitazione>) abitazioni).addElement(theAbitazione);
    }

    /**
     * costruttore che aggiunge una lista di abitazioni
     * @param theAbitazioni abitazioni da aggiungere
     */
    public RegistroAbitazioni(List<Abitazione> theAbitazioni){

    }

    /**
     * copy constructor
     * @param riv registro di immobili da copiare all'interno
     */
    public RegistroAbitazioni(RegistroAbitazioni riv){

    }

    /**
     * estraiStreamAbitazione
     * @return la stream delle abitazioni disponibili
     */
    public Stream<Abitazione> estraiStreamAbitazione (){
        return abitazioni.stream();
    }
}
