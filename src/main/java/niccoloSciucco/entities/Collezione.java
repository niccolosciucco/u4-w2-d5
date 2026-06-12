package niccoloSciucco.entities;

import niccoloSciucco.exceptions.GameAlreadyExists;
import niccoloSciucco.exceptions.IdNotFound;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Collezione {
    private ArrayList<Gioco> listaGiochi;

    public Collezione() {
        this.listaGiochi = new ArrayList<>();
    }

    public ArrayList<Gioco> getListaGiochi() {
        return listaGiochi;
    }

    //METODI

    //region aggiungiELemento
    public void aggiungiElemento(Gioco nuovoGioco) {
        boolean isValid = listaGiochi.stream()
                .anyMatch(gioco -> gioco.getIdGioco() == nuovoGioco.getIdGioco());

        if (isValid) {
            throw new GameAlreadyExists("Impossibile inserire il gioco. L'ID " + nuovoGioco.getIdGioco() + " è già presente!");
        } else {
            listaGiochi.add(nuovoGioco);
            System.out.println("Gioco '" + nuovoGioco.getTitolo() + "' inserito in collezione con successo!");
        }
    }

    //endregion

    //region ricercaPerId
    public Gioco ricercaPerId(int idCercato) {
        List<Gioco> result = listaGiochi.stream()
                .filter(gioco -> gioco.getIdGioco() == idCercato)
                .collect(Collectors.toList());

        if (result.size() > 0) {
            return result.get(0);
        } else {
            throw new IdNotFound("Nessun gioco trovato con l'ID: " + idCercato);
        }
    }
    //endregion

    //region ricercaPerPrezzo
    public List<Gioco> ricercaPerPrezzoInferiore(double prezzoMassimo) {
        List<Gioco> result = listaGiochi.stream()
                .filter(gioco -> gioco.getPrezzo() < prezzoMassimo)
                .collect(Collectors.toList());

        return result;
    }
    //endregion

    //region ricercaPerNumeroDiGiocatori
    public List<Gioco> ricercaPerNumeroDiGiocatori(int giocatoriCercati) {
        List<Gioco> result = listaGiochi.stream()
                .filter(gioco -> gioco instanceof GiochiDaTavolo)
                .map(gioco -> (GiochiDaTavolo) gioco)
                .filter(giocoDaTavolo -> giocoDaTavolo.getNumeroDiGiocatori() == giocatoriCercati)
                .collect(Collectors.toList());

        return result;
    }
    //endregion

    //region rimozioneElemento
    public void rimozioneElemento(int id) {
        Gioco giocoDaRimuovere = ricercaPerId(id);

        listaGiochi.remove(giocoDaRimuovere);
        System.out.println("Gioco '" + giocoDaRimuovere.getTitolo() + "' eliminato con successo!");
    }
    //endregion

    //region Aggiorna
    public void aggiornaGioco(int idDaModificare, String nuovoTitolo, double nuovoPrezzo) {
        Gioco giocoDaModificare = ricercaPerId(idDaModificare);

        String titolo = giocoDaModificare.getTitolo();
        double prezzo = giocoDaModificare.getPrezzo();

        boolean isNewTitle = false;
        boolean isNewPrice = false;

        if (!titolo.equals(nuovoTitolo)) {
            giocoDaModificare.setTitolo(nuovoTitolo);
            isNewTitle = true;
        }
        if (prezzo != nuovoPrezzo) {
            giocoDaModificare.setPrezzo(nuovoPrezzo);
            isNewPrice = true;
        }

        if (!isNewPrice && !isNewTitle) {
            System.out.println("Il gioco non è stato aggiornato, i dati passati non erano aggiornati");
            return;
        }

        System.out.println("Gioco con ID " + idDaModificare + " aggiornato con successo");

        if (isNewPrice && isNewTitle) {
            System.out.println("Il nuovo titolo è: " + nuovoTitolo);
            System.out.println("Il nuovo prezzo è: " + nuovoPrezzo);
            return;
        }

        if (isNewPrice) {
            System.out.println("Il nuovo titolo è: " + nuovoTitolo);
        } else {
            System.out.println("Il nuovo prezzo è: " + nuovoPrezzo);
        }
    }
    //endregion

    //region stampa
    public void stampaStatistiche() {
        long totaleVideoGiochi = listaGiochi.stream()
                .filter(gioco -> gioco instanceof VideoGiochi)
                .count();
        System.out.println("Numero totale di Videogiochi: " + totaleVideoGiochi);

        long totaleGiochiDaTavolo = listaGiochi.stream()
                .filter(gioco -> gioco instanceof GiochiDaTavolo)
                .count();
        System.out.println("Numero totale di Giochi da Tavolo: " + totaleGiochiDaTavolo);


        double prezzoPiuAlto = listaGiochi.stream()
                .mapToDouble(Gioco::getPrezzo)
                .max().getAsDouble();

        Gioco giocoPiuCaro = listaGiochi.stream()
                .filter(gioco -> gioco.getPrezzo() == prezzoPiuAlto)
                .findFirst().get();

        System.out.println("Gioco più costoso: " + giocoPiuCaro.getTitolo() + " (" + giocoPiuCaro.getPrezzo() + "€)");


        double mediaPrezzi = listaGiochi.stream()
                .mapToDouble(gioco -> gioco.getPrezzo())
                .average()
                .getAsDouble();

        System.out.println("Media dei prezzi di tutti i giochi: " + mediaPrezzi + "€");
    }
    //endregion


    @Override
    public String toString() {
        return "Collezione{" +
                "listaGiochi=" + listaGiochi +
                '}';
    }
}