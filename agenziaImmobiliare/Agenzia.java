package objOrientProgr.agenziaImmobiliare;

import objOrientProgr.agenziaImmobiliare.Eccezioni.PrenotazioneFallitaException;
import objOrientProgr.agenziaImmobiliare.Enum.KindOfAbitazione;
import objOrientProgr.agenziaImmobiliare.Factory.AbitazioneFactory;
import objOrientProgr.agenziaImmobiliare.Interface.Abitazione;
import objOrientProgr.agenziaImmobiliare.Interface.Filtro;

import java.util.List;

public class Agenzia {
    RegistroAbitazioni regAbitazioni;

    //todo creare in qualche maniera la possibilita' di copiare questi oggetti
    public Agenzia(RegistroAbitazioni reg){
        regAbitazioni = reg;
    }

    /**
     * calculateAveragePrice: calcola il prezzo medio di una lista di abitazioni in cui viene eseguito il filtro f
     * @param f filtro per la lista di abitazioni
     * @return prezzo medio della lista di abitazioni filtrate
     */
    public double calculateAveragePrice(Filtro f){
        return f.setRegistroFiltrato(regAbitazioni).stream().mapToDouble(i->i.getPrezzoPubblicato()).average().getAsDouble();
    }

    /**
     * findAbitazione: individua le abitazioni che rispettano il filtro f
     * @param f filtro per la lista di abitazioni
     * @return la lista di abitazioni filtrate
     */
    public List<Abitazione> findAbitazione(Filtro f){
        return f.setRegistroFiltrato(regAbitazioni);
    }

    /**
     prenotaVisita: prenota una visita per una certa abitazione, in una certa data per un certo cliente
     * @param theAbitazione abitazione in cui effettuare la prenotazione
     * @param dataVisita data in cui effettuare la prenotazione per la visita
     * @param ilCliente cliente che viene prenotato
     * @return "Prenotazione effettuata con successo!"
     * @throws PrenotazioneFallitaException se la prenotazione non e' andata a buon fine tira un'eccezione
     */
    /*public String prenotaVisita(int identificativoAbitazione, LocalDate data, int identificativoCliente )
            throws PrenotazioneFallitaException{
        if (checkPrenotabilita(identificativoAbitazione, data)){
            return "Prenotazione effettuata con successo!";
        } else {
            throw new PrenotazioneFallitaException("Prenotazione FALLITA!");
        }
    }

    *
     * checkPrenotabilita' verifica se l'abitazione e' disponibile per quella data
     * @param theAbitazione abitazione da verificare
     * @param dataVisita data da verificare
     * @return TRUE se e' prenotabile, FALSE se non lo e'
     *//*
    private boolean checkPrenotabilita(int identificativoAbitazione, LocalDate data){
        Filtro f = new FiltroImplementazione();
        f = ((FiltroImplementazione) f).addPredicato(new Predicato().isThisTheRightAbitazione(identificativoAbitazione);
        Abitazione risultato = f.setRegistroFiltrato(regAbitazioni).get(0);
        Prenotazione thePrenotazione
    }*/

    /**
     * creaAbitazione: inserisce una nuova abitazione all'interno della lista di abitazioni affittabili
     */
    public void creaAbitazione (KindOfAbitazione tipoAbitazione, CaratteristicheCasa listaCaratteristiche){
        regAbitazioni.aggiungiAbitazione(new AbitazioneFactory().createAbitazione(tipoAbitazione, listaCaratteristiche));
    }
}
