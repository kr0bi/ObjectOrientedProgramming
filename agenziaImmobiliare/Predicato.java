package objOrientProgr.agenziaImmobiliare;

import objOrientProgr.agenziaImmobiliare.Enum.KindOfCaldaia;
import objOrientProgr.agenziaImmobiliare.Enum.KindOfClasseEfficienzaEnergetica;
import objOrientProgr.agenziaImmobiliare.Enum.KindOfVani;
import objOrientProgr.agenziaImmobiliare.Enum.KindOfZonaCitta;
import objOrientProgr.agenziaImmobiliare.Interface.Abitazione;
import objOrientProgr.agenziaImmobiliare.Interface.Prenotazione;
import objOrientProgr.agenziaImmobiliare.Interface.Proprietario;

import java.util.function.Predicate;

public class Predicato {
    public Predicate<Abitazione> isPrezzoBetween (double min, double max){
        return (Abitazione -> Abitazione.checkRangePrezzo(min, max));
    }
    public Predicate<Abitazione> isTipoCaldaiaEqualTo(KindOfCaldaia tipoCaldaia){
        return (Abitazione -> Abitazione.checkTipoCaldaia(tipoCaldaia));
    }
    public Predicate<Abitazione> isTipoVanoEqualTo(KindOfVani tipoVano){
        return (Abitazione -> Abitazione.checkTipoVano(tipoVano));
    }
    public Predicate<Abitazione> isNumberOfVaniEqualTo (int numeroVani){
        return (Abitazione -> Abitazione.checkNumeroVani(numeroVani));
    }
    public Predicate<Abitazione> isTipoClasseEnergeticaEqualTo (KindOfClasseEfficienzaEnergetica classeEnergetica){
        return Abitazione -> Abitazione.checkClasseEnergetica(classeEnergetica);
    }
    public Predicate<Abitazione> isEtaAbitazioneEqualTo (int etaAbitazione){
        return Abitazione -> Abitazione.checkEtaAbitazione(etaAbitazione);
    }
    public Predicate<Abitazione> isQuantitaPianiEqualTo (int numeroPiani){
        return Abitazione -> Abitazione.checkQuantitaPiani(numeroPiani);
    }
    public Predicate<Abitazione> isZonaCittaEqualTo (KindOfZonaCitta zonaCitta){
        return Abitazione -> Abitazione.checkZonaCitta(zonaCitta);
    }
    public Predicate<Abitazione> isCittaEqualTo (String citta){
        return Abitazione -> Abitazione.checkCitta(citta);
    }
    public Predicate<Abitazione> isIndirizzoAbitazioneEqualTo (String indirizzo){
        return Abitazione -> Abitazione.checkIndirizzoAbitazione(indirizzo);
    }
    public Predicate<Abitazione> isThisTheOwner(Proprietario owner){
        return Abitazione -> Abitazione.checkOwner(owner);
    }
    public Predicate<Abitazione> isAlreadyPrenotato (Prenotazione thePrenotazione){
        return Abitazione -> Abitazione.checkPrenotazione(thePrenotazione);
    }
    public Predicate<Abitazione> isPrezzoMinimoPiuAltoDi (double prezzo){
        return Abitazione -> Abitazione.checkPrezzoMinimo(prezzo);
    }
    public Predicate<Abitazione> isThisTheRightAbitazione (int identificativo){
        return Abitazione -> Abitazione.checkIdentificativo(identificativo);
    }
}
