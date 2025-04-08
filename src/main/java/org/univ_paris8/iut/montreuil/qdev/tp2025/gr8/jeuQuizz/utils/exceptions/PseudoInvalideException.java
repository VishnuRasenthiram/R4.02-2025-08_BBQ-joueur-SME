package org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.utils.exceptions;

public class PseudoInvalideException extends AjoutJoueurException {
    public PseudoInvalideException() {
        super("Pseudo invalide : ne doit pas commencer par un chiffre.");
    }
}