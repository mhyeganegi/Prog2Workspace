
/**Diese Klasse legt fest welche atribute ein Doctor haben muss und sie wirft Exceptions
 * @author Naci Alptekin
 * @author Ruba Mogalli
 * @author Mohammad Hossein Yeganegi
 */
import exceptions.InvalidNameException;

public class Doctor implements Displayable {
    private String name;
    private int doctorID;

    /**
     * Konstruktor HealthManagement
     * 
     * @param name      String vom Name des Doctors
     * @param patientID ist ein String von Doctors
     */

    public Doctor(String name, int doctorID) {
        this.name = name;
        this.doctorID = doctorID;

    }

    /**
     * Die ganze Info wird ausgegeben vom Doctoren
     * wenn Name ungültig ist wird ein InvalidNameException geworfen.
     */
    @Override
    public void displayinfo() throws InvalidNameException {
        if (name.equals(null) || name.isBlank()) {
            throw new InvalidNameException("Ungültiger Name: Name darf nicht leer oder nur aus Leerzeichen bestehen.");
        }
        System.out.println("Doctor: " + name + " DoctorID: " + doctorID);

    }

    /**
     * gibt den doctorID zurück
     * 
     * @return doctorID
     */
    public int getDoctorID() {
        return doctorID;
    }
}
