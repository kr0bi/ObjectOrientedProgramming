package objOrientProgr.agenziaImmobiliare;

import objOrientProgr.agenziaImmobiliare.Enum.*;
import objOrientProgr.agenziaImmobiliare.Factory.AbitazioneFactory;
import objOrientProgr.agenziaImmobiliare.Implementazioni.FiltroImplementazione;
import objOrientProgr.agenziaImmobiliare.Implementazioni.ProprietarioImplementazione;
import objOrientProgr.agenziaImmobiliare.Interface.Abitazione;
import objOrientProgr.agenziaImmobiliare.Interface.Filtro;
import objOrientProgr.agenziaImmobiliare.Interface.Proprietario;

import java.util.List;
import java.util.Vector;

public class Test {
    public static void main(String[] args) {
        List<KindOfVani> tipiVaniPrimaCasa = new Vector<KindOfVani>();
        tipiVaniPrimaCasa.add(KindOfVani.SOGGIORNO);
        tipiVaniPrimaCasa.add(KindOfVani.CAMERE);
        tipiVaniPrimaCasa.add(KindOfVani.BAGNI);
        tipiVaniPrimaCasa.add(KindOfVani.CUCINA);
        tipiVaniPrimaCasa.add(KindOfVani.INGRESSO);

        List<KindOfVani> tipiVaniSecondaCasa = new Vector<>();
        tipiVaniSecondaCasa.add(KindOfVani.SOGGIORNO);
        tipiVaniSecondaCasa.add(KindOfVani.CUCINA);
        tipiVaniSecondaCasa.add(KindOfVani.SALONE);

        Proprietario DanieleFerroli = new ProprietarioImplementazione("Daniele Ferroli", new Vector<Abitazione>());

        CaratteristicheCasa caratteristiche = new CaratteristicheCasa(tipiVaniPrimaCasa, tipiVaniPrimaCasa.size(),
                KindOfClasseEfficienzaEnergetica.A, 1, 3, KindOfZonaCitta.RURALE,
                "Udine", "Via Le Mani Dal Naso 42", DanieleFerroli, 200.0, 50000.0,
                null, 0, KindOfCaldaia.LEGNA);
        Abitazione primaAbitazione = new AbitazioneFactory().createAbitazione(KindOfAbitazione.APPARTAMENTO, caratteristiche);
        DanieleFerroli.addProprieta(primaAbitazione);

        RegistroAbitazioni elencoAbitazioni = new RegistroAbitazioni(primaAbitazione);
        //da aggiungere che si puo' aggiornare l'elenco abitazioni
        Agenzia theAgenzia = new Agenzia(elencoAbitazioni);

        Proprietario Immo = new ProprietarioImplementazione("Immo Napoli", null);
        CaratteristicheCasa caratteristicheDue = new CaratteristicheCasa(tipiVaniSecondaCasa,
                tipiVaniSecondaCasa.size(), KindOfClasseEfficienzaEnergetica.B, 0,
                1, KindOfZonaCitta.URBANA, "Udine", "Via Immigrato 22",
                Immo, 100.0, 50.0, null, 2, KindOfCaldaia.LEGNA);
        theAgenzia.creaAbitazione(KindOfAbitazione.DIMORA, caratteristicheDue);

        Filtro f = new FiltroImplementazione();
        ((FiltroImplementazione) f).addPredicato(Abitazione -> Abitazione.checkCitta("Udine"));
        ((FiltroImplementazione) f).addPredicato(Abitazione -> Abitazione.checkClasseEnergetica(KindOfClasseEfficienzaEnergetica.A));
        //da aggiungere, verificare che se non ci sono case che rispettano il filtro
        System.out.println(theAgenzia.calculateAveragePrice(f));
        //aggiungere il to string delle abitazioni
    }
}
