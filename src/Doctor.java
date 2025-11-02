import exceptions.InvalidNameException;

/**
 * Domaenenklasse zur Repraesentation eines Arztes.
 *
 * <p>Objekte dieser Klasse sind unveränderlich (immutable):
 * ID und Name werden im Konstruktor gesetzt und danach nicht mehr geändert.</p>
 *
 * <p>Validierung:
 * Der Name darf nicht {@code null} sein und nicht nur aus Leerzeichen bestehen.
 * Bei Verstoß wird eine {@link InvalidNameException} ausgelöst.</p>
 *
 * @since 1.0
 */
public class Doctor implements Displayable{

    /** Eindeutige Arzt-ID. */
    private final int doctorId;
    /** Arztname (nicht leer, nicht nur Leerzeichen). */
    private final String name;

    /**
     * Erstellt einen neuen Arzt.
     *
     * @param doctorId eindeutige ID des Arztes
     * @param name     Name des Arztes; darf nicht {@code null} oder leer sein
     * @throws InvalidNameException wenn {@code name} ungültig ist
     */
    public Doctor(String name, int doctorId){
        if(name == null || name.trim().isEmpty()){
            throw new InvalidNameException("Ungültiger Name: Name darf nicht leer sein.");
        }
        this.name = name;
        this.doctorId = doctorId;
    }

    /**
     * Liefert die eindeutige Arzt-ID.
     *
     * @return Arzt-ID
     */
    public int getDoctorId(){
        return doctorId;
    }

    /**
     * Gibt die Arztinformationen auf {@code System.out} aus.
     *
     * <p>Diese Methode ist für Demo-/Übungszwecke gedacht.</p>
     */
    @Override
    public void displayInfo() {
        System.out.println("Arztname: " + name + ", Arzt-ID: " +doctorId);
    }
}
