package objOrientProgr.agenziaImmobiliare.Factory;

import objOrientProgr.agenziaImmobiliare.*;
import objOrientProgr.agenziaImmobiliare.Enum.KindOfAbitazione;
import objOrientProgr.agenziaImmobiliare.Implementazioni.Appartamento;
import objOrientProgr.agenziaImmobiliare.Implementazioni.CasaSchiera;
import objOrientProgr.agenziaImmobiliare.Implementazioni.CasaSingola;
import objOrientProgr.agenziaImmobiliare.Implementazioni.DimoraDiLusso;
import objOrientProgr.agenziaImmobiliare.Interface.Abitazione;

public class AbitazioneFactory {
    public Abitazione createAbitazione (KindOfAbitazione tipoAbitazione, CaratteristicheCasa lista){
        if (tipoAbitazione == KindOfAbitazione.SINGOLA){
            return new CasaSingola(lista);
        } else if (tipoAbitazione == KindOfAbitazione.APPARTAMENTO){
            return new Appartamento(lista);
        } else if (tipoAbitazione == KindOfAbitazione.SCHIERA){
            return new CasaSchiera(lista);
        } else if (tipoAbitazione == KindOfAbitazione.DIMORA) {
            return new DimoraDiLusso(lista);
        } else {
            throw new RuntimeException("abitazione non gestita");
        }

    }
}
