package adamobrien.vaccineassignment.Models;

//import com.thoughtworks.xstream.XStream;
//import com.thoughtworks.xstream.io.xml.DomDriver;
//
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;

import adamobrien.vaccineassignment.ADT.LinkedList;
import adamobrien.vaccineassignment.Utils.Utilities;

public class Booth {


    public static LinkedList<Appointment> appointments;
    public int boothNumber;
    public String floorLevel;
    public String accessibility;


    public Booth(int boothNumber, String floorLevel , String accessibility) {

            this.boothNumber = boothNumber;

            this.floorLevel = floorLevel;

            this.accessibility = accessibility;


        this.appointments = new LinkedList<>();




        //this.patients = patients;
    }

    public String getFloorLevel() {
        return floorLevel;
    }

    public void setFloorLevel(String floorLevel) {
        this.floorLevel = floorLevel;
    }

    public int getBoothNumber() {
        return boothNumber;
    }

    public void setBoothNumber(int boothNumber) {
        this.boothNumber = boothNumber;
    }

    public String getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(String accessibility) {
        this.accessibility = accessibility;
    }

//    public LinkedList<Patient> getPatients() {
//        return patients;
//    }
//
//    public void setPatients(LinkedList<Patient> patients) {
//        this.patients = patients;
//    }

    @Override
    public String toString() {
        return "booths{" +
                "boothNumber=" + boothNumber +
                ", floorLevel=" + floorLevel +
                ", accessibility='" + accessibility+
                '}';
    }
}
