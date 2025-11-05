
/**@author Naci Alptekin
 * @author Ruba Mogalli
 * @author Mohammad Hossein Yeganegi */
import exceptions.DuplicateIdException;
//import exceptions.InvalidNameException;

public class Main {
    public static void main(String args[]) {

        HealthManagement hm = new HealthManagement();

        Patient p1 = new Patient("Naci", "100");
        Patient p2 = new Patient("Ali", "169");
        Patient p3 = new Patient("Ali", "169");

        Doctor d1 = new Doctor("Mueller", 101);
        Doctor d2 = new Doctor("Max", 102);
        Doctor d3 = new Doctor("", 103);

        try {
            hm.addPatient(p1);
            hm.addPatient(p2);
            hm.addPatient(p3);

            hm.addDoctor(d1);
            hm.addDoctor(d2);
            hm.addDoctor(d3);

            hm.showAllPatients();
        } catch (DuplicateIdException e) {
            System.out.println(e.getMessage());
        }

        // hm.showAllDoctors();

        // hm.findDoctorByID(102);

    }
}

/*
 * • In welchen Situationen ist Ihrer Meinung nach eine Checked Exception
 * sinnvoller?
 * Wenn ein Fehler vorhersehbar ist und behandelt werden muss
 * 
 * • Wann würden Sie eine Unchecked Exception bevorzugen?
 * wenn der fehler durch den programmierer verursacht wird oder wenn der
 * vermeintbar ist
 * 
 * • Wie könnten Konzepte des defensiven Programmierens und der
 * Exception-Behandlung weiter dazu
 * beitragen, robuste und fehlertolerante Programme zu erstellen?
 * sie vorbeugen das der programm abstürtz oder das man später den ganzen code
 * debuggen muss wenn man schon vorher weiß
 * was für fehler auftauchen könnten
 */