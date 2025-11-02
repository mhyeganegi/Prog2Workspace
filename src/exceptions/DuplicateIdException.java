package exceptions;
/**
 * Checked Exception fuer doppelt verwendete IDs.
 *
 * <p>Wird geworfen, wenn versucht wird, eine bereits vergebene ID erneut
 * in die Verwaltung aufzunehmen (z. B. beim Hinzufügen von Patient:innen oder Ärzt:innen
 * mit identischer ID).</p>
 *
 * @since 1.0
 */

public class DuplicateIdException extends Exception{


    /**
     * Erzeugt eine neue DuplicateIdException mit der angegebenen Fehlermeldung.
     *
     * @param message Beschreibung des Duplikatproblems.
     */
    public DuplicateIdException(String message){
        super(message);
    }
}
