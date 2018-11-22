package objOrientProgr.exercisePoly.vectorPoly;

import java.util.Iterator;
import java.util.Objects;
import java.util.Vector;
import objOrientProgr.exercisePoly.vectorPoly.exceptions.*;

public class Poly {

    /**
     * Questa classe fornisce un ADT per i polinomi
     * Poly e' immutabile, unbounded
     * Class overview:
     *  TODO
     */

    /**
     * ABSTRACT Function:
     * TODO
     * INVARIANT:
     * l'indice del termine corrisponde con il suo grado
     *
     */

    private Vector<PolynomialTerms> polynomial;

    /**
     * a record that represents a single term of the poly
     * c * x^e
     */
    private class PolynomialTerms {
        int coeff;
        int exponent;

        /**
         * PolynomialTerms: crea un termine del polinomio con coefficiente c ed esponente e
         * @param c coefficiente
         * @param e esponente
         */
        PolynomialTerms(int c, int e){
            this.coeff = c;
            this.exponent = e;

        }

        /**
         * PolynomialTerms: crea un termine del polinomio tramite un termine polinomiale gia' esistente
         * @param ce termine polinomiale da cui prendere il coeff ed exponent
         */
        PolynomialTerms(PolynomialTerms ce){
            ce = Objects.requireNonNull(ce);
            this.coeff = ce.coeff;
            this.exponent = ce.exponent;
        }
    }

    /**
     * Poly: crea il polinomio zero
     */
    public Poly() {
        doPoly(0,0);
    }


    /**
     * Poly: crea il polinomio con coefficiente c e esponente n
     * @param c coefficiente del polinomio
     * @param n esponente del polinomio
     */
    public Poly(int c, int n) throws NegativeExponentException{
        checkExponent(n);
        doPoly(c, n);

    }

    /**
     * doPoly: crea un nuovo polinomio con il monomio da aggiungere piu' tutti i restanti esponenti fino a zero
     * @param c coefficiente da aggiungere al polinomio
     * @param n esponente da aggiungere al polinomio
     */
    private void doPoly(int c, int n) {
        this.polynomial = new Vector<PolynomialTerms>();
        for (int i=0; i<n; i++) {
            this.polynomial.addElement(new PolynomialTerms(0,i));
        }
        this.polynomial.addElement(new PolynomialTerms(c,n));
    }

    /**
     * checkExponent: verifica se l'esponente e' negativo
     * @param n esponente da controllare
     * @throws NegativeExponentException tira un eccezione se l'esponente e' negativo
     */
    private void checkExponent(int n) throws NegativeExponentException {
        if (n < 0 ){
            throw new NegativeExponentException("Impossibile instanziare un polinomio con esponente negativo");
        }
    }

    /**
     * COPY CONSTRUCTOR
     * Poly: crea il polinomio con coefficienti del polinomio p ed esponenti del polinomio p
     * @param p polinomio con coeff ed esponenti
     */
    public Poly (Poly p){
        Objects.nonNull(p);
        this.polynomial = new Vector<PolynomialTerms>();
        for (int i=0; i<p.polynomial.size(); i++){
            this.polynomial.add(p.polynomial.get(i));
        }
    }

    /**
     * add: somma al polinomio esistente un nuovo polinomio
     * @param secondoPoly polinomio da sommare
     * @return un nuovo polinomio che e' il risultato della somma dei due polinomi
     */
    public Poly add (Poly secondoPoly){
        Objects.requireNonNull(secondoPoly);
        Poly primoPoly =  this;
        Poly result = null;
        if (primoPoly.isGreaterThan(secondoPoly)) {
            result = new Poly(primoPoly);
            sommaPrimiTermini(secondoPoly, primoPoly, result);
            copiaTerminiRestanti(secondoPoly, primoPoly, result);
        } else {
            result = new Poly(secondoPoly);
            sommaPrimiTermini(primoPoly, secondoPoly, result);
            copiaTerminiRestanti(primoPoly, secondoPoly, result);
        }
        return result;
    }
    private boolean isGreaterThan (Poly secondoPoly){
        boolean check = false;
        if (this.degree() >= secondoPoly.degree()){
            check = true;
        }
        return check;
    }

    private void copiaTerminiRestanti(Poly secondoPoly, Poly primoPoly, Poly result) {
        for (int i=secondoPoly.polynomial.size(); i<primoPoly.polynomial.size(); i++){
            result.polynomial.setElementAt(primoPoly.polynomial.elementAt(i), i);
        }
    }

    private void sommaPrimiTermini(Poly secondoPoly, Poly primoPoly, Poly result) {
        for (int i = 0; i < secondoPoly.polynomial.size(); i++) {
            int b = primoPoly.polynomial.elementAt(i).coeff + secondoPoly.polynomial.elementAt(i).coeff;
            PolynomialTerms somma = new PolynomialTerms(b, i);
            result.polynomial.setElementAt(somma, i);
        }
    }

