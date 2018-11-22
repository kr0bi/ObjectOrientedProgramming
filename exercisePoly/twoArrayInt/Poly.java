package objOrientProgr.exercisePoly.twoArrayInt;

import objOrientProgr.exercisePoly.twoArrayInt.exceptions.degreeNotFoundException;
import objOrientProgr.exercisePoly.twoArrayInt.exceptions.negativeExpException;

public class Poly {
    private int[] coefficients;
    private int[] exponents;

    /**
     * Poly: Crea il polinomio di grado 1 con coefficiente zero
     */
    public Poly (){
        coefficients = new int[1];
        exponents = new int[1];
    }

    /**
     * Poly: Crea un polinomio con un certo coefficiente rispetto a un certo esponente
     * @param newCoeff coefficiente da mettere nel polinomio
     * @param newExponent grado del coefficiente da mettere nel polinomio
     * @throws negativeExpException tira un eccezione se l'esponente che si prova ad aggiungere e' negativo
     */
    public Poly (int newCoeff, int newExponent) throws negativeExpException {
        if (newExponent < 0 ) {
            throw new negativeExpException("Errore: Esponente negativo");
        }
        exponents = new int[2];
        coefficients = new int[2];
        coefficients[0] = newCoeff;
        exponents[0] = newExponent;
    }
    private Poly (int[] newCoefficients, int[] newExponents){
        if (newCoefficients == null || newExponents == null){
            throw new NullPointerException("Coefficienti o esponenti nulli");
        }
        exponents = newExponents;
        coefficients = newCoefficients;
    }

    public Poly sum(int newCoeff, int newExponent) throws negativeExpException {
        if (newExponent < 0) {
            throw new negativeExpException("Errore: Esponente negativo");
        }
        int[] newExponents = null;
        int[] newCoefficients = null;
        Poly newPoly = null;
        if (newCoeff != 0 || newExponent != 0) {
            if (newExponentFound(newExponent)) {
                newExponents = new int[this.exponents.length + 1];
                newCoefficients = new int[this.coefficients.length + 1];

                copiaArray(newExponents, this.exponents);
                newExponents[this.exponents.length] = newExponent;
                copiaArray(newCoefficients, this.coefficients);
                newCoefficients[this.coefficients.length] = newCoeff;
            } else {
                newExponents = new int[this.exponents.length];
                newCoefficients = new int[this.coefficients.length];

                copiaArray(newExponents, this.exponents);
                copiaArray(newCoefficients, this.coefficients);

                for (int i = 0; i < this.exponents.length; i++) {
                    if (this.exponents[i] == newExponent) {
                        newCoefficients[i] = newCoefficients[i] + newCoeff;
                    }
                }
            }
            newPoly = new Poly(newCoefficients, newExponents);
            newPoly = newPoly.cleanPoly();
            return newPoly;
        }
        /*newPoly = new Poly(newCoefficients, newExponents);
        newPoly = newPoly.cleanPoly();
        //newPoly = newPoly.remuoveZeroes();*/
        return this;
    }
    private boolean newExponentFound(int newExponent){
        boolean check = true;
        for (int i=0; i<this.exponents.length; i++){
            if (newExponent == this.exponents[i]){
                check = false;
            }
        }
        return check;
    }

    /**
     * add: somma un polinomio al polinomio corrente
     * @param theSecondPoly il secondo polinomio da sommare
     * @return somma dei due polinomi
     */
    public Poly add(Poly theSecondPoly) throws negativeExpException{
        Poly newPoly = new Poly(this.coefficients, this.exponents);
        for (int i=0; i<theSecondPoly.exponents.length; i++){
            newPoly = newPoly.sum(theSecondPoly.coefficients[i], theSecondPoly.exponents[i]);
        }
        newPoly = newPoly.remuoveZeroes();
        return newPoly;

    }
    private Poly cleanPoly (){
        Poly newPoly = new Poly(this.coefficients, this.exponents);
        for (int i=0; i<this.exponents.length; i++){
            int indexMin = i;
            for (int j=i; j<this.exponents.length; j++){
                if (newPoly.exponents[j]>newPoly.exponents[indexMin]){
                    indexMin = j;
                }
            }
            int temp = newPoly.exponents[indexMin];
            newPoly.exponents[indexMin] = newPoly.exponents[i];
            newPoly.exponents[i] = temp;

            temp = newPoly.coefficients[indexMin];
            newPoly.coefficients[indexMin] = newPoly.coefficients[i];
            newPoly.coefficients[i] = temp;
        } //gli esponenti e i coefficienti dovrebbero essere ordinati
        return newPoly;
    }

