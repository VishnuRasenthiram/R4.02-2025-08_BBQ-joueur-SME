package org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.utils.exceptions;

public class AnneeInvalideException extends AjoutJoueurException {
    public AnneeInvalideException() {
        super("Année de naissance invalide.");
    }
}