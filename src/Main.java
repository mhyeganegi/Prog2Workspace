import exceptions.DuplicateIdException;

import java.util.*;

/**
 * Einstiegspunkt und Demonstrationsprogramm fuer Uebung&nbsp;4.
 *
 * <p>Zeigt die Verwendung der Domänenklassen und der Verwaltungslogik:
 * <ul>
 *   <li>Validierung von Eingaben (ungültige Namen, {@code null}-Objekte),</li>
 *   <li>Hinzufügen und Duplikatprüfung,</li>
 *   <li>Nachschlagen per ID inklusive Fehlerbehandlung,</li>
 *   <li>Ausgabe aller gespeicherten Einträge.</li>
 * </ul>
 * </p>
 *
 * @since 1.0
 */
class Main {

    /**
     * Startet die Demo.
     *
     * @param args Kommandozeilenargumente (werden nicht verwendet)
     */
    public static void main(String[] args) {

        HealthManagement hm = new HealthManagement();

        // Gültige Objekte
        Patient p1 = new Patient(101, "Sarah");
        Patient p2 = new Patient(102, "Anna");

        Doctor d1 = new Doctor("Dr. Müller", 221);
        Doctor d2 = new Doctor("Dr. Schmidt", 222);

        // null-Validierung demonstrieren
        try {
            hm.addDoctor(null);
        } catch (IllegalArgumentException | DuplicateIdException e){
            System.out.println("[ERR] " + e.getMessage());
        }

        try {
            hm.addPatient(null);
        } catch (IllegalArgumentException | DuplicateIdException e){
            System.out.println("[ERR] " + e.getMessage());
        }

        // Regulär hinzufügen
        try{
            hm.addDoctor(d1);
            hm.addDoctor(d2);
            hm.addPatient(p1);
            hm.addPatient(p2);
        } catch (DuplicateIdException e){
            System.out.println("[ERR] " + e.getMessage());
        }

        // Duplikate erzeugen
        try{
            hm.addDoctor(new Doctor("Dr. Müller(Dup)", 221));
        } catch (Exception e){
            System.out.println("[ERR] " + e.getMessage());
        }

        try{
            hm.addPatient(new Patient(101, "Sarah(Dup)"));
        } catch (Exception e){
            System.out.println("[ERR] " + e.getMessage());
        }

        // Suche mit Fehlfall
        try{
            hm.findeDoctorById(999).displayInfo();
        }catch (NoSuchElementException e){
            System.out.println("[ERR] " + e.getMessage());
        }

        try{
            hm.findePatientById(888).displayInfo();
        }catch (NoSuchElementException e){
            System.out.println("[ERR] " + e.getMessage());
        }

        // Ausgabe
        System.out.println("\nListe der Patienten:");
        hm.displayAllPatients();

        System.out.println("\nListe der Ärzte:");
        hm.displayAllDoctors();



       /* Set<Patient> patientSet = new HashSet<>();
        patientSet.add(p1);
        patientSet.add(p2);
        patientSet.add(pDup);

        Map<Integer, Doctor> doctorMap = new HashMap<>();
        doctorMap.put(d1.getDoctorId(), d1);
        doctorMap.put(d2.getDoctorId(), d2);

        System.out.println("\nListe der Patienten: ");
        displayAllPatienten(patientSet);

        System.out.println("\nListe der Ärzte");
        displayAllDoctors(doctorMap);   **/

    }

   /* private static void displayAllPatienten(Set<Patient> patients){
        for (Patient p : patients){
            p.displayInfo();
        }
    }

    private static void displayAllDoctors(Map<Integer, Doctor> doctors){
        for (Doctor d : doctors.values()){
            d.displayInfo();
        }
    } **/

   /*
    *   Aufgabe 6: Reflexion
    * - InvalidNameException (hier als RuntimeException) ist eine Unchecked Exception;
    *   NoSuchElementException ist ebenfalls Unchecked.
    * - Checked Exceptions (z. B. IOException) eignen sich für erwartbare, wiederherstellbare
    *    Fehler, die der Aufrufer verpflichtend behandeln soll.
    * - Unchecked Exceptions sind sinnvoll für Programmierfehler oder Vorbedingungsverstöße
    *   (z. B. ungültige Argumente, nicht vorhandene IDs), bei denen eine sofortige Korrektur
    *   durch den Aufrufer oft nicht möglich oder nicht sinnvoll ist.
    * - Defensives Programmieren (Validierungen, klare Fehlermeldungen, eindeutige Verträge) +
    *   konsistente Exception-Hierarchie erhöhen Robustheit und erleichtern Debugging sowie
    *   Fehlerbehandlung an den passenden Stellen.
    */
}