package niccoloSciucco.entities;

import niccoloSciucco.enums.Genere;

public class VideoGiochi {
    private String piattaforma;
    private double durataDiGioco;
    private Genere genere;

    public VideoGiochi(String piattaforma, double durataDiGioco, Genere genere) {
        this.piattaforma = piattaforma;
        this.durataDiGioco = durataDiGioco;
        this.genere = genere;
    }
}
