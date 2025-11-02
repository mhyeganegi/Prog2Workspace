package exceptions;

/**
 * Unchecked Exception fuer ungueltige Namensangaben.
 *
 * <p>Wird geworfen, wenn ein Name {@code null} ist oder nur aus Leerzeichen besteht.
 * Diese Exception ist absichtlich <em>unchecked</em> (erbt von {@link RuntimeException}),
 * um Konstruktoren und Aufrufer nicht mit {@code throws}-Signaturen zu belasten,
 * da es sich hier um einen Programmierfehler bzw. Vorbedingungsverstoß handelt.</p>
 *
 * @since 1.0
 */

public class InvalidNameException extends RuntimeException{
    /**
     * Erzeugt eine neue InvalidNameException mit der angegebenen Fehlermeldung.
     *
     * @param message Beschreibung des Validierungsfehlers.
     */
    public InvalidNameException(String message){
        super(message);
    }
}
