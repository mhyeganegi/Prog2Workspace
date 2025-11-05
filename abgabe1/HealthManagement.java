
/**Diese Klasse verwaltet Die Patienten und Doctor klasse
 * @author Naci Alptekin
 * @author Ruba Mogalli
 * @author Mohammad Hossein Yeganegi
 */
import java.util.*;

import exceptions.DuplicateIdException;
import exceptions.InvalidNameException;

public class HealthManagement {
    private Set<Patient> patients;
    private Map<Integer, Doctor> doctors;

    /**
     * Konstruktor HealthManagement
     * 
     * @param patients HashSet von patienten
     * @param doctors  HashMap von doctors
     */
    public HealthManagement() {
        patients = new HashSet<>();
        doctors = new HashMap<>();
    }

    /**
     * hier wird ein Patient in den HashSet patients hinzugefügt.
     * wenn der Patient breits vorhanden ist wird ein Nachricht augegeben.
     * 
     * @param p der hinzuzufügende Patient
     */
    public void addPatient(Patient p) throws DuplicateIdException {
        if (p == null) {
            throw new IllegalArgumentException("Patient-Objekt darf nicht null sein.");
        }
        if (patients.contains(p)) {
            System.out.println("Patient existiert bereits.");
        }
        for (Patient p1 : patients) {
            if (p1.getPatientID().equals(p.getPatientID())) {
                throw new DuplicateIdException("Die ID " + p1.getPatientID() + " wird bereits verwendet.");
            }
        }
        patients.add(p);
    }

    /**
     * hier wird ein Doctor in den HashMap patients hinzugefügt.
     * wenn der Doctor breits vorhanden ist wird ein Nachricht augegeben.
     * 
     * @param d der hinzuzufügende Doctor
     */
    public void addDoctor(Doctor d) throws DuplicateIdException {
        if (d == null) {
            throw new IllegalArgumentException("Arzt-Objekt darf nicht null sein.");
        }
        if (doctors.containsValue(d)) {
            System.out.println("Doctor existiert bereits.");
        }
        for (Map.Entry<Integer, Doctor> entry : doctors.entrySet()) {
            Doctor value = entry.getValue();
            if (value.getDoctorID() == d.getDoctorID()) {
                throw new DuplicateIdException("Die ID " + value.getDoctorID() + " wird Bereits verwendet.");
            }
        }
        doctors.put(d.getDoctorID(), d);
    }

    /**
     * hier werden alle Patienten aufgelistet.
     * wenn ein Patient einen ungueltigen Namen hat wird eine InvalNameException
     * geworfen.
     */

    public void showAllPatients() {
        try {
            for (Patient p : patients) {
                p.displayinfo();
            }
        } catch (InvalidNameException e) {
            System.out.println(e);
        }
    }

    /**
     * hier werden alle Doctoren aufgelistet.
     * wenn ein Doctor einen ungueltigen Namen hat wird eine InvalNameException
     * geworfen.
     */
    public void showAllDoctors() {
        try {
            for (Map.Entry<Integer, Doctor> entry : doctors.entrySet()) {
                Doctor value = entry.getValue();
                value.displayinfo();
            }
        } catch (InvalidNameException e) {
            System.out.println(e);
        }
    }

    public void findDoctorByID(int doctorID) throws NoSuchElementException {

        for (Map.Entry<Integer, Doctor> entry : doctors.entrySet()) {
            Doctor value = entry.getValue();
            if (value.getDoctorID() == doctorID) {
                try {
                    value.displayinfo();
                    return;
                } catch (InvalidNameException e) {
                    System.out.println(e);
                }
            }
        }
        throw new NoSuchElementException("Kein Arzt mit der ID " + doctorID + " gefunden.");

    }
}
