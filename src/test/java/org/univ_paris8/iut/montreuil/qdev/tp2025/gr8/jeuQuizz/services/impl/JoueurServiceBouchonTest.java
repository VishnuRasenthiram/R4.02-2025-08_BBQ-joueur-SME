package org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.services.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.services.interfaces.JoueurInterface;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.services.mocks.*;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.utils.exceptions.*;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class JoueurServiceBouchonTest {
    private static JoueurInterface service;

    @BeforeAll
    public static void init() {
        service = JoueurService.getInstance();
    }

    @Test
    void testAjouterJoueur_PrenomInvalide() {
       // service = new PrenomInvalideBouchon();
        assertThrows(PrenomInvalideException.class, () ->
                service.ajouterJoueur("", "Player123", 2000, Arrays.asList("Football"), 1)
        );
    }
    @Test
    void testAjouterJoueur_PseudoDejaPresent() {
      //  service = new PseudoDejaPresentBouchon();
        assertThrows(PseudoDejaPresentException.class, () ->
                service.ajouterJoueur("Lucas", "Player123", 2000, Arrays.asList("Football"), 1)
        );
    }

    @Test
    void testAjouterJoueur_PseudoInvalide() {
       //  service = new PseudoInvalideBouchon();
        assertThrows(PseudoInvalideException.class, () ->
                service.ajouterJoueur("Lucas", "123Player!", 2000, Arrays.asList("Football"), 1)
        );
    }
    @Test
    void testAjouterJoueur_AnneeInvalide() {
      //   service = new AnneeInvalideBouchon();
        assertThrows(AnneeInvalideException.class, () ->
                service.ajouterJoueur("Lucas", "Player123", 1800, Arrays.asList("Football"), 1)
        );
    }

    @Test
    void testAjouterJoueur_InteretInvalide() {
       // service = new InteretInvalideBouchon();
        assertThrows(InteretInvalideException.class, () ->
                service.ajouterJoueur("Lucas", "Player123", 2000, null, 1)
        );
    }

    @Test
    void testAjouterJoueur_LangueInvalide() {
        // service = new LangueInvalideBouchon();
        assertThrows(LangueInvalideException.class, () ->
                service.ajouterJoueur("Lucas", "Player123", 2000, Arrays.asList("Football"), 999)
        );
    }




}
