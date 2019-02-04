package objOrientProgr.agenziaImmobiliare.Implementazioni;

import objOrientProgr.agenziaImmobiliare.Abstract.AbitazioneAbstract;
import objOrientProgr.agenziaImmobiliare.CaratteristicheCasa;

public class Appartamento extends AbitazioneAbstract {
    public Appartamento (CaratteristicheCasa caratteristicheCasa){
        this.setCaratteristicheCasa(caratteristicheCasa);
    }
}
