
/**Diese Klasse legt fest welche atribute ein Patient haben muss und sie wirft Exceptions
 * @author Naci Alptekin
 * @author Ruba Mogalli
 * @author Mohammad Hossein Yeganegi
 */
import exceptions.InvalidNameException;

public class Patient implements Displayable {

    private String name;
    private String patientID;

    /**
     * Konstruktor HealthManagement
     * 
     * @param name      String vom Name des patienten
     * @param patientID ist ein String von patienten
     */
    public Patient(String name, String patientID) {
        this.name = name;
        this.patientID = patientID;

    }

    /**
     * Die ganze Info wird ausgegeben vom Patienten
     * wenn Name ungültig ist wird ein InvalidNameException geworfen.
     */
    @Override
    public void displayinfo() throws InvalidNameException {
        if (name.isBlank() || name.equals(null)) {
            throw new InvalidNameException("Ungültiger Name: Name darf nicht leer oder nur aus Leerzeichen bestehen");
        }
        System.out.println("Patient: " + name + " PatientenID: " + patientID);
    }

    /**
     * gibt den patientID zurück
     * 
     * @return patientID
     */
    public String getPatientID() {
        return patientID;
    }

}
