package adamobrien.vaccineassignment.Controllers;

import adamobrien.vaccineassignment.ADT.LinkedList;
import adamobrien.vaccineassignment.Models.Appointment;
import adamobrien.vaccineassignment.Models.Booth;
import adamobrien.vaccineassignment.Models.Patient;
import adamobrien.vaccineassignment.Models.VaxCenter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainController implements Serializable {




    public MainController() {

        this.vcenters = new LinkedList<>();
        this.booths = new LinkedList<>();
        this.patients = new LinkedList<>();
        this.pendingAppointments = new LinkedList<>();
        this.completedAppointments = new LinkedList<>();

    }

    public void initialize() {

        boothTab.setDisable(true);
    }


    /**
     * Patient Methods
     */

    public static LinkedList<Patient> patients;
    @FXML
    private TextField patientName, email, ppsNumber; //patient
    @FXML
    private DatePicker DOB; //patient
    @FXML
    private Label patientListNo;

    @FXML
    private Tab boothTab;

    public LinkedList<Patient> getPatients() {
        return patients;
    }

    public void addPatient(Patient person) {
        patients.addElement(person);
    }

    public void deleteAllPatients() {
        patients.deleteList();
    }

    public int numberOfPatients() {
        int x = patients.listLength();
        return x;
    }

    @FXML
    private ListView<String> patientListView;
    @FXML ChoiceBox patientsChoiceBox;

    public void addPatientDetails(ActionEvent event) {
        //code to set get the datepicker working
        LocalDate myDate = DOB.getValue();
        String myFormattedDate = myDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));


        Patient patient = new Patient(patientName.getText(), ppsNumber.getText(), email.getText(), DOB.getId());
        //frontend adding of patients


        patientListView.getItems().add(patient.toString());
        //backend adding of patients

        addPatient(patient);
        System.out.println(patientName.getText() + "\n" + ppsNumber.getText() + "\n" + email.getText() + "\n" + DOB.getId());

        //counts the patients
        numberOfPatients();
        patientListNo.setText("There are " + numberOfPatients() + " Patients");



        patientsChoiceBox.getItems().clear();
        for (int i = patients.listLength() - 1; i >=0; i-- ) {

            patientsChoiceBox.getItems().add(patients.get(i).name);
        }
    }





    public void deletePatient() {
        for (int i = 0; i < patients.listLength(); i++) {
            if (patients.isEmpty()) { // stops nullPointerException
                if (patientListView.getSelectionModel().getSelectedIndex() == i) {

                patients.remove(i);
                patientListView.getItems().remove(i);

                patientListNo.setText("There are " + numberOfPatients() + " Patients");
                }
            }
        }
    }


    public void resetPatients() {
        //frontend
        patientListView.getItems().clear();
        //backend
        deleteAllPatients();

        //update the counter (backend)
        numberOfPatients();
        //update the counter (frontend)
        patientListNo.setText("There are " + numberOfPatients() + " Patients");
    }

    public void refreshPatientDetails() {
        System.out.println(patientListView.getSelectionModel().getSelectedItem() + "\n" + pendingAppointments.printList());
    }





    /**
     * Booth Methods
     */

    public LinkedList<Booth> booths;

    @FXML
    private TextField boothNumber, floorLevel, accessibility; //booths
    @FXML
    private Label boothListNo;


    public LinkedList<Booth> getBooths() {
        return booths;
    }

    public void addBooth(Booth booth) {

        booths.addElement(booth);
    }

    public void deleteAllBooths() {
        booths.deleteList();
    }


    public int numberOfBooths() {
        int x = booths.listLength();
        return x;
    }


    @FXML
    ListView<String> boothListView;

    public void addBoothDetails(ActionEvent event) {
        Booth booth = new Booth(Integer.parseInt(boothNumber.getText()), floorLevel.getText(), accessibility.getText());
        //gui
        boothListView.getItems().add(booth.toString());
        //backend
        addBooth(booth);
        System.out.println(boothNumber.getText() + "\n" + floorLevel.getText() + "\n" + accessibility.getText());
        //Adds booth to the dropdown on patient menu


        //counts how many booths there are
        numberOfBooths();
        boothListNo.setText("There are " + numberOfBooths() + " Booths");



    }

    public void removeBooth()
    {
        if (booths.isEmpty())
        { // stops nullPointerException
            for (int i = 0; i < booths.listLength(); i++)

                if(boothListView.getSelectionModel().getSelectedIndex() == i)
                {
                    booths.remove(i);  //removing from linked list itself
                    boothListView.getItems().remove(i);  //removing from listview
                    System.out.println(booths.printList());  //testing if it works
                    boothListNo.setText("There are " + numberOfBooths() + " Booths");  //gui update

                }

        }
    }



    public void resetBooths() {
        boothListView.getItems().clear();
        deleteAllBooths();
        //updates the number of booths
        numberOfBooths();
        boothListNo.setText("There are " + numberOfBooths() + " Booths");

    }

    /**
     * Center Methods
     */

    public LinkedList<VaxCenter> vcenters;

    public LinkedList<VaxCenter> getVaxCenter() {

        return vcenters;
    }

    public void addVaxCenter(VaxCenter center) {
        vcenters.addElement(center);
    }


    public void removeAllCenters() {
        vcenters.deleteList();
    }

    public void removeCenter() {
        for (int i = 0; i < vcenters.listLength(); i++) {
            if (vcenters.listLength() != 0) { // stops nullPointerException
                if (centerListView.getSelectionModel().getSelectedIndex() == i) {
                    vcenters.remove(i);
                    centerListView.getItems().remove(i);
                    centerListNo.setText("There are " + numberOfCenters() + " Centers");

                }
            }
        }
    }

    public int numberOfCenters() {
        int x = vcenters.listLength();
        return x;
    }

    @FXML
    private Label centerListNo;

    @FXML
    private TextField address, eircode, centerName;

    @FXML
    ListView<String> centerListView;


    @FXML
    public ChoiceBox<Object> centerChoiceBox;

    public void addCenterDetails(ActionEvent event) {

        centerListView.getItems().addAll(centerName.getText() + " " + address.getText() + " " + eircode.getText() + " ");//+ parkingSpaces.getText());


        addVaxCenter(new VaxCenter(centerName.getText(), address.getText(), eircode.getText(), booths));

        System.out.println(centerName.getText() + "\n" + address.getText() + "\n" + eircode.getText() + "\n" + booths.printList());//+"\n"+parkingSpaces.getText());


        centerChoiceBox.getItems().clear();
        for (int i = vcenters.listLength() - 1; i >= 0; i--) { //reverse for loop

            centerChoiceBox.getItems().addAll(vcenters.get(i).centreName);
        }


        numberOfCenters();
        centerListNo.setText("There are " + numberOfCenters() + " Centers");

        boothTab.setDisable(false);
    }

    public void resetCenters() {
        centerChoiceBox.getItems().clear();
        centerListView.getItems().clear();
        removeAllCenters();
        //updates the number of booths
        numberOfCenters();
        centerListNo.setText("There are " + numberOfCenters() + " Centers");

        boothTab.setDisable(true);

    }

    public void refreshCenter() {

        System.out.println(centerListView.getSelectionModel().getSelectedItem() + "\n" + booths.printList());


    }


    public void deleteEverything() {
        resetBooths();
        resetPatients();
        resetCenters();
        resetAppointments();

    }


    /**
     * Appointment methods
     */

    @FXML
    private ChoiceBox<String> timeChoiceBox;

    @FXML
    private ChoiceBox<String> vaccineChoiceBox;

    @FXML
    public ChoiceBox<Object> boothChoiceBox;

    public void timeSelection() {
        if (timeChoiceBox.getItems().isEmpty()) {
            for (int hour = 9; hour < 13; hour++) {
                for (int mins = 00; mins < 60; mins = mins + 15) {
                    String time = hour + ":" + mins;
                    String[] time2 = time.split(":");
                    String time3 = time2[0] + time2[1];
                    timeChoiceBox.getItems().add(time3);
                }
            }
        }
    }





    public void vaccineSelection() {
        if (vaccineChoiceBox.getItems().isEmpty()) {
            vaccineChoiceBox.getItems().add(0, "Phizer");
            vaccineChoiceBox.getItems().add(1, "Moderna");
            vaccineChoiceBox.getItems().add(2, "AstraZennica");
        }
    }


    public void vaccineAndTime() {
        vaccineSelection();
        timeSelection();
    }


    public static LinkedList<Appointment> pendingAppointments;
    public static LinkedList<Appointment> completedAppointments;
    @FXML
    private ListView pendingAppointmentListView;
    @FXML
    private ListView completedAppointmentListView;


    public void addPendingAppointment(Appointment appointment) {
        pendingAppointments.addElement(appointment);
    }

    public void removeAllAppointments() {
        pendingAppointments.deleteList();
    }

    public void removePendingAppointment() {
        for (int i = 0; i < pendingAppointments.listLength(); i++) {
            if (pendingAppointments.listLength() != 0) { // stops nullPointerException
                if (pendingAppointmentListView.getSelectionModel().getSelectedIndex() == i) {


                    pendingAppointments.remove(i);
                    pendingAppointmentListView.getItems().remove(i);
                    System.out.println(pendingAppointments.printList());
                }
            }
        }
    }

    public void resetAppointments() {
        pendingAppointmentListView.getItems().clear();
        removeAllAppointments();


    }

    public void addPendingAppointmentDetails(ActionEvent event) {
        pendingAppointmentListView.getItems().addAll(patientsChoiceBox.getSelectionModel().getSelectedItem() + " " + timeChoiceBox.getValue() + " " + vaccineChoiceBox.getSelectionModel().getSelectedItem());

        //backend
        addPendingAppointment(new Appointment(Integer.parseInt(timeChoiceBox.getValue()), pendingAppointments.printList(), ppsNumber.getText()));
        System.out.println(patientsChoiceBox.getSelectionModel().getSelectedItem() + "\n" + timeChoiceBox.getSelectionModel().getSelectedItem() + "\n" + vaccineChoiceBox.getSelectionModel().getSelectedItem());
    }

    public void addCompletedAppointment(ActionEvent event) {

        completedAppointmentListView.getItems().add(pendingAppointmentListView.getSelectionModel().getSelectedItem());

        pendingAppointmentListView.getItems().remove(pendingAppointmentListView.getSelectionModel().getSelectedItem());


        if (pendingAppointments.listLength() != 0) {
            completedAppointments.addElement(pendingAppointments.get(pendingAppointmentListView.getSelectionModel().getSelectedIndex()));
        }

        for (int i = 0; i < pendingAppointments.listLength(); i++) {

                pendingAppointments.remove(i);
            }
        }










    /**
     * Vaccination Record
     * *search by pps number
     */
    @FXML
    ListView searchListView;
    @FXML
    TextField search;

    public void searchVaccinationRecord() {
        //have the button set the search variable to what's written
        if(searchListView.getItems().addAll(patients.toString().matches(ppsNumber.getText()))){
            searchListView.getItems().add(patients.toString().matches(ppsNumber.getText()));
        }
    }


    public void loadPatient(ActionEvent event) throws Exception {
        try {
            System.out.println(patients.printList());
            //biddersListView.getItems().  ASK PETER HOW TO UPDATE THE LISTVIEW AFTER LOADING......
            XStream xstream = new XStream(new DomDriver());
            xstream.addPermission(AnyTypePermission.ANY);
            ObjectInputStream is = xstream.createObjectInputStream(new FileReader("patients.xml"));
            patients = (LinkedList<Patient>) is.readObject();
            is.close();


        } catch (Exception e) {
            System.out.println("Error in reading this file : " + e);
        }
    }

    public void savePatient(ActionEvent event) throws Exception {
        try {
            XStream xstream = new XStream(new DomDriver());

            ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("patients.xml"));

            out.writeObject(patients);
            out.close();
        } catch (Exception e) {
            System.out.println("Error writing this file : " + e);
        }
    }


}