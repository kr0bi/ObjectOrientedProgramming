package objOrientProgr.agenziaImmobiliare;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class Agenzia {
    RegistroAbitazioni regAbitazioni;
    /**
     * calculateAveragePrice: calcola il prezzo medio di una lista di abitazioni in cui viene eseguito il filtro f
     * @param f filtro per la lista di abitazioni
     * @return prezzo medio della lista di abitazioni filtrate
     */
    public double calculateAveragePrice(Filtro f){
        Stream<Abitazione> stream = regAbitazioni.estraiStreamAbitazione();
        Stream<Abitazione> stream2 = stream.filter(f.test());
        return stream2.mapToDouble(i->i.calculatePrice()).average().getAsDouble();
    }

    /**
     * findAbitazione: individua le abitazioni che rispettano il filtro f
     * @param f filtro per la lista di abitazioni
     * @return la lista di abitazioni filtrate
     */
    public List<Abitazione> findAbitazione(FiltroImplementazione f){
        return null;
    }

    /**
     prenotaVisita: prenota una visita per una certa abitazione, in una certa data per un certo cliente
     * @param theAbitazione abitazione in cui effettuare la prenotazione
     * @param dataVisita data in cui effettuare la prenotazione per la visita
     * @param ilCliente cliente che viene prenotato
     * @return "Prenotazione effettuata con successo!"
     * @throws PrenotazioneFallitaException se la prenotazione non e' andata a buon fine tira un'eccezione
     */
    public String prenotaVisita(Abitazione theAbitazione, Date dataVisita, Cliente ilCliente) throws PrenotazioneFallitaException{
        if (checkPrenotabilita(theAbitazione, dataVisita)){
            return "Prenotazione effettuata con successo!";
        } else {
            throw new PrenotazioneFallitaException("Prenotazione FALLITA!");
        }
    }

    /**
     * checkPrenotabilita' verifica se l'abitazione e' disponibile per quella data
     * @param theAbitazione abitazione da verificare
     * @param dataVisita data da verificare
     * @return TRUE se e' prenotabile, FALSE se non lo e'
     */
    private boolean checkPrenotabilita(Abitazione theAbitazione, Date dataVisita){
        return true;
    }

    /**
     * creaAbitazione: inserisce una nuova abitazione all'interno della lista di abitazioni affittabili
     */
    public void creaAbitazione(){
    }
}
