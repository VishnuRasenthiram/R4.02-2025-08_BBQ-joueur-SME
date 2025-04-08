package org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.services.mocks;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.services.interfaces.JoueurInterface;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.utils.exceptions.*;

import java.util.List;

public class PseudoDejaPresentBouchon implements JoueurInterface {
    @Override
    public JoueurDTO ajouterJoueur(String prenom, String pseudo, int anneeNaissance, List<String> centresInterets, int langue) throws PseudoDejaPresentException, PseudoInvalideException, PrenomInvalideException, AnneeInvalideException, InteretInvalideException, LangueInvalideException {
        throw new PseudoDejaPresentException();
    }
}
