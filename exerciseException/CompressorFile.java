package objOrientProgr.exerciseException;

import objOrientProgr.exerciseException.exception.CantBeNullException;
import objOrientProgr.exerciseException.exception.NoSuchFileException;
import org.jetbrains.annotations.NotNull;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/*
    Lo scopo di questa classe e' di gestire le richieste di lettura, scrittura, compressione di un file contenente
    delle stringhe in codifica UTF-8
 */

public class CompressorFile {

    public CompressorFile(){
    }

    public void comprimiFile(String nameFileSource, String nameFileDestination, String comeComprimere){
        Path filePathSource = buildPath(nameFileSource);
        Path filePathDestination = buildPath(nameFileDestination);
        List<String> datiFileDestination = null;

        try {
            datiFileDestination = inizializeDatiFile(filePathSource);
            datiFileDestination = comprimiDatiFileDestination(datiFileDestination, comeComprimere);
        } catch (NoSuchFileException nsfe){
            System.out.println(nsfe.toString());
            System.exit(-1);
        } catch (CantBeNullException cbne){
            System.out.println(cbne.toString());
            System.exit(-1);
        }
        writeFileDataOnFilePathDestination(filePathDestination, datiFileDestination);
    }

    /**
     * comprimiDatiFileDestination: esegue la compressione dei file destinatario
     * @return datiFileDestination compressi
     */
    private List<String> comprimiDatiFileDestination(List<String> datiFileDestination, String comeComprimere) throws CantBeNullException{
        assert (datiFileDestination != null) : "datiFileDestination can't be null";
        datiFileDestination = compressDatiFile(datiFileDestination, comeComprimere);
        return datiFileDestination;
    }

    /**
     * inizializeDatiFile: inizializza le variabili di instanza e fetcha le stringhe del file sorgente
     * @param filePathSource indirizzo in cui si trova il file sorgente
     */
    private List<String> inizializeDatiFile(Path filePathSource) throws NoSuchFileException{
        assert (filePathSource != null) : "filePathSource can't be null";
        List<String> datiFile = null;
        datiFile = getAllLinesFromFile(datiFile, filePathSource);
        return datiFile;
    }

    /**
     * compressDatiFile comprime (cancellando i whitespace) il contenuto
     * della lista di stringhe sorgente in una lista di stringhe destinataria
     *
     * @param datiFileDestination lista di stringhe che deve essere compressa
     * @return la lista di stringhe in cui e' stata effettuata la compressione
     */
    private List<String> compressDatiFile( List<String> datiFileDestination, String comeComprimere) throws CantBeNullException{
        assert (datiFileDestination != null) : "datiFileDestination can't be null";
        int numeroDiLinee = getNumberOfLinesOfDatiFileSource(datiFileDestination);
        assert (numeroDiLinee > -1) : "Il numero di linee deve essere sempre maggiore di -1";
        for (int i = 0; i < numeroDiLinee; i++) {
            datiFileDestination.set(i, compressString(datiFileDestination.get(i), comeComprimere));
        }
        return datiFileDestination;
    }

    /**
     * getNumberOfLinesOfDatiFileSource conta il numero di linea presenti all'interno di datiFileSource
     * @return il numero di linee presenti all'interno del file sorgente
     */
    private int getNumberOfLinesOfDatiFileSource(List<String> datiFile) {
        assert (datiFile != null) : "datiFile can't be null | errore nella lettura del numero di linee presenti";
        return datiFile.size();
    }

    /**
     * getAllLinesFromFile prende tutte le stringhe all'interno di un file e le divide in righe
     * @param datiFile la lista di stringhe che contiene le stringhe all'interno del file
     * @param filePath percorso del file in cui prendere le stringhe
     * @throws NoSuchFileException se il file non esiste
     * @return datiFile che conterra' in ogni elemento della lista una riga del file
     */
    private List<String> getAllLinesFromFile(List<String> datiFile, Path filePath) throws NoSuchFileException{
        assert (datiFile != null || filePath != null) : "datiFile or filePath can't be null ";
        try {
            datiFile = Files.readAllLines(filePath);
        } catch (java.io.IOException ioe) {
            throw new NoSuchFileException(ioe.toString() + "\n getAllLinesFromFile: readAllLines(filePath)" + "\n File doesn't exist");
        }
        return datiFile;
    }

    /**
     * buildPath unisce il default Path e il nome del file in un unico Path
     *
     * @param nameFile nome del file da aggiungere per il Path
     * @return indirizzo completo del file
     */
    //private final String defaultPathLinux = "/home/daniele/Dropbox/uniud/Materie/UniUD/src/main/java/objOrientProgr/exerciseException/";
    //String defaultPath = "C:\\Users\\Daniele\\Dropbox\\uniud\\Materie\\UniUD\\src\\main\\java\\objOrientProgr\\exerciseException\\";
    @NotNull
    private Path buildPath(String nameFile) {
        assert (nameFile != null) : "nameFile can't be null";
        assert (nameFile.length() > 0) : "nameFile.length MUST be > 0";
        nameFile = "/src/main/java/objOrientProgr/exerciseException/" + nameFile;
        //nameFile = "\\src\\main\\java\\objOrientProgr\\exerciseException\\"+nameFile;
        return FileSystems.getDefault().getPath(System.getProperty("user.dir") + nameFile);
    }

    /**
     * writeFileDataOnFilePathDestination scrive all'interno del filePathDestination i contenuti di datiFileDestination
     * @param filePathDestination indirizzo su cui andare a scrivere i contenuti
     * @param datiFileDestination lista di stringhe che deve essere scritta nel file di destinazione
     */
    private void writeFileDataOnFilePathDestination(Path filePathDestination, List<String> datiFileDestination) {
        try {
            Files.write(filePathDestination, datiFileDestination);
            System.out.println("Compressione avvenuta con successo!");
        } catch (java.io.IOException ioe) {   //modificare il to.string in maniera che sia piu' leggibile
            System.out.println(ioe.toString() + "\nnon sono riuscito a scrivere i dati sulla destinazione specificata");
            System.out.println("writeFileDataOnFilePathDestination: Files.write(filePathDestination, datiFileDestination1);\n");
            System.exit(-1);
        }
    }
    /**
     * compressString data una stringa comprime i suoi contenuti togliendo se presenti dei whitespace
     * @param linea stringa che verra' compressa
     * @return stringaCompressa = linea togliendo i whitespace
     */
    private String compressString(String linea, String comeComprimere) throws CantBeNullException{
        if (comeComprimere==null){
            throw new CantBeNullException("comeComprimere can't be null");
        }
        assert (comeComprimere != null) : "comeComprimere can't be null";
        assert (linea.length() >= 0) : "la lunghezza deve essere maggiore di zero";
        String stringaCompressa = "";
        for (int i = 0; i < linea.length(); i++) {
            if (linea.charAt(i) == ' '){
                 stringaCompressa = stringaCompressa + comeComprimere;
            } else {
                stringaCompressa = stringaCompressa + linea.substring(i, i + 1);
            }
        }
        return stringaCompressa;
    }
}
