package objOrientProgr.agenziaImmobiliare.Implementazioni;
import objOrientProgr.agenziaImmobiliare.Abstract.AbitazioneAbstract;
import objOrientProgr.agenziaImmobiliare.CaratteristicheCasa;

public class CasaSingola extends AbitazioneAbstract {
    public CasaSingola (CaratteristicheCasa caratteristicheCasa){
        this.setCaratteristicheCasa(caratteristicheCasa);
    }
}
