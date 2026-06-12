package niccoloSciucco;

import niccoloSciucco.entities.Collezione;
import niccoloSciucco.entities.GiochiDaTavolo;
import niccoloSciucco.entities.Gioco;
import niccoloSciucco.entities.VideoGiochi;
import niccoloSciucco.enums.Genere;
import niccoloSciucco.enums.Piattaforma;
import niccoloSciucco.exceptions.*;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Collezione collezionePrincipale = new Collezione();

        try {
            Scanner scanner = new Scanner(System.in);
            boolean isOver = false;
            while (!isOver) {
                System.out.println(" ");
                System.out.println("Premere 1 per inserire un videogioco. Premere 2 per inserire un gioco da tavola. Premere 0 per terminare l'aggiunta di giochi");

                //region CONTROLLO INPUT INIZIALE
                byte tipoDiGioco = 0;
                try {
                    if (!scanner.hasNextByte()) {
                        throw new IsNotAByte("L'input inserito non è valido!");
                    }

                    tipoDiGioco = scanner.nextByte();

                    if (tipoDiGioco != 0 && tipoDiGioco != 1 && tipoDiGioco != 2) {
                        throw new IsNotAByte("L'input inserito non è valido!");
                    } else if (tipoDiGioco == 0) {
                        isOver = true;
                    }
                } catch (IsNotAByte e) {
                    System.out.println(e.getMessage());
                    continue;
                }

                //endregion

                //region CREAZIONE VIDEOGIOCO
                if (tipoDiGioco == 1) {
                    int id = 0;
                    String titolo = "";
                    int annoDiPubblicazione = 0;
                    double prezzo = 0;
                    Piattaforma piattaforma;
                    double durataDiGiocoOre = 0;
                    Genere genere;

                    System.out.println("Inserire l'id del gioco");
                    try {
                        if (!scanner.hasNextInt()) {
                            throw new IsNotInt("L'ID inserito non è valido");
                        } else {
                            id = scanner.nextInt();
                            scanner.nextLine();
                        }
                    } catch (IsNotInt e) {
                        System.out.println(e.getMessage());
                        scanner.next();
                        continue;
                    }

                    System.out.println("Inserire il titolo del gioco");
                    try {

                        titolo = scanner.nextLine();

                        if (titolo.isEmpty()) {
                            throw new IsNotString("Il titolo inserito non è valido");
                        }
                    } catch (IsNotString e) {
                        System.out.println(e.getMessage());
                        continue;
                    }

                    System.out.println("Inserire l'anno di pubblicazione");
                    try {
                        if (!scanner.hasNextInt()) {
                            throw new IsNotInt("L'anno inserito non è valido");
                        } else {
                            annoDiPubblicazione = scanner.nextInt();
                            scanner.nextLine();
                        }
                    } catch (IsNotInt e) {
                        System.out.println(e.getMessage());
                        scanner.next();
                        continue;
                    }

                    System.out.println("Inserire il prezzo del gioco (es. 29,99)");
                    try {
                        if (!scanner.hasNextDouble()) {
                            throw new IsNotInt("Il prezzo inserito non è valido");
                        } else {
                            prezzo = scanner.nextDouble();
                            scanner.nextLine();
                        }
                    } catch (IsNotInt e) {
                        System.out.println(e.getMessage());
                        scanner.next();
                        continue;
                    }

                    System.out.println("Inserire la piattaforma (Scegli tra: PC, PLAYSTATION, XBOX, NINTENDO, MOBILE)");
                    String piattaformaInput = scanner.nextLine().toUpperCase();
                    try {
                        piattaforma = Piattaforma.valueOf(piattaformaInput);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }

                    System.out.println("Inserire la durata stimata in ore (es. 50,5)");
                    try {
                        if (!scanner.hasNextDouble()) {
                            throw new IsNotInt("La durata inserita non è valida");
                        } else {
                            durataDiGiocoOre = scanner.nextDouble();
                            scanner.nextLine();
                        }
                    } catch (IsNotInt e) {
                        System.out.println(e.getMessage());
                        scanner.next();
                        continue;
                    }

                    System.out.println("Inserire il genere (Scegli tra: AZIONE, AVVENTURA, SPARA_TUTTO, GIOCHI_DI_RUOLO, STRATEGIA, SIMULAZIONE, SPORTIVI, BATTLE_ROYALE, MMO, RPG)");
                    String genereInput = scanner.nextLine().toUpperCase();
                    try {
                        genere = Genere.valueOf(genereInput);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }

                    try {
                        VideoGiochi vg = new VideoGiochi(id, titolo, annoDiPubblicazione, prezzo, piattaforma, durataDiGiocoOre, genere);
                        collezionePrincipale.aggiungiElemento(vg);
                        System.out.println("Videogioco aggiunto con successo!");
                    } catch (Exception e) {
                        System.out.println("Errore durante l'aggiunta: " + e.getMessage());
                    }
                }
                //endregion

                //region CREAZIONE GIOCO DA TAVOLA
                if (tipoDiGioco == 2) {
                    int id = 0;
                    String titolo = "";
                    int annoDiPubblicazione = 0;
                    double prezzo = 0;
                    int numeroDiGiocatori = 0;
                    double durataMediaPartitaMinuti = 0;

                    System.out.println("Inserire l'id del gioco da tavolo");
                    try {
                        if (!scanner.hasNextInt()) {
                            throw new IsNotInt("L'id inserito non è valido");
                        } else {
                            id = scanner.nextInt();
                            scanner.nextLine();
                        }
                    } catch (IsNotInt e) {
                        System.out.println(e.getMessage());
                        scanner.next();
                        continue;
                    }

                    System.out.println("Inserire il titolo del gioco");
                    try {
                        titolo = scanner.nextLine();
                        if (titolo.isEmpty()) {
                            throw new IsNotString("Il titolo inserito non è valido");
                        }
                    } catch (IsNotString e) {
                        System.out.println(e.getMessage());
                        continue;
                    }

                    System.out.println("Inserire l'anno di pubblicazione");
                    try {
                        if (!scanner.hasNextInt()) {
                            throw new IsNotInt("L'anno inserito non è valido");
                        } else {
                            annoDiPubblicazione = scanner.nextInt();
                            scanner.nextLine();
                        }
                    } catch (IsNotInt e) {
                        System.out.println(e.getMessage());
                        scanner.next();
                        continue;
                    }

                    System.out.println("Inserire il prezzo del gioco da tavolo (es. 35,00)");
                    try {
                        if (!scanner.hasNextDouble()) {
                            throw new IsNotInt("Il prezzo inserito non è valido");
                        } else {
                            prezzo = scanner.nextDouble();
                            scanner.nextLine();
                        }
                    } catch (IsNotInt e) {
                        System.out.println(e.getMessage());
                        scanner.next();
                        continue;
                    }

                    System.out.println("Inserire il numero massimo di giocatori");
                    try {
                        if (!scanner.hasNextInt()) {
                            throw new IsNotInt("Il numero di giocatori inserito non è valido");
                        } else {
                            numeroDiGiocatori = scanner.nextInt();
                            scanner.nextLine();
                        }
                    } catch (IsNotInt e) {
                        System.out.println(e.getMessage());
                        scanner.next();
                        continue;
                    }

                    System.out.println("Inserire la durata media di una partita in minuti (es. 120,0)");
                    try {
                        if (!scanner.hasNextDouble()) {
                            throw new IsNotInt("La durata inserita non è valida");
                        } else {
                            durataMediaPartitaMinuti = scanner.nextDouble();
                            scanner.nextLine();
                        }
                    } catch (IsNotInt e) {
                        System.out.println(e.getMessage());
                        scanner.next();
                        continue;
                    }

                    try {
                        GiochiDaTavolo gdt = new GiochiDaTavolo(id, titolo, annoDiPubblicazione, prezzo, numeroDiGiocatori, durataMediaPartitaMinuti);
                        collezionePrincipale.aggiungiElemento(gdt);
                        System.out.println("Gioco da tavolo aggiunto con successo!");
                    } catch (Exception e) {
                        System.out.println("Errore durante l'aggiunta: " + e.getMessage());
                    }
                }
                //endregion
            }

            if (collezionePrincipale.getListaGiochi().size() == 0) {
                System.out.println("Impossibile proseguire con l'esecuzione del programma.");
                System.out.println("Non è stato inserito nessun gioco.");
                System.out.println("Chiusura programma in corso...");
                return;
            }

            boolean stop = false;

            //region ESECUZIONE METODI

            System.out.println("");
            System.out.println("E' possibile eseguire i seguenti metodi: ");
            System.out.println("Ricerca gioco per ID (Inserire codice 1)");
            System.out.println("Ricerca giochi inferiori ad un determinato prezzo (Inserire codice 2)");
            System.out.println("Ricerca giochi per numero di giocatori (Inserire codice 3)");
            System.out.println("Rimuovere gioco per ID (Inserire codice 4)");
            System.out.println("Aggiorna gioco per ID (Inserire codice 5)");
            System.out.println("Stampa statistiche (Inserire codice 6)");
            System.out.println("Per chiudere il programma, premere 0");

            while (!stop) {
                byte metodoDaEseguire = 0;
                try {
                    if (!scanner.hasNextByte()) {
                        throw new IsNotInt("Il codice inserito non è valido");
                    } else {
                        metodoDaEseguire = scanner.nextByte();
                        scanner.nextLine();
                    }
                } catch (IsNotInt e) {
                    System.out.println(e.getMessage());
                    scanner.next();
                    continue;
                }

                if (metodoDaEseguire == 0) {
                    System.out.println("Chiusura Programma in corso...");
                    return;
                }

                switch (metodoDaEseguire) {
                    case 1 -> {
                        System.out.println("Inserire l'ID da cercare");
                        int id = 0;
                        try {
                            if (!scanner.hasNextInt()) {
                                throw new IsNotInt("L'ID inserito non è valido");
                            } else {
                                id = scanner.nextInt();
                                scanner.nextLine();
                            }
                        } catch (IsNotInt e) {
                            System.out.println(e.getMessage());
                            scanner.next();
                            continue;
                        }

                        Gioco gioco = collezionePrincipale.ricercaPerId(id);
                        System.out.println(gioco);
                        System.out.println(" ");
                    }
                    case 2 -> {
                        System.out.println("Inserire un prezzo (es. 29,9)");
                        double prezzo = 0;
                        try {
                            if (!scanner.hasNextDouble()) {
                                throw new IsNotInt("Il prezzo inserito non è valido");
                            } else {
                                prezzo = scanner.nextDouble();
                                scanner.nextLine();
                            }
                        } catch (IsNotInt e) {
                            System.out.println(e.getMessage());
                            scanner.next();
                            continue;
                        }

                        List<Gioco> gioco = collezionePrincipale.ricercaPerPrezzoInferiore(prezzo);

                        if (gioco.isEmpty()) {
                            System.out.println("Nessun gioco trovato sotto " + prezzo + "€");
                        } else {
                            System.out.println("Sono stati trovati " + gioco.size() + " giochi che hanno un prezzo inferiore a " + prezzo + "€:");
                            for (Gioco g : gioco) {
                                System.out.println("- " + g.getTitolo() + " -€" + g.getPrezzo());
                            }
                        }
                    }
                    case 3 -> {
                        System.out.println("Inserire il numero di giocatori");
                        int n = 0;
                        try {
                            if (!scanner.hasNextInt()) {
                                throw new IsNotInt("Il numero di giocatori inserito non è valido");
                            } else {
                                n = scanner.nextInt();
                                scanner.nextLine();
                            }
                        } catch (IsNotInt e) {
                            System.out.println(e.getMessage());
                            scanner.next();
                            continue;
                        }

                        List<Gioco> filtratiPerGiocatori = collezionePrincipale.ricercaPerNumeroDiGiocatori(n);

                        if (filtratiPerGiocatori.isEmpty()) {
                            System.out.println("Nessun gioco da tavolo trovato per " + n + " giocatori");
                        } else {
                            System.out.println("I giochi da tavolo trovati per " + n + " persone sono " + filtratiPerGiocatori.size() + ":");
                            for (Gioco g : filtratiPerGiocatori) {
                                System.out.println("- " + g.getTitolo());
                            }
                        }
                    }
                    case 4 -> {
                        System.out.println("Inserire l'ID del gioco da eliminare");
                        int id = 0;
                        try {
                            if (!scanner.hasNextInt()) {
                                throw new IsNotInt("L'ID inserito non è valido");
                            } else {
                                id = scanner.nextInt();
                                scanner.nextLine();
                            }
                        } catch (IsNotInt e) {
                            System.out.println(e.getMessage());
                            scanner.next();
                            continue;
                        }

                        collezionePrincipale.rimozioneElemento(id);
                    }
                    case 5 -> {
                        System.out.println("Inserire l'ID del gioco da aggiornare");
                        int id = 0;
                        try {
                            if (!scanner.hasNextInt()) {
                                throw new IsNotInt("L'ID inserito non è valido");
                            } else {
                                id = scanner.nextInt();
                                scanner.nextLine();
                            }
                        } catch (IsNotInt e) {
                            System.out.println(e.getMessage());
                            scanner.next();
                            continue;
                        }

                        System.out.println("Inserire il titolo da aggiornare (Inserire il titolo vecchio se non si vuole cambiare)");
                        String titolo = scanner.nextLine();

                        System.out.println("Inserire il prezzo da aggiornare (Inserire il prezzo vecchio se non si vuole cambiare)");
                        double prezzo = 0;
                        try {
                            if (!scanner.hasNextDouble()) {
                                throw new IsNotInt("Il prezzo inserito non è valido");
                            } else {
                                prezzo = scanner.nextDouble();
                                scanner.nextLine();
                            }
                        } catch (IsNotInt e) {
                            System.out.println(e.getMessage());
                            scanner.next();
                            continue;
                        }

                        collezionePrincipale.aggiornaGioco(id, titolo, prezzo);
                        System.out.println(collezionePrincipale);
                    }
                    case 6 -> {
                        System.out.println("Statistiche aggiornate: ");
                        collezionePrincipale.stampaStatistiche();
                    }
                }
            }
            //endregion
        } catch (SetAttributeError e) {
            System.out.println("Errore nella creazione del gioco: " + e.getMessage());
        } catch (GameAlreadyExists e) {
            System.out.println("Errore nell'inserimento del gioco nella lista: " + e.getMessage());
        } catch (IdNotFound e) {
            System.out.println("Errore nella ricerca per ID: " + e.getMessage());
        }
    }
}
