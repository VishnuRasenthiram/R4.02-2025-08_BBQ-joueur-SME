package org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.utils.exceptions.*;

import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.*;

class JoueurServiceTest {
    private JoueurService joueurService;

    @BeforeEach
    void setUp() {
        joueurService = new JoueurService();
    }


    @Test
    void testAjouterJoueur_Valide() throws Exception {
        JoueurDTO joueur = joueurService.ajouterJoueur(
                "Lucas", "Player123", 2000, Arrays.asList("Football", "Jeux vidéo"), 1);

        assertNotNull(joueur);
        assertEquals("Lucas", joueur.getPrenom());
        assertEquals("Player123", joueur.getPseudo());
        assertEquals(2000, joueur.getAnneeNaissance());
        assertEquals(2, joueur.getCentresInterets().size());
    }

    @Test
    void testAjouterPlusieursJoueurs() throws Exception {
        JoueurDTO joueur1 = joueurService.ajouterJoueur(
                "Lucas", "Player123", 1999, Arrays.asList("Football"), 1);
        JoueurDTO joueur2 = joueurService.ajouterJoueur(
                "Emma", "GamerGirl", 2002, Arrays.asList("Echecs", "Musique"), 2);

        assertNotNull(joueur1);
        assertNotNull(joueur2);
        assertNotEquals(joueur1.getPseudo(), joueur2.getPseudo());
    }



    @Test
    void testAjouterJoueur_PseudoDejaExistant() throws Exception {
        joueurService.ajouterJoueur("Lucas", "Player123", 2000, Arrays.asList("Football"), 1);


        assertThrows(PseudoDejaPresentException.class, () ->
                joueurService.ajouterJoueur("Lucas", "Player123", 1998, Arrays.asList("Football"), 1)
        );
    }

    @Test
    void testAjouterJoueur_PseudoInvalide() {
        assertThrows(PseudoInvalideException.class, () ->
                joueurService.ajouterJoueur("Lucas", "123Player!", 2000, Arrays.asList("Football"), 1)
        );
    }

    @Test
    void testAjouterJoueur_PrenomInvalide() {
        assertThrows(PrenomInvalideException.class, () ->
                joueurService.ajouterJoueur("", "Player123", 2000, Arrays.asList("Football"), 1)
        );

        assertThrows(PrenomInvalideException.class, () ->
                joueurService.ajouterJoueur("   ", "Player123", 2000, Arrays.asList("Football"), 1)
        );
    }

    @Test
    void testAjouterJoueur_AnneeInvalide() {
        assertThrows(AnneeInvalideException.class, () ->
                joueurService.ajouterJoueur("Lucas", "Player123", 1800, Arrays.asList("Football"), 1)
        );

        assertThrows(AnneeInvalideException.class, () ->
                joueurService.ajouterJoueur("Lucas", "Player123", 2030, Arrays.asList("Football"), 1)
        );
    }

    @Test
    void testAjouterJoueur_CentresInteretsInvalide() {
        assertThrows(InteretInvalideException.class, () ->
                joueurService.ajouterJoueur("Lucas", "Player123", 2000, null, 1)
        );

        assertThrows(InteretInvalideException.class, () ->
                joueurService.ajouterJoueur("Lucas", "Player123", 2000, Arrays.asList(), 1)
        );
    }

    @Test
    void testAjouterJoueur_LangueInvalide() {
        assertThrows(LangueInvalideException.class, () ->
                joueurService.ajouterJoueur("Lucas", "Player123", 2000, Arrays.asList("Football"), 999)
        );

        assertThrows(LangueInvalideException.class, () ->
                joueurService.ajouterJoueur("Lucas", "Player123", 2000, Arrays.asList("Football"), 0)
        );
    }
}
