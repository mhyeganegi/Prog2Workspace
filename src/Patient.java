import exceptions.InvalidNameException;

import java.util.Objects;

/**
 * Domaenenklasse zur Repraesentation eines Patienten.
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

public class Patient implements Displayable{
    /** Eindeutige Patienten-ID. */
    private final int patientId;
    /** Patientenname (nicht leer, nicht nur Leerzeichen). */
    private final String name;


    /**
     * Erstellt einen neuen Patienten.
     *
     * @param patientId eindeutige ID des Patienten
     * @param name      Name des Patienten; darf nicht {@code null} oder leer sein
     * @throws InvalidNameException wenn {@code name} ungültig ist
     */
    public Patient(int patientId, String name) {
        if (name == null || name.trim().isEmpty()){
            throw new InvalidNameException("Ungültiger Name: Name darf nicht leer sein.");
        }

        this.name = name;
        this.patientId = patientId;

    }

    /**
     * Liefert die eindeutige Patienten-ID.
     *
     * @return Patienten-ID
     */
    public int getPatientId(){
        return patientId;
    }

    /**
     * Gibt die Patienteninformationen auf {@code System.out} aus.
     *
     * <p>Diese Methode ist für Demo-/Übungszwecke gedacht.</p>
     */
    public void displayInfo(){
        System.out.println("Patientenname: " + name + ", Patient-ID: " + patientId);
    }

    //Für HashSet-Duplikaterkennung über patientId


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient p)) return false;
        return Objects.equals(patientId, p.patientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId);
    }
}
