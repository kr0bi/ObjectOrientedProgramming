package objOrientProgr.agenziaImmobiliare.Interface;

import java.util.List;

public interface Cliente {
    public boolean checkIdentificativo(int identificativo);
    public int getIdentificativo();
    public String getName();
    public List<Abitazione> getProprietaInteressate();
    public List<Prenotazione> getPrenotazioniEffettutate();
    public boolean equals(Cliente clienteDaVerificare);
}
