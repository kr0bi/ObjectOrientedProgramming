package objOrientProgr.compitoMatrici;

import objOrientProgr.compitoMatrici.exception.*;
import org.jetbrains.annotations.NotNull;

import java.util.Vector;

public class Matrix {
    // TODO Scrivere lo stato astratto
    /*
        Lo stato astratto della classe rappresenta una matrice MUTABILE
     */
    // TODO Scrivere esempi di stato astratto
    /*
        Un esempio di stato astratto e' una matrice scritta cosi':
        {{1,1,2}, {4,1,2}, {5,3,2}}, n=3, m=3 (righe/colonne)
        {{1}}, n=1, m=1
     */
    // TODO Spiegare come e' stato rappresentato lo stato concreto
    /*
        Lo stato concreto della classe e' rappresentato da un Vector<Vector<Integer>>
        Ad esempio una matrice 2x3 e' rappresentata da un un Vector<Vector<Integer>> di dimensione 2
        in cui ogni riga (Vectpr<Integer>) ha una dimensione 3
     */
    // TODO Scrivere degli esempi di stato concreto
    /*
        Riprendendo l'esempio di prima, la matrice precedente e' rappresentata cosi':
            righe = 3
            colonne = 3
            matrice = {{1,2,2}, {4,1,2}, {5,3,2}}
     */
    // TODO Scrivere la funzione di astrazione
    /*
        La funzione di astrazione e' di associare il numero di righe con un vettore che contiene un vettore per ogni riga
        per rappresentare il numero di colonne

        Lo stato concreto e' definito in termini di possibili valori di un'istanza Vector:
            eg: [1], [1,2,3], [20, 20, 20, 20]
                              [40, 40, 40, 40]
                              [60, 60, 60, 60]
                              [80, 80, 80, 80]
        Lo stato astratto e' definito in termini di possibili matrici matematiche:
            eg: {{1,2,3},{1,2,3},{1,2,3}}, {{1}}, {{1,2,3},{0,1,2}}
     */
    // TODO Scrivere degli esempi di invarianti
    /*
        The Abstraction Invariant
            La matrice e' definita valida solo quando il numero di righe e colonne e' maggiore di zero.

        The representation invariant for Matrix:
            righe, colonne > 0
            for each 0<=i<=righe-1: data.get(i) != null &&
            data.get(i).size() = colonne  &&
            data.size() = righe
     */
    private int righe;
    private int colonne;
    private Vector<Vector<Integer>> matrice;

    /**
     * Una matrice vuota riempita di zeri di dimensione rows x columns
     *
     * @param rows    numero di righe da inserire
     * @param columns numero di colonne da inserire
     * @throws dimensionsException viene tirata l'eccezione se il numero di righe o dimensione e' <= 0
     */
    public Matrix(int rows, int columns) throws dimensionsException {
        doMatrices(rows, columns);
    }

    /**
     * doMatrices: costruisce la matrice vuota e inizializza le variabili
     *
     * @param rows    numero di righe da inserire
     * @param columns numero di colonne da inserire
     * @throws dimensionsException viene tirata l'eccezione se il numero di righe o dimensione e' <= 0
     */
    private void doMatrices(int rows, int columns) throws dimensionsException {
        checkDimensions(rows, columns);
        inizializeVariables(rows, columns);
    }

    /**
     * checkDimensions: verifica che il numero di colonne e righe sia maggiore di zero
     *
     * @param rows    numero di righe
     * @param columns numero di colonne
     * @throws dimensionsException nel caso che rows e columns siano <= 0 tira l'eccezione
     */
    private void checkDimensions(int rows, int columns) throws dimensionsException {
        if (rows <= 0 || columns <= 0) {
            throw new dimensionsException("La dimensione delle righe e delle colonne deve essere maggiore di zero");
        }
    }

    /**
     * inizializeVariables: inizializza le variabili di stato
     *
     * @param rows    numero di righe da inizializzare
     * @param columns numero di colonne da inizializzare
     *                MODIFIES: this
     */
    private void inizializeVariables(int rows, int columns) {
        assert (checkInvariante()) : "Invariante non valida";
        righe = rows;
        colonne = columns;
        createMatrix();
    }

