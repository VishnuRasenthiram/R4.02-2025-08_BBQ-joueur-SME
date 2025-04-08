package org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.services.impl;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.services.interfaces.JoueurInterface;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.utils.enums.Langue;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.utils.exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class JoueurService implements JoueurInterface {

    private static JoueurService instance; // Singleton instance
    private final List<JoueurDTO> joueurs = new ArrayList<>();


    private JoueurService() {
    }


    public static JoueurService getInstance() {
        if (instance == null) {
            instance = new JoueurService();
        }
        return instance;
    }

    public JoueurDTO ajouterJoueur(String prenom, String pseudo, int anneeNaissance, List<String> centresInterets, int langue) throws LangueInvalideException, InteretInvalideException, AnneeInvalideException, PrenomInvalideException, PseudoInvalideException, PseudoDejaPresentException {

        if (joueurs.stream()
                .map(JoueurDTO::getPseudo)
                .anyMatch(x -> x.equals(pseudo))) {
            throw new PseudoDejaPresentException();
        }
        if (!pseudo.matches("^[A-Za-z][A-Za-z0-9_\\-]*$")) {
            throw new PseudoInvalideException();
        }
        if (prenom == null || prenom.trim().isEmpty()) {
            throw new PrenomInvalideException();
        }
        if (anneeNaissance < 1900 || anneeNaissance > 2025) {
            throw new AnneeInvalideException();
        }
        if (centresInterets == null || centresInterets.isEmpty()) {
            throw new InteretInvalideException();
        }
        if (langue < 1 || langue > Langue.values().length) {
            throw new LangueInvalideException();
        }

        Langue langueEnum = Langue.values()[langue - 1];
        JoueurDTO joueur = new JoueurDTO(prenom, pseudo, anneeNaissance, centresInterets, langueEnum);

        joueurs.add(joueur);
        return joueur;
    }

    @Override
    public Boolean supprimerJoueur(String prenom) throws SupprimerJoueurException {
        if (prenom == null || prenom.trim().isEmpty()) {
            throw new SupprimerJoueurException("Le prénom ne peut pas être vide.");
        }

        boolean removed = joueurs.removeIf(j -> j.getPrenom().equalsIgnoreCase(prenom));

        if (!removed) {
            throw new SupprimerJoueurException("Le joueur avec le prénom " + prenom + " n'existe pas.");
        }

        return true;
    }

    @Override
    public ArrayList<JoueurDTO> listerJoueur() {
        return new ArrayList<>(joueurs);
    }
    public void reset() {
        joueurs.clear();
    }
}
