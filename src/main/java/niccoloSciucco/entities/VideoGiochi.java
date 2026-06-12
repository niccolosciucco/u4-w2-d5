package niccoloSciucco.entities;

import niccoloSciucco.enums.Genere;

public class VideoGiochi extends Gioco {
    private String piattaforma;
    private double durataDiGioco;
    private Genere genere;

    public VideoGiochi(int idGioco, String titolo, int annoDiPubblicazione, double prezzo, String piattaforma, double durataDiGioco, Genere genere) {
        super(idGioco, titolo, annoDiPubblicazione, prezzo);
        this.piattaforma = piattaforma;
        this.durataDiGioco = durataDiGioco;
        this.genere = genere;
    }
}
