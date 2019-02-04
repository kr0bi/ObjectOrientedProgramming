package objOrientProgr.agenziaImmobiliare.Implementazioni;

import objOrientProgr.agenziaImmobiliare.Abstract.AbitazioneAbstract;
import objOrientProgr.agenziaImmobiliare.CaratteristicheCasa;

public class CasaSchiera extends AbitazioneAbstract {
    public CasaSchiera (CaratteristicheCasa caratteristicheCasa){
        this.setCaratteristicheCasa(caratteristicheCasa);
    }
}
