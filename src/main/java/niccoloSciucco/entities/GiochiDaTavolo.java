package niccoloSciucco.entities;

public class GiochiDaTavolo extends Gioco {
    private int numeroDiGiocatori;
    private double durataMediaPartita;

    public GiochiDaTavolo(int idGioco, String titolo, int annoDiPubblicazione, double prezzo, int numeroDiGiocatori, double durataMediaPartita) {
        super(idGioco, titolo, annoDiPubblicazione, prezzo);
        this.numeroDiGiocatori = numeroDiGiocatori;
        this.durataMediaPartita = durataMediaPartita;
    }
}
