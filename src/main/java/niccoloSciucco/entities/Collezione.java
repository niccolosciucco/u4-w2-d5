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
        return listaGiochi.stream()
                .filter(gioco -> gioco.getPrezzo() < prezzoMassimo)
                .collect(Collectors.toList());
    }
    //endregion

}
