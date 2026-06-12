package niccoloSciucco.entities;

import niccoloSciucco.enums.Genere;
import niccoloSciucco.enums.Piattaforma;
import niccoloSciucco.exceptions.SetAttributeError;

public class VideoGiochi extends Gioco {
    private Piattaforma piattaforma;
    private double durataDiGiocoOre;
    private Genere genere;

    public VideoGiochi(int idGioco, String titolo, int annoDiPubblicazione, double prezzo, Piattaforma piattaforma, double durataDiGiocoOre, Genere genere) {
        super(idGioco, titolo, annoDiPubblicazione, prezzo);
        this.piattaforma = piattaforma;
        this.durataDiGiocoOre = durataDiGiocoOre;
        this.genere = genere;

        if (durataDiGiocoOre <= 0) {
            throw new SetAttributeError("Durata media partita non valida per il gioco " + titolo);
        }
    }
}
