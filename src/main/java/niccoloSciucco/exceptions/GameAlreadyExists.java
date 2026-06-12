package niccoloSciucco.exceptions;

public class GameAlreadyExists extends RuntimeException {
    public GameAlreadyExists(String message) {
        super(message);
    }
}
