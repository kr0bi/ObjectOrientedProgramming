package objOrientProgr.agenziaImmobiliare;

import objOrientProgr.agenziaImmobiliare.Enum.KindOfCaldaia;
import objOrientProgr.agenziaImmobiliare.Enum.KindOfClasseEfficienzaEnergetica;
import objOrientProgr.agenziaImmobiliare.Enum.KindOfVani;
import objOrientProgr.agenziaImmobiliare.Enum.KindOfZonaCitta;
import objOrientProgr.agenziaImmobiliare.Interface.Prenotazione;
import objOrientProgr.agenziaImmobiliare.Interface.Proprietario;

import java.util.List;

public class CaratteristicheCasa {

    private List<KindOfVani> vani;
    private int quantitaVani;
    private KindOfClasseEfficienzaEnergetica classeEfficienzaEnergetica;
    private int etaAbitazione;
    private int numeroPiani;
    private KindOfZonaCitta zonaCitta;
    private String citta;
    private String indirizzo;
    private Proprietario proprietario;
    private double prezzo;
    private double prezzoMinimo;
    private List<Prenotazione> elencoPrenotazioni;
    private int identificativo;
    private KindOfCaldaia tipoCaldaia;

    public CaratteristicheCasa (List<KindOfVani> listaVani, int numeroVani,
                                KindOfClasseEfficienzaEnergetica classe, int etaAbit,
                                int quantitaPiani, KindOfZonaCitta zona, String city,
                                String address, Proprietario owner, double prezzoCasa,
                                double prezzoMinimoOfferta, List<Prenotazione> prenotazioni,
                                int id, KindOfCaldaia kindOfCaldaia){
        vani = listaVani;
        quantitaVani = numeroVani;
        classeEfficienzaEnergetica = classe;
        etaAbitazione = etaAbit;
        numeroPiani = quantitaPiani;
        zonaCitta = zona;
        citta = city;
        indirizzo = address;
        proprietario = owner;
        prezzo = prezzoCasa;
        prezzoMinimo = prezzoMinimoOfferta;
        elencoPrenotazioni = prenotazioni;
        identificativo = id;
        tipoCaldaia = kindOfCaldaia;
    }
    public List<KindOfVani> getVani(){
        return vani;
    }
    public int getQuantitaVani(){
        return quantitaVani;
    }
    public KindOfClasseEfficienzaEnergetica getClasseEfficienzaEnergetica (){
        return classeEfficienzaEnergetica;
    }
    public int getEtaAbitazione (){
        return etaAbitazione;
    }
    public int getNumeroPiani(){
        return numeroPiani;
    }
    public KindOfZonaCitta getZonaCitta(){
        return zonaCitta;
    }
    public String getCitta(){
        return citta;
    }
    public String getIndirizzo(){
        return indirizzo;
    }
    public double getPrezzo(){
        return prezzo;
    }
    public double getPrezzoMinimo(){
        return prezzoMinimo;
    }
    public Proprietario getProprietario(){
        return proprietario;
    }
    public List<Prenotazione> getElencoPrenotazioni (){
        return elencoPrenotazioni;
    }
    public int getIdentificativo(){
        return identificativo;
    }
    public KindOfCaldaia getTipoCaldaia(){
        return tipoCaldaia;
    }
}
