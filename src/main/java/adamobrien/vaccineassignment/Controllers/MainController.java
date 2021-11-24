package adamobrien.vaccineassignment.Controllers;

import adamobrien.vaccineassignment.ADT.LinkedList;
import adamobrien.vaccineassignment.Models.Appointment;
import adamobrien.vaccineassignment.Models.Booth;
import adamobrien.vaccineassignment.Models.Patient;
import adamobrien.vaccineassignment.Models.VaxCenter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainController {


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

    public void addPatientDetails(ActionEvent event) {
        //code to set get the datepicker working
        LocalDate myDate = DOB.getValue();
        String myFormattedDate = myDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));

        //frontend adding of patients
        patientListView.getItems().addAll(patientName.getText() + " " + myFormattedDate + " " + email.getText() + " " + ppsNumber.getText() + "\n" + pendingAppointments.printList());

        //backend adding of patients

        addPatient(new Patient(patientName.getText(), ppsNumber.getText(), email.getText(), DOB.getId()));
        System.out.println(patientName.getText() + "\n" + ppsNumber.getText() + "\n" + email.getText() + "\n" + DOB.getId());

        //counts the patients
        numberOfPatients();
        patientListNo.setText("There are " + numberOfPatients() + " Patients");
    }

    public void deletePatient() {  //TODO
        for (int i = 0; i < patients.listLength(); i++) {
            if (patients.listLength() != 0) { // stops nullPointerException
                if (patientListView.getSelectionModel().getSelectedItem().contains(patients.get(i).ppsNumber)) ;

                patients.delete(i);
                patientListView.getItems().remove(i);
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


//    public int searchPatients(String patientName)
//    {
//        if (!patients.isEmpty())
//        {
//            for (Patient p : patients)
//            {
//                if (p.getName().equalsIgnoreCase(patientName))
//                {
//                    return patients.indexOf(p);
//                }
//            }
//        }
//        return -1;
//    }


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

        //adds the booths to the appointment tab
        boothChoiceBox.getItems().clear();
        for (int i = booths.listLength() - 1; i >=0; i-- ){ //reverse for loop

            boothChoiceBox.getItems().addAll(booths.get(i).boothNumber);
        }

    }

    public void removeBooth()
    { //TODO
        if (booths.listLength() != 0)
        { // stops nullPointerException
            for (int i = 0; i < booths.listLength(); i++)

                if(booths.get(i).toString().equals(boothListView.getItems().get(boothListView.getSelectionModel().getSelectedIndex())))
                {
                    booths.delete(i);
                    boothListView.getItems().remove(i);
                    System.out.println(booths.printList());
                    boothListNo.setText("There are " + numberOfBooths() + " Booths");
                }

        }
    }



    public void resetBooths() {
        boothListView.getItems().clear();
        deleteAllBooths();
        //updates the number of booths and ChoiceBox in patients
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

    public void removeCenter() {  //TODO
        for (int i = 0; i < vcenters.listLength(); i++) {
            if (vcenters.listLength() != 0) { // stops nullPointerException
                if (vcenters.get(i).eircode.contains(centerListView.getSelectionModel().getSelectedItem().toString()))
                    ;
                System.out.println(i);

                vcenters.delete(i);
                centerListView.getItems().remove(i);
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
        //System.out.println(centerName.getText()+"\n"+address.getText()+"\n"+eircode.getText()+ "\n" + booths.printList());

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


    public void patientSelection() {
        //this is done in addPatient();
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

    public void removePendingAppointment() { //TODO
        for (int i = 0; i < pendingAppointments.listLength(); i++) {
            if (pendingAppointments.listLength() != 0) { // stops nullPointerException
                if (pendingAppointments.get(i).ppsNumber.contains(pendingAppointmentListView.getSelectionModel().getSelectedItem().toString()))
                    ;
                System.out.println(pendingAppointments.printList());

                pendingAppointments.delete(i);
                pendingAppointmentListView.getItems().remove(i);

                System.out.println(pendingAppointments.printList());
            }
        }
    }

    public void resetAppointments() {
        pendingAppointmentListView.getItems().clear();
        removeAllAppointments();
        //updates the number of booths

        //centerListNo.setText("There are " + numberOfCenters() + " Booths");


    }

    public void addPendingAppointmentDetails(ActionEvent event) {
        pendingAppointmentListView.getItems().addAll(boothChoiceBox.getSelectionModel().getSelectedItem() + " " + timeChoiceBox.getValue() + " " + vaccineChoiceBox.getSelectionModel().getSelectedItem());

        //backend
        addPendingAppointment(new Appointment(Integer.parseInt(timeChoiceBox.getValue()), pendingAppointments.printList(), ppsNumber.getText()));
        System.out.println(boothChoiceBox.getSelectionModel().getSelectedItem() + "\n" + timeChoiceBox.getSelectionModel().getSelectedItem() + "\n" + vaccineChoiceBox.getSelectionModel().getSelectedItem());
    }

    public void addCompletedAppointment(ActionEvent event) { //TODO

        completedAppointmentListView.getItems().add(pendingAppointmentListView.getSelectionModel().getSelectedItem());

        pendingAppointmentListView.getItems().remove(pendingAppointmentListView.getSelectionModel().getSelectedItem());


        if (pendingAppointments.listLength() != 0) {
            completedAppointments.addElement(pendingAppointments.get(pendingAppointmentListView.getSelectionModel().getSelectedIndex()));
        }

        for (int i = 0; i < pendingAppointments.listLength(); i++) {
            if (pendingAppointments.listLength() != 0) { // stops nullPointerException
                if (pendingAppointments.get(i).ppsNumber.matches(pendingAppointmentListView.getSelectionModel().getSelectedItem().toString()));
                System.out.println(i);
                pendingAppointments.delete(i);
            }
        }

        System.out.println(completedAppointments.printList());
        //removePendingAppointment(pendingAppointments.get(pendingAppointmentListView.getSelectionModel().getSelectedIndex()));

    }


    //addCompletedAppointment(new Appointment(Integer.parseInt(timeChoiceBox.getValue()),pendingAppointments.printList()));


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
        searchListView.getItems().addAll(patients.toString().matches(ppsNumber.getText()));
    }


//    public void save(ActionEvent event) throws IOException {
//
//        XStream xstream = new XStream(new DomDriver());
//        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("patients.xml"));
//        out.writeObject(PatientAPI.patients);
//        out.close();
//    }
//
//    public void load(ActionEvent event) throws IOException, ClassNotFoundException {
//        XStream xstream = new XStream(new DomDriver());
//        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("patients.xml"));
//        LinkedList<?> x = (LinkedList<?>) is.readObject();  // finish LinkedList before finish
//        LinkedList<Patient> p = new LinkedList<>();
//        for(Object o : x){
//            if(o instanceof Patient){
//                p.addElement((Patient) o);
//            }
//        }
//        PatientAPI.patients = p;
//        is.close();
//    }


}