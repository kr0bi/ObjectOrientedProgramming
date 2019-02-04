package objOrientProgr.agenziaImmobiliare.Interface;

import java.util.List;

public interface Proprietario {
    public String getNome();
    public void addProprieta(Abitazione theAbitazione);
    public List<Abitazione> getElencoProprieta();
    public boolean equals(Proprietario p);
}
