package objOrientProgr.agenziaImmobiliare;
import objOrientProgr.agenziaImmobiliare.Enum.*;
import objOrientProgr.agenziaImmobiliare.Factory.AbitazioneFactory;
import objOrientProgr.agenziaImmobiliare.Implementazioni.ProprietarioImplementazione;
import objOrientProgr.agenziaImmobiliare.Interface.Abitazione;
import objOrientProgr.agenziaImmobiliare.Interface.Proprietario;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * IMMUTABILE
 */

public class RegistroAbitazioni {
    List<Abitazione> registroAbitazione;

    //todo non sono sicuro vada questa cosa
    public RegistroAbitazioni(Abitazione theAbitazione){
        registroAbitazione = new Vector<Abitazione>();
        ((Vector<Abitazione>) registroAbitazione).addElement(theAbitazione);
    }

    /**
     * costruttore che aggiunge una lista di abitazioni
     * @param theAbitazioni abitazioni da aggiungere
     */
    public RegistroAbitazioni(List<Abitazione> theAbitazioni){
        Iterator<Abitazione> i = theAbitazioni.iterator();
        while (i.hasNext()){
            registroAbitazione.add(i.next());
        }
    }
    public RegistroAbitazioni (Abitazione abitazioneDaAggiungere, RegistroAbitazioni registroPrecedente){
        this.registroAbitazione = new Vector<Abitazione>();
        Iterator<Abitazione> it = registroPrecedente.registroAbitazione.iterator();
        while (it.hasNext()){
            this.registroAbitazione.add(it.next());
        }
        this.registroAbitazione.add(abitazioneDaAggiungere);

    }
    //MUTABILE
    public void aggiungiAbitazione (Abitazione theAbitazione){
        this.registroAbitazione.add(theAbitazione);
    }
    //IMMUTABILE
    /*public RegistroAbitazioni aggiungiAbitazione (Abitazione theAbitazione){
        RegistroAbitazioni ra = new RegistroAbitazioni(theAbitazione, this);
        return new RegistroAbitazioni(ra);
    }*/

    /**
     * copy constructor
     * @param riv registro di immobili da copiare all'interno
     */
    public RegistroAbitazioni(RegistroAbitazioni riv) {
        registroAbitazione = new Vector<Abitazione>();
        Iterator<Abitazione> it = riv.registroAbitazione.iterator();
        while (it.hasNext()){
            registroAbitazione.add(it.next());
        }
    }

    public List<Abitazione> ottieniRegistroAbitazioni (){
        return registroAbitazione;
    }
    private void visualizzaElenco (){
        Iterator<Abitazione> it = registroAbitazione.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    //TODO DA CANCELLARE
    public static void main(String[] args) {
        List<KindOfVani> tipiVaniPrimaCasa = InizializzazionePrimaCasaVani();
        List<KindOfVani> tipiVaniSecondaCasa = InizializzazioneSecondaCasaVani(KindOfVani.CUCINA, KindOfVani.SALONE);

        Proprietario DanieleFerroli = new ProprietarioImplementazione("Daniele Ferroli", new Vector<Abitazione>());
        Proprietario Immo = new ProprietarioImplementazione("Immo Napoli", new Vector<Abitazione>());
        CaratteristicheCasa caratteristiche = InizializzazioneCaratteristicheCasa(tipiVaniPrimaCasa, DanieleFerroli, KindOfClasseEfficienzaEnergetica.A, 1, 3, KindOfZonaCitta.RURALE, "Via Le Mani Dal Naso 42", 100000.0, 50000.0, 0);
        CaratteristicheCasa caratteristicheDue = InizializzazioneCaratteristicheCasa(tipiVaniSecondaCasa, Immo, KindOfClasseEfficienzaEnergetica.B, 0, 1, KindOfZonaCitta.URBANA, "Via Immigrato 22", 100.0, 50.0, 2);

        Abitazione primaAbitazione = new AbitazioneFactory().createAbitazione(KindOfAbitazione.APPARTAMENTO, caratteristiche);
        Abitazione secondaAbitazione = new AbitazioneFactory().createAbitazione(KindOfAbitazione.DIMORA, caratteristicheDue);
        DanieleFerroli.addProprieta(primaAbitazione);
        RegistroAbitazioni elencoAbitazioni = new RegistroAbitazioni(primaAbitazione);
        elencoAbitazioni.visualizzaElenco();
        elencoAbitazioni.aggiungiAbitazione(secondaAbitazione);
        elencoAbitazioni.visualizzaElenco();


    }

    @NotNull
    private static CaratteristicheCasa InizializzazioneCaratteristicheCasa(List<KindOfVani> tipiVaniPrimaCasa, Proprietario danieleFerroli, KindOfClasseEfficienzaEnergetica a, int i, int i2, KindOfZonaCitta rurale, String s, double v, double v2, int i3) {
        return new CaratteristicheCasa(tipiVaniPrimaCasa, tipiVaniPrimaCasa.size(),
                a, i, i2, rurale,
                "Udine", s, danieleFerroli, v, v2,
                null, i3, KindOfCaldaia.LEGNA);
    }

    @NotNull
    private static List<KindOfVani> InizializzazioneSecondaCasaVani(KindOfVani cucina, KindOfVani salone) {
        List<KindOfVani> tipiVaniSecondaCasa = new Vector<>();
        tipiVaniSecondaCasa.add(KindOfVani.SOGGIORNO);
        tipiVaniSecondaCasa.add(cucina);
        tipiVaniSecondaCasa.add(salone);
        return tipiVaniSecondaCasa;
    }

    @NotNull
    private static List<KindOfVani> InizializzazionePrimaCasaVani() {
        List<KindOfVani> tipiVaniPrimaCasa = InizializzazioneSecondaCasaVani(KindOfVani.CAMERE, KindOfVani.BAGNI);
        tipiVaniPrimaCasa.add(KindOfVani.CUCINA);
        tipiVaniPrimaCasa.add(KindOfVani.INGRESSO);
        return tipiVaniPrimaCasa;
    }
}