    /**
     * createMatrix: crea una matrice vuota riempita di un vettore colonna che contiene vettori riga
     * che contengono solo zeri
     * MODIFIES: this
     */
    private void createMatrix() {
        matrice = new Vector<Vector<Integer>>(colonne);
        createRowsMatrix();
        inizializeMatrix();
    }

    /**
     * createRowsMatrix: crea le righe del vettore colonna nella matrice
     * MODIFIES: this
     */
    private void createRowsMatrix() {
        for (int i = 0; i < righe; i++) {
            matrice.add(i, new Vector<Integer>(righe));
        }
    }

    /**
     * inizializeMatrix: inizializza i vettori riga con degli zeri
     * MODIFIES: this
     */
    private void inizializeMatrix() {
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                matrice.get(i).add(0);
            }
        }
    }

    /**
     * Crea una matrice riempita di righe ripetendo i dati di dimensione rows x columns
     *
     * @param rows    numero di righe della matrice
     * @param columns numero di colonne della matrice
     * @param dato    array che viene copiato per righe
     * @throws columnsIndexOutOfBoundsException se il numero di colonne della matrice e' minore
     *                                          della lunghezza del dato viene tirata l'eccezione
     */
    public Matrix(int rows, int columns, int[] dato) throws columnsIndexOutOfBoundsException {
        doMatricesWork(rows, columns, dato);
    }

    /**
     * doMatricesWork: crea una matrice che rispetta queste proprieta'
     * il dato viene inserito in ogni riga della matrice e verifica che la lunghezza del dato
     * non sia piu' grande del numero di colonne della matrice
     *
     * @param rows    numero di righe
     * @param columns numero di colonne
     * @param dato    vettore che viene inserito nella matrice
     * @throws columnsIndexOutOfBoundsException se il numero di colonne della matrice e' minore
     *                                          della lunghezza del dato viene tirata l'eccezione
     */
    private void doMatricesWork(int rows, int columns, int[] dato) throws columnsIndexOutOfBoundsException {
        checkColumnsIndex(rows, columns, dato);
        inizializeVariablesWithArray(rows, columns, dato);
    }

    /**
     * checkColumnsIndex: verifica che il numero di colonne della matrice
     * NON sia minore della lunghezza del dato
     *
     * @param rows    numero di righe
     * @param columns numero di colonne
     * @param dato    vettore che deve essre controllato
     * @throws columnsIndexOutOfBoundsException eccezione che viene tirata quando il numero di colonne e' minore
     *                                          della lunghezza del dato
     */
    private void checkColumnsIndex(int rows, int columns, int[] dato) throws columnsIndexOutOfBoundsException {
        int lengthDato = dato.length;
        if (columns < lengthDato) {
            throw new columnsIndexOutOfBoundsException("Il numero di dati da copiare e' maggiore del numero di colonne possibili");
        }
    }

    /**
     * inizializeVariablesWithArray: inizializza la matrice con il numero di righe/colonne parametrizzate
     * e con il vettore da mettere all'interno della matrice
     *
     * @param rows    numero di righe
     * @param columns numero di colonne
     * @param dato    vettore da inserire all'interno della matrice
     *                MODIFIES: this
     */
    private void inizializeVariablesWithArray(int rows, int columns, int[] dato) {
        assert (checkInvariante()) : "Invariante non valida";
        righe = rows;
        colonne = columns;
        createMatrixWithArray(dato);
    }

    /**
     * createMatrixWithArray: crea la matrice usando il vettore ripetuto per ogni riga
     *
     * @param dato vettore da ripetere all'interno della matrice
     *             MODIFIES: this
     */
    private void createMatrixWithArray(int[] dato) {
        matrice = new Vector<Vector<Integer>>(colonne);
        createRowsMatrix();
        inizializeMatrixWithArray(dato);
    }

    /**
     * inizializeMatrixWithArray: inizializza la matrice con il vettore riptetuto per ogni riga
     *
     * @param dato vettore da ripetere all'interno della matrice
     *             MODIFIES: this
     */
    private void inizializeMatrixWithArray(int[] dato) {
        assert (checkInvariante()) : "Invariante non valida";
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                matrice.get(i).add(dato[j]);
            }
        }
    }

    /**
     * insert: Inserisce il datoDaInserire all'interno della matrice alle coordinate (rows, colums)
     *
     * @param rows           numero di righe della matrice in cui inserire il dato
     * @param columns        numero di colonne della matrice in cui inserire il dato
     * @param datoDaInserire dato da inserire all'interno della matrice
     * @throws incompatibleInsertMatrixException se vengono inserite delle coordinate che non
     *                                           esistono all'interno della matrice viene tirata questa eccezione
     *                                           MODIFIES: this con il valore aggiunto alla matrice
     */
    public void insert(int rows, int columns, int datoDaInserire) throws incompatibleInsertMatrixException {
        doInsertWork(rows, columns, datoDaInserire);
    }

    /**
     * doInsertWork: verifica che il dato possa essere inserito all'interno della matrice e lo imposta
     *
     * @param rows           riga in cui andare a inserire il valore della matrice
     * @param columns        colonna in cui andare a inserire il valore della matrice
     * @param datoDaInserire dato da inserire all'interno della matrice
     * @throws incompatibleInsertMatrixException se non esistono le coordinate della matrice viene tirata questa eccezione
     */
    private void doInsertWork(int rows, int columns, int datoDaInserire) throws incompatibleInsertMatrixException {
        assert (checkInvariante()) : "Invariante non valida";
        checkMatrixCompatibility(rows, columns);
        setValueOnMatrix(rows, columns, datoDaInserire);
    }

    /**
     * checkMatrixCompatibility: verifica che il numero di righe e colonne inserite siano compatibili con quelle della matrice
     * @param rows riga da controllare
     * @param columns colonna da controllare
     * @throws incompatibleInsertMatrixException se il numero di righe o colonne inserito e' maggiore
     * della grandezza della matrice viene tirata una eccezione
     */
    private void checkMatrixCompatibility(int rows, int columns) throws incompatibleInsertMatrixException {
        if (righe < rows || colonne < columns) {
            throw new incompatibleInsertMatrixException("Numero di righe o numero di colonne piu' grande della matrice");
        }
    }

    /**
     * setValueOnMatrix: imposta datoDaInserire alle coordinate (rows,coloums)
     * @param rows riga in cui inserire il dato
     * @param columns colonna in cui inserire il dato
     * @param datoDaInserire dato da inserire
     */
    private void setValueOnMatrix(int rows, int columns, int datoDaInserire) {
        assert (checkInvariante()) : "Invariante invalida";
        matrice.get(rows).setElementAt(datoDaInserire, columns);
    }

    /**
     * multiply: moltiplica this per la matrice
     * @param m matrice da moltiplicare
     * @throws incompatibleMultiplyMatrixException se il numero di colonne della matrice iniziale e' differente dal numero di righe della
     * seconda matrice viene tirata un'eccezione
     * @throws incompatibleInsertMatrixException se le coordinate riga/colonna della matrice moltplicata sono sbagliate
     * @throws dimensionsException se vengono inserite righe/colonne <= 0 tira questa eccezione
     */
    public void multiply(Matrix m) throws incompatibleMultiplyMatrixException, incompatibleInsertMatrixException, dimensionsException {
        doMultiplyWork(m);
    }

    /**
     * doMultiplyWork: verifica che possa avvenire la moltiplicazione e la esegue
     * @param m matrice da moltiplicare
     * @throws incompatibleMultiplyMatrixException se il numero di colonne della matrice iniziale e' differente dal numero di righe della
     * seconda matrice viene tirata un'eccezione
     * @throws incompatibleInsertMatrixException se le coordinate riga/colonna della matrice moltplicata sono sbagliate
     * @throws dimensionsException se vengono inserite righe/colonne <= 0 tira questa eccezione
     */
    private void doMultiplyWork(Matrix m) throws incompatibleInsertMatrixException, incompatibleMultiplyMatrixException, dimensionsException {
        checkMultiplyDimension(m);
        Matrix m3 = multiplyMatrices(m);
        copiaMatrice(m3);
    }

    /**
     * checkMultiplyDimension: verifica che possa avvenire la moltiplicazione
     * @param m matrice da moltiplicare
     * @throws incompatibleMultiplyMatrixException le dimensioni della colonna della
     *                                             prima matrice e le dimensioni della riga della seconda matrice
     *                                             sono incompatibili
     */
    private void checkMultiplyDimension(Matrix m) throws incompatibleMultiplyMatrixException {
        if (this.getColonne() != m.getRighe()) {
            throw new incompatibleMultiplyMatrixException("La colonna della prima matrice e' diversa dalle righe dalla seconda matrice");
        }
    }

    /**
     * multiplyMatrices: moltiplica la matrice
     * @param m matrice da moltiplicare
     * @return  la matrice moltiplicata
     * @throws dimensionsException se si prova a inserire righe/colonne <= 0
     * @throws incompatibleInsertMatrixException se si prova a mettere coordinate non esistenti all'interno della matrice
     */
    @NotNull
    private Matrix multiplyMatrices(Matrix m) throws dimensionsException, incompatibleInsertMatrixException {
        assert (checkInvariante()) : "Invariante non valida";
        Matrix m3 = new Matrix(getRighe(), m.getColonne());
        for (int i = 0; i < getRighe(); i++) {
            for (int j = 0; j < m.getColonne(); j++) {
                int sumOverH = doSumOverH(m, i, j);
                m3.insert(i, j, sumOverH);
            }
        }
        return m3;
    }

    /**
     * doSumOver: esegue la moltiplicazione delle due coordinate
     * @param m matrice da moltiplicare
     * @param i indice delle righe
     * @param j indice delle colonne
     * @return ritorna la somma della moltiplicazione della matrice
     */
    private int doSumOverH(Matrix m, int i, int j) {
        assert (checkInvariante()) : "Invariante non valida";
        int sumOverH = 0;
        for (int h = 0; h < m.getRighe(); h++) {
            sumOverH = sumOverH + this.getMatrice().get(i).get(h) * m.getMatrice().get(h).get(j);
        }
        return sumOverH;
    }

    /**
     * copiaMatrice: copia la matrice in this
     * @param m3 matrice da copiare
     * @throws incompatibleInsertMatrixException se si prova a copiare una matrice che ha dimensione differenti di this
     */
    private void copiaMatrice(Matrix m3) throws incompatibleInsertMatrixException {
        assert (checkInvariante()) : "Invariante non valida";
        for (int i = 0; i < getRighe(); i++) {
            for (int j = 0; j < getColonne(); j++) {
                insert(i, j, m3.getMatrice().get(i).get(j));
            }
        }
    }

    /**
     * Esegue sulla matrice la traposta
     * MODIFIES: this con la matrice trasposta this
     */
    public void transpose() throws incompatibleInsertMatrixException, dimensionsException {
        doTranspose();
    }

    private void doTranspose() throws incompatibleInsertMatrixException, dimensionsException {
        assert (checkInvariante()) : "Invariante non valida";
        Matrix result = calculateTraspose();
        copiaMatrice(result);
    }

    @NotNull
    private Matrix calculateTraspose() throws dimensionsException, incompatibleInsertMatrixException {
        assert (checkInvariante()) : "Invariante non valida";
        Matrix result = new Matrix(getColonne(), getRighe());
        for (int i = 0; i < result.getRighe(); i++) {
            for (int j = 0; j < result.getColonne(); j++) {
                int datoDaInserire = getMatrice().get(j).get(i);
                result.insert(i, j, datoDaInserire);
            }
        }
        return result;
    }

    /**
     * Esegue la somma tra due matrici
     *
     * @param m la seconda matrice da sommare
     *          MODIFIES: this con la matrice sommata tra le prime due (this + m)
     * @throws incompatibleSumMatrixException le dimensioni delle matrici non sono identiche
     */
    public void add(Matrix m) throws incompatibleSumMatrixException, dimensionsException, incompatibleInsertMatrixException {
        doAdd(m);
    }

    private void doAdd(Matrix m) throws incompatibleSumMatrixException, incompatibleInsertMatrixException, dimensionsException {
        checkSumDimension(m);
        calculateAdd(m);
    }

    private void checkSumDimension(Matrix m) throws incompatibleSumMatrixException {
        if (this.getColonne() != m.getRighe()) {
            throw new incompatibleSumMatrixException("La dimensione delle due matrici e' differente");
        }
    }

    private void calculateAdd(Matrix m) throws dimensionsException, incompatibleInsertMatrixException {
        assert (checkInvariante()) : "Invariante non valida";
        Matrix m3 = new Matrix(getRighe(), getColonne());
        for (int i = 0; i < getRighe(); i++) {
            for (int j = 0; j < getColonne(); j++) {
                int datoDaInserire = getMatrice().get(i).get(j) + m.getMatrice().get(i).get(j);
                m3.insert(i, j, datoDaInserire);
            }
        }

        copiaMatrice(m3);
    }

    /**
     * Moltiplica uno scalare per una matrice
     *
     * @param x scalare da moltiplicare alla matrice
     *          MODIFIES: this moltiplicata allo scalare
     */
    public void scalarProduct(int x) throws incompatibleInsertMatrixException, dimensionsException {
        doScalarProduct(x);
    }

    private void doScalarProduct(int x) throws incompatibleInsertMatrixException, dimensionsException {
        assert (checkInvariante()) : "Invariante non valida";
        Matrix m3 = calculateScalarProduct(x);
        copiaMatrice(m3);
    }

    @NotNull
    private Matrix calculateScalarProduct(int x) throws incompatibleInsertMatrixException, dimensionsException {
        assert (checkInvariante()) : "Invariante non valida";
        Matrix m3 = new Matrix(getRighe(), getColonne());
        for (int i = 0; i < getRighe(); i++) {
            for (int j = 0; j < getColonne(); j++) {
                int datoDaInserire = getMatrice().get(i).get(j) * x;
                m3.insert(i, j, datoDaInserire);
            }
        }
        return m3;
    }

    /**
     * Estrae un vettore in base all'ordinamento dato un indice
     *
     * @param ordinamento enumazione che puo' essere solo rows o columns
     * @param indice      indice in cui andare ad estrarre il vettore
     * @return il vettore di quella riga/colonna
     */
    public Vector<Integer> extractVector(Spaces ordinamento, int indice) {
        Vector<Integer> vettoreDaEstrarre = null;
        vettoreDaEstrarre = doExtractVector(ordinamento, indice, vettoreDaEstrarre);
        return vettoreDaEstrarre;
    }

    @NotNull
    private Vector<Integer> doExtractVector(Spaces ordinamento, int indice, Vector<Integer> vettoreDaEstrarre) {
        assert (checkInvariante()) : "Invariante non valida";
        vettoreDaEstrarre = chooseOrdinamento(ordinamento, indice);
        return vettoreDaEstrarre;
    }

    @NotNull
    private Vector<Integer> chooseOrdinamento(Spaces ordinamento, int indice) {
        assert (checkInvariante()) : "Invariante non valida";
        Vector<Integer> vettoreDaEstrarre;
        if (ordinamento == Spaces.ROW) {
            vettoreDaEstrarre = extract(indice, getRighe(), getColonne());
        } else {
            vettoreDaEstrarre = extract(indice, getColonne(), getRighe());
        }
        return vettoreDaEstrarre;
    }

    @NotNull
    private Vector<Integer> extract(int indice, int disposizione, int disposizioneContraria) {
        assert (checkInvariante()) : "Invariante non valida";
        Vector<Integer> vettoreDaEstrarre;
        vettoreDaEstrarre = new Vector<Integer>(disposizione);
        for (int j = 0; j < disposizioneContraria; j++) {
            vettoreDaEstrarre.addElement(this.getMatrice().get(indice).get(j));
        }
        return vettoreDaEstrarre;
    }

    public enum Spaces {
        ROW, COLUMN
    }

    public void viewMatrix() {
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                System.out.format("%3d ", matrice.get(i).get(j));
            }
            System.out.println();
        }
        System.out.println();
    }

    public int getRighe() {
        return righe;
    }

    public int getColonne() {
        return colonne;
    }

    private Vector<Vector<Integer>> getMatrice() {
        return matrice;
    }

    /**
     * checkInvariante: verifica che i valori della matrice siano conformi alle invarianti
     *
     * @return vero se la matrice rispetta le invarianti altrimenti falso
     */
    private boolean checkInvariante() {
        boolean check = true;
        for (int i = 0; i < getRighe(); i++) {
            if (getMatrice().get(i) == null && getMatrice().get(i).size() != getColonne()  &&
                    getMatrice().size() != getRighe()  &&
                    righe <= 0 && colonne <= 0) {
                check = false;
            }

        }
        return check;
    }
}
