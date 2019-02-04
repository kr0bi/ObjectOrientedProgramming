package objOrientProgr.agenziaImmobiliare.Interface;

import java.time.LocalDate;

public interface Prenotazione {
    public Cliente getClienteInteressato();
    public Abitazione getAbitazioneInteressata();
    public LocalDate getGiornoPrenotazione();
    public boolean equals(Prenotazione pr);
}
