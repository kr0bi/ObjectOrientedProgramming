package objOrientProgr.agenziaImmobiliare;

public class AbitazioneFactory {
    public Abitazione createAbitazione (KindOfAbitazione tipoAbitazione){
        if (tipoAbitazione == KindOfAbitazione.SINGOLA){
            return new CasaSingola();
        } else if (tipoAbitazione == KindOfAbitazione.APPARTAMENTO){
            return new Appartamento();
        } else if (tipoAbitazione == KindOfAbitazione.SCHIERA){
            return new CasaSchiera();
        } else if (tipoAbitazione == KindOfAbitazione.DIMORA) {
            return new DimoraDiLusso();
        } else {
            throw new RuntimeException("abitazione non gestita");
        }

    }
}
