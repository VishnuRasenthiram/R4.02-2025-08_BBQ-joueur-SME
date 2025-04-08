package org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.entities.dto;

import java.util.List;

class StatsDTO {
    private int nombreParties;
    private int nombreBonnesReponses;
    private double moyenne;
    private long dureeMoyenne;
    private List<ScoreDTO> historique;

    public StatsDTO() {
        this.nombreParties = 0;
        this.nombreBonnesReponses = 0;
        this.moyenne = 0.0;
        this.dureeMoyenne = 0;
        this.historique = new java.util.ArrayList<>();
    }
}

