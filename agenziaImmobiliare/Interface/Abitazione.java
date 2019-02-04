package objOrientProgr.agenziaImmobiliare.Interface;

import objOrientProgr.agenziaImmobiliare.CaratteristicheCasa;
import objOrientProgr.agenziaImmobiliare.Enum.KindOfCaldaia;
import objOrientProgr.agenziaImmobiliare.Enum.KindOfClasseEfficienzaEnergetica;
import objOrientProgr.agenziaImmobiliare.Enum.KindOfVani;
import objOrientProgr.agenziaImmobiliare.Enum.KindOfZonaCitta;

import java.util.List;

public interface Abitazione {
    public boolean checkRangePrezzo(double min, double max);
    public boolean checkTipoCaldaia(KindOfCaldaia tipoCaldaia);
    public boolean checkTipoVano (KindOfVani vano);
    public boolean checkNumeroVani(int numeroVani);
    public boolean checkClasseEnergetica (KindOfClasseEfficienzaEnergetica tipoClasseEnergetica);
    public boolean checkEtaAbitazione (int etaAbitazione);
    public boolean checkQuantitaPiani (int numeroPiani);
    public boolean checkZonaCitta (KindOfZonaCitta zonaCitta);
    public boolean checkCitta (String citta);
    public boolean checkIndirizzoAbitazione (String indirizzo);
    public boolean checkOwner(Proprietario theOwner);
    public boolean checkPrenotazione (Prenotazione thePrenotazione);
    public boolean checkPrezzoMinimo (double prezzo);
    public boolean checkIdentificativo (int identificativo);

    public KindOfCaldaia getKindOfCaldaia();
    public List<KindOfVani> getTipiVaniDisponibili ();
    public int getQuantiVaniDisponibili ();
    public KindOfClasseEfficienzaEnergetica getCoefficienteClasseEnergetica();
    public int getHowOldIsAbitazione();
    public int getHowManyFloors();
    public KindOfZonaCitta getWhatsTypeOfZonaCitta();
    public String getInQualeCittaSiTrova();
    public String getIndirizzoAbitazione();
    public Proprietario getProprietarioAbitazione();
    public List<Prenotazione> getElencoPrenotazioni();
    public double getPrezzoPubblicato();
    public double getPrezzoMinimo();
    public int getIdentificativoCasa();

    public void setCaratteristicheCasa (CaratteristicheCasa caratteristicheCasa);
}
