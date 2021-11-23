package adamobrien.vaccineassignment.Models;

import adamobrien.vaccineassignment.ADT.LinkedList;
import adamobrien.vaccineassignment.Controllers.VaccineAPI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PatientTest {
    private Patient patientZero;
    private Patient testValidation;
    private LinkedList<Appointment> appointments;

    @BeforeEach
    void setUp() {
        patientZero = new Patient("Adam O'Brien","20-Sep-2002","adamobrien180@gmail.com","1234321AZ");
        testValidation = new Patient("MyNameIsTooLongForThis","Once a year Probably!","emailathotmaildotcom","123456543rtreg");
    }

    @Test
    void testConstructor(){
        //valid data
        assertEquals("Adam O'Brien", patientZero.getName());
        assertEquals("20-Sep-2002", patientZero.getDOB());
        assertEquals("adamobrien180@gmail.com", patientZero.getEmail());
        assertEquals("1234321AZ", patientZero.getPpsNumber());

        //invalid data
        assertEquals("Invalid Name",testValidation.getName());
        assertEquals("1-Jan-2000",testValidation.getDOB());
        assertEquals("Invalid email",testValidation.getEmail());
        assertEquals("0000000XX",testValidation.getPpsNumber());

    }



    @Test
    void setName() {

        patientZero.setName("Joe");
        assertEquals("Joe",patientZero.getName());
    }



    @Test
    void setDOB() {
        patientZero.setDOB("24-Jan-1995");
        assertEquals("24-Jan-1995",patientZero.getDOB());
    }



    @Test
    void setEmail() {
        patientZero.setEmail("email@gmail.com");
        assertEquals("email@gmail.com",patientZero.getEmail());

    }



    @Test
    void setPpsNumber() {
        patientZero.setPpsNumber("1234567XF");
        assertEquals("1234567XF",patientZero.getPpsNumber());
    }



    @Test
    void testToString() {
        assertTrue(testValidation.toString().contains("Invalid email"));
    }
}