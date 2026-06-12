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

import java.util.List;

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

            //RICERCA PER ID
            Gioco prova = miaCollezione.ricercaPerId(99);

            //RICERCA PER PREZZO
            double budget = 32.00;
//            List<Gioco> prova = miaCollezione.ricercaPerPrezzoInferiore(budget);
//
//            if (prova.isEmpty()) {
//                System.out.println("Nessun gioco trovato sotto " + budget + "€");
//            } else {
//                System.out.println("Sono stati trovati " + prova.size() + " giochi che hanno un prezzo inferiore a " + budget + "€:");
//                for (Gioco g : prova) {
//                    System.out.println("- " + g.getTitolo() + " -€" + g.getPrezzo());
//                }
//            }

            //RICERCA PER NUMERO GIOCATORI
            int nGiocatori = 6;
            List<Gioco> filtratiPerGiocatori = miaCollezione.ricercaPerNumeroDiGiocatori(nGiocatori);

            if (filtratiPerGiocatori.isEmpty()) {
                System.out.println("Nessun gioco da tavolo trovato per " + nGiocatori + " giocatori");
            } else {
                System.out.println("I giochi da tavolo trovati per " + nGiocatori + " persone sono " + filtratiPerGiocatori.size() + ":");
                for (Gioco g : filtratiPerGiocatori) {
                    System.out.println("- " + g.getTitolo());
                }
            }

            //RIMOZIONE PER ID
//            miaCollezione.rimozioneElemento(1);
//            miaCollezione.rimozioneElemento(99);

            //AGGIORNAMENTO
//            miaCollezione.aggiornaGioco(2, "Risiko 2", 49.99);
//            System.out.println(miaCollezione);


            //STAMPA STATISTICHE
            miaCollezione.stampaStatistiche();
        } catch (SetAttributeError e) {
            System.out.println("Errore nella creazione del gioco: " + e.getMessage());
        } catch (GameAlreadyExists e) {
            System.out.println("Errore nell'inserimento del gioco nella lista: " + e.getMessage());
        } catch (IdNotFound e) {
            System.out.println("Errore nella ricerca per ID: " + e.getMessage());
        }
    }
}
