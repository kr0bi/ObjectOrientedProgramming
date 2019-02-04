package objOrientProgr.agenziaImmobiliare.Abstract;

import objOrientProgr.agenziaImmobiliare.Interface.Abitazione;
import objOrientProgr.agenziaImmobiliare.Interface.Cliente;
import objOrientProgr.agenziaImmobiliare.Interface.Prenotazione;

import java.time.LocalDate;

public abstract class PrenotazioneAbstract implements Prenotazione {
    Cliente theCliente;
    Abitazione theAbitazione;
    LocalDate giornoPrenotazione;

    public boolean equals(Prenotazione pr){
        boolean check = false;
        if (this.getClienteInteressato().equals(pr.getClienteInteressato()) &&
        this.getAbitazioneInteressata().equals(pr.getAbitazioneInteressata()) &&
        this.getGiornoPrenotazione().equals(pr.getGiornoPrenotazione())){
            check = true;
        }
        return check;

    }
}
