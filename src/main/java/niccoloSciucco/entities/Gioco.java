package niccoloSciucco.entities;

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
    }
}