    /**
     * multiply: moltiplica al polinomio esistente un nuovo polinomio
     * @param p polinomio da moltiplicare
     * @return un nuovo polinomio che e' il risultato della moltiplicazione dei due polinomi
     */
    public Poly multiply (Poly p)throws NegativeExponentException{
        Poly nuovoPoly = null;
        if (this.degree() == 0 || p.degree() == 0) {
            nuovoPoly = new Poly(0, this.degree()+p.degree());
            doMultiply(p, nuovoPoly);
        } else {
            nuovoPoly = new Poly(0, this.degree()*p.degree());
            doMultiply(p, nuovoPoly);
        }
        return nuovoPoly;
    }

    private void doMultiply(Poly p, Poly nuovoPoly) {
        for (int i=0; i<this.polynomial.size(); i++){ // 1
            for(int j=0; j<p.polynomial.size(); j++){ // 0
                int coeffCurrent = this.polynomial.elementAt(i).coeff * p.polynomial.elementAt(j).coeff + nuovoPoly.polynomial.elementAt(i).coeff;
                int expCurrent = this.polynomial.elementAt(i).exponent*p.polynomial.elementAt(j).exponent;
                nuovoPoly.polynomial.setElementAt(new PolynomialTerms(coeffCurrent, expCurrent), expCurrent);
            }
        }
    }

    /**
     * degree: trova l'esponente piu' alto del polinomio
     * @return il grado del polinomio
     */
    public int degree (){
        return this.polynomial.size()-1;
    }

    /**
     * coefficient: trova il coefficiente con esponente n
     * @param n il grado del coefficiente da trovare
     * @return il coefficiente dell'esponente n
     * @throws degreeNotFoundException se il grado non esiste tira un eccezione
     */
    public int coefficient(int n) throws degreeNotFoundException{
        if (n > this.polynomial.size()-1){
            throw new degreeNotFoundException("L'esponente non esiste");
        }
        int result = -1;
        Iterator<PolynomialTerms> it = this.polynomial.iterator();
        while (it.hasNext()){
            PolynomialTerms terms = it.next();
            if (terms.exponent==n){
                result = terms.coeff;
            }
        }
        return result;
    }

    /**
     * minus: nega il polinomio (-1 * p)
     * @return un nuovo polinomio a cui viene eseguito minus
     */
    public Poly minus() {
        Poly nuovoPoly = new Poly(this);
        Iterator<PolynomialTerms> it = nuovoPoly.polynomial.iterator();
        int i = 0;
        while (it.hasNext()) {
            PolynomialTerms terms = it.next();
            nuovoPoly.polynomial.setElementAt(new PolynomialTerms(terms.coeff * -1, terms.exponent), terms.exponent);
        }
        return nuovoPoly;
    }

    /**
     * differentiate: derivata del polinomio
     * @return un nuovo polinomio che e' il risultato della derivata del polinomio di this
     */
    public Poly differentiate () throws NegativeExponentException{
        Poly nuovoPoly = new Poly(this);
        Iterator<PolynomialTerms> terms = this.polynomial.iterator();
        terms.next();
        terms.remove();
        int i = 0;
        while (terms.hasNext()){
            PolynomialTerms current = terms.next();
            int coeff = current.coeff*current.exponent;
            int esponent = current.exponent-1;
            nuovoPoly.polynomial.setElementAt(new PolynomialTerms(coeff, esponent), i);
            i++;
        }
        nuovoPoly.polynomial.remove(nuovoPoly.polynomial.size()-1);
        return nuovoPoly;
    }

    /**
     * toString: visualizzazione del polinomio
     * @return la rappresentazione in stringa del polinomio
     */
    public String toString (){
        String daStampare = "";
        for (int i=0; i<this.polynomial.size(); i++){
            if (this.polynomial.size() == 1){
                daStampare = "(" + this.polynomial.get(i).coeff + "x^" + this.polynomial.get(i).exponent + ")";
            } else if(i == this.polynomial.size()-1){
                daStampare = daStampare + "(" + this.polynomial.get(i).coeff + "x^" + this.polynomial.get(i).exponent + ")";
            } else {
                daStampare = daStampare + "(" + this.polynomial.get(i).coeff + "x^" + this.polynomial.get(i).exponent + ") + ";
            }
        }
        return daStampare;
    }

    /**
     * equals: confronta se due polinomi sono identici
     * @param poly polinomio da confrontrare
     * @return ritorna true se il polinomio e' uguale, false altrimenti
     */
    public boolean equals (Poly poly){
        Objects.requireNonNull(poly);
        boolean check = true;
        if (this.degree() == poly.degree()){
            for (int i = 0; i<this.polynomial.size(); i++){
                if (this.polynomial.elementAt(i).coeff == poly.polynomial.elementAt(i).coeff){
                    check = check && true;
                } else {
                    check = false;
                }
            }
        } else {
            check = false;
        }
        return check;
    }
    public void viewPoly (){
        System.out.println(this.toString());
    }


}