    private void copiaArray (int[] daCopiare, int[] copiare){
        for (int i=0; i<copiare.length; i++){
            daCopiare[i] = copiare[i];
        }
        //System.arraycopy(copiare, 0, daCopiare, 0, copiare.length);
    }

    /**
     * multiply: moltiplica un polinomio al polinomio corrente
     * @param polyDaMoltiplicare polinomio da moltiplicare al polinomio
     * @return un nuovo polinomio con il dato moltiplicato
     */
    public Poly multiply (Poly polyDaMoltiplicare) throws negativeExpException{
        Poly polyIniziale = new Poly(this.coefficients, this.exponents);
        int[]  nuoviCoefficienti = new int[polyIniziale.coefficients.length*polyDaMoltiplicare.coefficients.length];
        int[]  nuoviEsponenti = new int[polyIniziale.exponents.length*polyDaMoltiplicare.exponents.length];
        Poly newPoly = new Poly();
        int k = 0;
        for (int i=0; i<polyIniziale.exponents.length; i++){
            for (int j=0; j<polyDaMoltiplicare.exponents.length; j++){
                nuoviCoefficienti[k] = polyIniziale.coefficients[i] * polyDaMoltiplicare.coefficients[j];
                nuoviEsponenti[k] = polyIniziale.exponents[i] + polyDaMoltiplicare.exponents[j];
                if (nuoviCoefficienti[k] != 0) {
                    newPoly = newPoly.sum(nuoviCoefficienti[k], nuoviEsponenti[k]);
                }
                k++;
            }
        }
        newPoly = newPoly.remuoveZeroes();
        return newPoly;
    }

    /**
     * maxDegree: restituisce il massimo grado del polinomio
     * @return il massimo grado del polinomio
     */
    public int degree (){
        return this.exponents[0];
    }

    /**
     * degreeCoeff: restituisce il grado del coefficiente passato
     * @param grado coefficiente di cui trovare il grado
     * @return il coefficiente del grado richiesto
     * @throws degreeNotFoundException tira l'eccezione se il grado non esiste nel polinomio
     */
    public int coeff(int grado) throws degreeNotFoundException {
        int result = -1;
        for (int i=0; i<this.exponents.length; i++){
            if (grado == this.exponents[i]){
                result = this.coefficients[i];
            }
        }
        if (result==-1){
            throw new degreeNotFoundException("Grado non trovato");
        } else {
            return result;
        }

    }
    public Poly minus() throws negativeExpException{
        Poly newPoly = new Poly();
        for (int i=0; i<this.exponents.length; i++){
            newPoly = newPoly.sum(-1*this.coefficients[i], this.exponents[i]);
        }
        return newPoly;
    }
    public boolean equals (Poly p2) throws negativeExpException{
        boolean check = false;
        Poly p1 = this;
        Poly p3 = p1.add(p2);
        if (p3.degree()==0){
            check = true;
        }
        return check;

    }

    public void viewPoly () {
        Poly newPoly = new Poly(this.coefficients, this.exponents);

        int dimensione = newPoly.exponents.length;
        if (dimensione == 1){
            System.out.format("%d * x^[ %d ]", newPoly.coefficients[0], newPoly.exponents[0]);
        } else {
            for (int i = 0; i < dimensione; i++) {
                if (i == dimensione-1) {
                    System.out.format("%d * x^[ %d ]", newPoly.coefficients[i], newPoly.exponents[i]);
                } else {
                    System.out.format("%d * x^[ %d ] + ", newPoly.coefficients[i], newPoly.exponents[i]);
                }
            }
        }
        System.out.println();
    }
    private Poly remuoveZeroes() throws negativeExpException{
        Poly newPolySenzaZeri = new Poly();
        for (int i=0; i<this.coefficients.length; i++){
            if (this.coefficients[i] != 0){
                newPolySenzaZeri = newPolySenzaZeri.sum(this.coefficients[i], this.exponents[i]);
            }
        }
        return newPolySenzaZeri;
    }
}
