package niccoloSciucco;

import niccoloSciucco.entities.Collezione;
import niccoloSciucco.entities.GiochiDaTavolo;
import niccoloSciucco.entities.Gioco;
import niccoloSciucco.entities.VideoGiochi;
import niccoloSciucco.enums.Genere;
import niccoloSciucco.enums.Piattaforma;
import niccoloSciucco.exceptions.GameAlreadyExists;
import niccoloSciucco.exceptions.IdNotFound;
import niccoloSciucco.exceptions.SetAttributeError;

public class Application {

    public static void main(String[] args) {
        Collezione miaCollezione = new Collezione();

        try {
            VideoGiochi vg1 = new VideoGiochi(1, "The Witcher 3", 2015, 29.99, Piattaforma.PC, 150.5, Genere.RPG);
            GiochiDaTavolo gdt1 = new GiochiDaTavolo(2, "Risiko", 1957, 35.00, 6, 120.0);

            miaCollezione.aggiungiElemento(vg1);
            miaCollezione.aggiungiElemento(gdt1);

            VideoGiochi duplicato = new VideoGiochi(3, "GTA V", 2013, 19.99, Piattaforma.XBOX, 80.0, Genere.AZIONE);
            miaCollezione.aggiungiElemento(duplicato);

            Gioco prova = miaCollezione.ricercaPerId(99);

        } catch (SetAttributeError e) {
            System.out.println("Errore nella creazione del gioco: " + e.getMessage());
        } catch (GameAlreadyExists e) {
            System.out.println("Errore nell'inserimento del gioco nella lista: " + e.getMessage());
        } catch (IdNotFound e) {
            System.out.println("Errore nella ricerca per ID: " + e.getMessage());
        }
    }
}
