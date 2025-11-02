import exceptions.DuplicateIdException;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Einfache Verwaltungslogik für Patient:innen und Aerzt:innen.
 *
 * <p>Verwendet interne Maps, um Objekte über ihre IDs nachzuschlagen:
 * <ul>
 *   <li>Ärzt:innen: {@code Map&lt;doctorId, Doctor&gt;}</li>
 *   <li>Patient:innen: {@code Map&lt;patientId, Patient&gt;}</li>
 * </ul>
 * </p>
 *
 * <p>Besonderheiten:
 * <ul>
 *   <li>{@code null}-Argumente werden abgewiesen ({@link IllegalArgumentException}).</li>
 *   <li>Doppelte IDs werden als Fehler gemeldet ({@link DuplicateIdException}).</li>
 *   <li>Nicht vorhandene IDs beim Nachschlagen führen zu {@link NoSuchElementException}.</li>
 * </ul>
 * </p>
 *
 * <p><strong>Thread-Sicherheit:</strong> Diese Implementierung ist <em>nicht</em> threadsicher.</p>
 *
 * @since 1.0
 */

public class HealthManagement {

    private final Map<Integer, Doctor> doctors = new HashMap<>();
    private final Map<Integer, Patient> patients = new HashMap<>();

    /**
     * Fügt einen Arzt hinzu.
     *
     * @param doctor Arzt-Objekt; darf nicht {@code null} sein
     * @throws IllegalArgumentException wenn {@code doctor} {@code null} ist
     * @throws DuplicateIdException     wenn die Arzt-ID bereits vorhanden ist
     */
    public void addDoctor(Doctor doctor) throws DuplicateIdException{
        if (doctor == null){
            throw new IllegalArgumentException("Arzt-Objekt darf nicht null sein.");
        }

        int id = doctor.getDoctorId();
        if (doctors.containsKey(id)){
            throw new DuplicateIdException("Die Doctor-ID " + id + " wird bereits verwendet");
        }
        doctors.put(id, doctor);
    }

    /**
     * Fügt einen Patienten hinzu.
     *
     * @param patient Patient-Objekt; darf nicht {@code null} sein
     * @throws IllegalArgumentException wenn {@code patient} {@code null} ist
     * @throws DuplicateIdException     wenn die Patienten-ID bereits vorhanden ist
     */
    public void addPatient(Patient patient) throws DuplicateIdException{
        if (patient == null){
            throw new IllegalArgumentException("Patient-Objekt darf nicht null sein.");
        }

        int id = patient.getPatientId();
        if (patients.containsKey(id)){
            throw new DuplicateIdException("Die Patient-ID " + id + " wird bereits verwendet");
        }
        patients.put(id, patient);
    }

    /**
     * Sucht einen Arzt per ID.
     *
     * @param doctorId ID des gesuchten Arztes
     * @return den gefundenen {@link Doctor}
     * @throws NoSuchElementException wenn kein Arzt mit der angegebenen ID existiert
     */
    public Doctor findeDoctorById(int doctorId){
        Doctor d = doctors.get(doctorId);

        if (d == null){
            throw new NoSuchElementException("Kein Arzt mit der ID " + doctorId + " gefunden.");
        }
        return d;
    }

    /**
     * Sucht einen Patienten per ID.
     *
     * @param patientId ID des gesuchten Patienten
     * @return den gefundenen {@link Patient}
     * @throws NoSuchElementException wenn kein Patient mit der angegebenen ID existiert
     */
    public Patient findePatientById(int patientId){
        Patient p = patients.get(patientId);

        if (p == null){
            throw new NoSuchElementException("Kein Patient mit der ID " + patientId + " gefunden.");
        }
        return p;
    }

    /**
     * Gibt alle gespeicherten Patient:innen auf {@code System.out} aus.
     *
     * <p>Reihenfolge ist nicht garantiert.</p>
     */
    public void displayAllPatients(){
        patients.values().forEach(Patient::displayInfo);
    }

    /**
     * Gibt alle gespeicherten Aerzt:innen auf {@code System.out} aus.
     *
     * <p>Reihenfolge ist nicht garantiert.</p>
     */
    public void displayAllDoctors(){
        doctors.values().forEach(Doctor::displayInfo);
    }
}
