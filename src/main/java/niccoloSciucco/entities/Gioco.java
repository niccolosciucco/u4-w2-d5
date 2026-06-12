package niccoloSciucco.entities;

import niccoloSciucco.exceptions.SetAttributeError;

import java.time.LocalDate;

public abstract class Gioco {
    private int idGioco;
    private String titolo;
    private int annoDiPubblicazione;
    private double prezzo;

    public Gioco(int idGioco, String titolo, int annoDiPubblicazione, double prezzo) {
        this.idGioco = idGioco;
        this.titolo = titolo;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.prezzo = prezzo;

        if (this.annoDiPubblicazione < 1950 || this.annoDiPubblicazione > LocalDate.now().getYear()) {
            throw new SetAttributeError("Anno di pubblicazione non è valido per il gioco '" + this.titolo + "'");
        }
        if (this.prezzo <= 0) {
            throw new SetAttributeError("Il prezzo non è valido per il gioco '" + this.titolo + "'");
        }
    }

    @Override
    public String toString() {
        return "Gioco{" +
                "idGioco=" + idGioco +
                ", titolo='" + titolo + '\'' +
                ", annoDiPubblicazione=" + annoDiPubblicazione +
                ", prezzo=" + prezzo +
                '}';
    }

    public int getIdGioco() {
        return idGioco;
    }

    public String getTitolo() {
        return titolo;
    }
}
