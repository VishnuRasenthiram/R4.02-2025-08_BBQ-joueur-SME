package org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.utils.exceptions;

public class PseudoDejaPresentException extends AjoutJoueurException {
    public PseudoDejaPresentException() {
        super("Pseudo déjà présent.");
    }
}
