package objOrientProgr.agenziaImmobiliare.Implementazioni;

import objOrientProgr.agenziaImmobiliare.Interface.Abitazione;
import objOrientProgr.agenziaImmobiliare.Interface.Proprietario;

import java.util.Iterator;
import java.util.List;

public class ProprietarioImplementazione implements Proprietario {
    private String nome;
    private List<Abitazione> elencoProprieta;

    public ProprietarioImplementazione (String name, List<Abitazione> lista){
        nome = name;
        elencoProprieta = lista;
    }
    public void addProprieta (Abitazione theAbitazione){
        elencoProprieta.add(theAbitazione);
    }

    public String getNome(){
        return nome;
    }
    public List<Abitazione> getElencoProprieta(){
        return elencoProprieta;
    }
    public boolean equals (Proprietario p){
        boolean check = false;
        if (this.getNome().equalsIgnoreCase(p.getNome())){
            if (getElencoProprieta().size() == p.getElencoProprieta().size()){
                Iterator<Abitazione> it1 = this.getElencoProprieta().iterator();
                Iterator<Abitazione> it2 = p.getElencoProprieta().iterator();
                while (it1.hasNext()){
                    if (it1.next().getIdentificativoCasa() == it2.next().getIdentificativoCasa()){
                        check = true;
                    } else {
                        check = false;
                        break;
                    }
                }
            }
        }
        return check;
    }
}
