package objOrientProgr.agenziaImmobiliare.Abstract;

import objOrientProgr.agenziaImmobiliare.Interface.Abitazione;
import objOrientProgr.agenziaImmobiliare.Interface.Cliente;
import objOrientProgr.agenziaImmobiliare.Interface.Prenotazione;

import java.util.List;

public abstract class ClienteAbstract {
    int identificativo;
    String name;
    List<Abitazione> proprietaInteressate;
    List<Prenotazione> prenotazioneEffettuate;

    public boolean checkIdentificativo (int identificativoDaControllare){
        boolean check = false;
        if (identificativo == identificativoDaControllare){
            check = true;
        }
        return check;
    }
    public int getIdentificativo(){
        return identificativo;
    }
    public String getName(){
        return name;
    }
    public List<Abitazione> getProprietaInteressate (){
        return proprietaInteressate;
    }
    public List<Prenotazione> getPrenotazioneEffettuate(){
        return prenotazioneEffettuate;
    }

    //todo controllo solo il nome e l'identificativo
    public boolean equals (Cliente clienteDaVerificare){
        boolean check = false;
        if (this.getName().equalsIgnoreCase(clienteDaVerificare.getName()) && this.getIdentificativo()==clienteDaVerificare.getIdentificativo()){
            check = true;
        }
        return check;
    }

}
