package adamobrien.vaccineassignment.Models;

import adamobrien.vaccineassignment.ADT.LinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoothTest {
    private Booth validBooth;
    private Booth testBoothValidation;
    private LinkedList<Appointment> appointments;


    @BeforeEach
    public void setUp() {
        validBooth = new Booth(1,"Floor 1","Wheelchair Access Required");
        testBoothValidation = new Booth(-1,"F1","None Required");

    }

    @Test
    public void testConstructor(){
        //test on valid data
        assertEquals(1,validBooth.getBoothNumber());
        assertEquals("Floor 1", validBooth.getFloorLevel());
        assertEquals("Wheelchair Access Required",validBooth.getAccessibility());

        //test on invalid data

        assertEquals(0,testBoothValidation.getBoothNumber());
        assertEquals("Ground" , testBoothValidation.getFloorLevel());
        assertEquals("None",testBoothValidation.getAccessibility());

    }


    @Test
    void setFloorLevel() {

        validBooth.setFloorLevel("Floor 2");
        assertEquals("Floor 2",validBooth.getFloorLevel());

    }



    @Test
    void setBoothNumber() {
        validBooth.setBoothNumber(5);
        assertEquals(5,validBooth.getBoothNumber());
    }



    @Test
    void setAccessibility() {
        validBooth.setAccessibility("None");
        assertEquals("None",validBooth.getAccessibility());

    }

    @Test
    void testToString() {
        assertTrue(validBooth.toString().contains("Floor 1"));
    }
}