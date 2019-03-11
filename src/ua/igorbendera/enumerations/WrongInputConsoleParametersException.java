package ua.igorbendera.enumerations;

public class WrongInputConsoleParametersException extends Exception {
    private String message;

    WrongInputConsoleParametersException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
