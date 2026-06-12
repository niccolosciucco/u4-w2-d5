package niccoloSciucco.entities;

import niccoloSciucco.exceptions.SetAttributeError;

public class GiochiDaTavolo extends Gioco {
    private int numeroDiGiocatori;
    private double durataMediaPartitaMinuti;

    public GiochiDaTavolo(int idGioco, String titolo, int annoDiPubblicazione, double prezzo, int numeroDiGiocatori, double durataMediaPartitaMinuti) {
        super(idGioco, titolo, annoDiPubblicazione, prezzo);
        this.numeroDiGiocatori = numeroDiGiocatori;
        this.durataMediaPartitaMinuti = durataMediaPartitaMinuti;

        if (this.numeroDiGiocatori < 2 || this.numeroDiGiocatori > 10) {
            throw new SetAttributeError("Numero di giocatori non valido per il gioco '" + titolo + "'");
        }

        if (this.durataMediaPartitaMinuti <= 0) {
            throw new SetAttributeError("Durata media partita non valida per il gioco '" + titolo + "'");
        }
    }

    public int getNumeroDiGiocatori() {
        return numeroDiGiocatori;
    }

    @Override
    public String toString() {
        return "GiochiDaTavolo{" +
                "numeroDiGiocatori=" + numeroDiGiocatori +
                ", durataMediaPartitaMinuti=" + durataMediaPartitaMinuti +
                '}';
    }
}
