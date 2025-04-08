package org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.services.interfaces;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.utils.exceptions.*;

import java.util.ArrayList;
import java.util.List;

public interface JoueurInterface {
    JoueurDTO ajouterJoueur(String prenom, String pseudo, int anneeNaissance, List<String> centresInterets, int langue)
            throws PseudoDejaPresentException, PseudoInvalideException, PrenomInvalideException,
            AnneeInvalideException, InteretInvalideException, LangueInvalideException;

    Boolean supprimerJoueur(String prenom) throws SupprimerJoueurException;

    ArrayList<JoueurDTO> listerJoueur();
}
