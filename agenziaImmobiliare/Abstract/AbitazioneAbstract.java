package objOrientProgr.agenziaImmobiliare.Abstract;

import objOrientProgr.agenziaImmobiliare.CaratteristicheCasa;
import objOrientProgr.agenziaImmobiliare.Interface.Abitazione;
import objOrientProgr.agenziaImmobiliare.Interface.Prenotazione;
import objOrientProgr.agenziaImmobiliare.Interface.Proprietario;
import objOrientProgr.agenziaImmobiliare.Enum.KindOfCaldaia;
import objOrientProgr.agenziaImmobiliare.Enum.KindOfClasseEfficienzaEnergetica;
import objOrientProgr.agenziaImmobiliare.Enum.KindOfVani;
import objOrientProgr.agenziaImmobiliare.Enum.KindOfZonaCitta;

import java.util.Iterator;
import java.util.List;

public abstract class AbitazioneAbstract implements Abitazione {
    double prezzoPubblicato;
    double prezzoMinimo;
    List<KindOfVani> tipiVaniDisponibili;
    int quantiVaniDisponibili;
    KindOfClasseEfficienzaEnergetica coefficienteClasseEnergetica;
    int howOldIsAbitazione;
    int howManyFloors;
    KindOfZonaCitta whatsTypeOfZonaCitta;
    String inQualeCittaSiTrova;
    String indirizzoAbitaizone;
    Proprietario proprietarioAbitazione;
    List<Prenotazione> elencoPrenotazioni;
    int identificativoCasa;
    KindOfCaldaia kindOfCaldaia;

    public boolean checkRangePrezzo(double min, double max){
        boolean check = false;
        if (prezzoPubblicato>=min && prezzoPubblicato<=max){
            check = true;
        }
        return check;
    }
    public boolean checkTipoCaldaia(KindOfCaldaia tipoCaldaia){
        boolean check = false;
        if (tipoCaldaia == kindOfCaldaia){
            check = true;
        }
        return check;
    }
    public boolean checkTipoVano (KindOfVani vano){
        boolean check = false;
        Iterator<KindOfVani> it = tipiVaniDisponibili.iterator();
        while (it.hasNext()){
            if (vano == it.next()){
                check = true;
                break;
            }
        }
        return check;
    }
    public boolean checkNumeroVani(int numeroVani){
        boolean check = false;
        if (numeroVani == quantiVaniDisponibili){
            check = true;
        }
        return check;
    }
    public boolean checkClasseEnergetica (KindOfClasseEfficienzaEnergetica tipoClasseEnergetica){
        boolean check = false;
        if (tipoClasseEnergetica == coefficienteClasseEnergetica){
            check = true;
        }
        return check;
    }
    public boolean checkEtaAbitazione (int etaAbitazione){
        boolean check = false;
        if (etaAbitazione == howOldIsAbitazione){
            check = true;
        }
        return check;
    }
    public boolean checkQuantitaPiani (int numeroPiani){
        boolean check = false;
        if (numeroPiani == howManyFloors){
            check = true;
        }
        return check;
    }
    public boolean checkZonaCitta (KindOfZonaCitta zonaCitta){
        boolean check = false;
        if (whatsTypeOfZonaCitta == zonaCitta){
            check = true;
        }
        return check;
    }
    public boolean checkCitta (String citta){
        boolean check = false;
        if (citta.equalsIgnoreCase(inQualeCittaSiTrova)){
            check = true;
        }
        return check;
    }
    public boolean checkIndirizzoAbitazione (String indirizzo){
        boolean check = false;
        if (indirizzo.equalsIgnoreCase(indirizzoAbitaizone)){
            check = true;
        }
        return check;
    }
    public boolean checkOwner(Proprietario theOwner){
        boolean check = false;
        if (theOwner.equals(proprietarioAbitazione)){
            check = true;
        }
        return check;
    }
    public boolean checkPrenotazione (Prenotazione thePrenotazione){
        boolean check = false;
        Iterator<Prenotazione> it = elencoPrenotazioni.iterator();
        while (it.hasNext()){
            if (thePrenotazione.equals(it.next())){
                check = true;
                break;
            }
        }
        return check;
    }
    public boolean checkPrezzoMinimo (double prezzo){
        boolean check = false;
        if (prezzo == prezzoMinimo){
            check = true;
        }
        return check;
    }
    public boolean checkIdentificativo (int identificativo){
        boolean check = false;
        if (identificativo == identificativoCasa){
            check = true;
        }
        return check;
    }

    public KindOfCaldaia getKindOfCaldaia(){
        return kindOfCaldaia;
    }
    public List<KindOfVani> getTipiVaniDisponibili (){
        return tipiVaniDisponibili;
    }
    public int getQuantiVaniDisponibili (){
        return quantiVaniDisponibili;
    }
    public KindOfClasseEfficienzaEnergetica getCoefficienteClasseEnergetica(){
        return coefficienteClasseEnergetica;
    }
    public int getHowOldIsAbitazione(){
        return howOldIsAbitazione;
    }
    public int getHowManyFloors(){
        return howManyFloors;
    }
    public KindOfZonaCitta getWhatsTypeOfZonaCitta(){
        return whatsTypeOfZonaCitta;
    }
    public String getInQualeCittaSiTrova(){
        return inQualeCittaSiTrova;
    }
    public String getIndirizzoAbitazione(){
        return indirizzoAbitaizone;
    }
    public Proprietario getProprietarioAbitazione(){
        return proprietarioAbitazione;
    }
    public List<Prenotazione> getElencoPrenotazioni(){
        return elencoPrenotazioni;
    }
    public double getPrezzoPubblicato(){
        return prezzoPubblicato;
    }
    public double getPrezzoMinimo(){
        return prezzoMinimo;
    }
    public int getIdentificativoCasa(){
        return identificativoCasa;
    }

    public void setCaratteristicheCasa (CaratteristicheCasa caratteristicheCasa){
        prezzoPubblicato = caratteristicheCasa.getPrezzo();
        prezzoMinimo = caratteristicheCasa.getPrezzoMinimo();
        //todo verificare che funzioni
        tipiVaniDisponibili = caratteristicheCasa.getVani();
        quantiVaniDisponibili = caratteristicheCasa.getQuantitaVani();
        coefficienteClasseEnergetica = caratteristicheCasa.getClasseEfficienzaEnergetica();
        howOldIsAbitazione = caratteristicheCasa.getEtaAbitazione();
        howManyFloors = caratteristicheCasa.getNumeroPiani();
        whatsTypeOfZonaCitta = caratteristicheCasa.getZonaCitta();
        inQualeCittaSiTrova = caratteristicheCasa.getCitta();
        indirizzoAbitaizone = caratteristicheCasa.getIndirizzo();
        proprietarioAbitazione = caratteristicheCasa.getProprietario();
        elencoPrenotazioni = caratteristicheCasa.getElencoPrenotazioni();
        identificativoCasa = caratteristicheCasa.getIdentificativo();
        kindOfCaldaia = caratteristicheCasa.getTipoCaldaia();
    }
}
