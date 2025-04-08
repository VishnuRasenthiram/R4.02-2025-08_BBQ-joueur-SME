package org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.entities.dto;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.utils.enums.Langue;

import java.util.List;

public class JoueurDTO {
    private final String prenom;
    private final String pseudo;
    private final int anneeNaissance;
    private List<String> centresInterets;
    private final Langue languePreferee;
    private StatsDTO stats;

    public JoueurDTO(String prenom, String pseudo, int anneeNaissance, List<String> centresInterets, Langue languePreferee) {
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.anneeNaissance = anneeNaissance;
        this.centresInterets = centresInterets;
        this.languePreferee = languePreferee;
        this.stats = new StatsDTO();
    }

    public String getPrenom() { return prenom; }
    public String getPseudo() { return pseudo; }
    public int getAnneeNaissance() { return anneeNaissance; }
    public List<String> getCentresInterets() { return centresInterets; }
    public Langue getLanguePreferee() { return languePreferee; }
    public StatsDTO getStats() { return stats; }
}
