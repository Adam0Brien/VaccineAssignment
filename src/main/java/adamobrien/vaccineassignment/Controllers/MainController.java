package adamobrien.vaccineassignment.Controllers;

import adamobrien.vaccineassignment.ADT.LinkedList;
import adamobrien.vaccineassignment.Models.Appointment;
import adamobrien.vaccineassignment.Models.Booth;
import adamobrien.vaccineassignment.Models.Patient;
import adamobrien.vaccineassignment.Models.VaxCenter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainController {



    public MainController() {

        this.vcenters = new LinkedList<>();
        this.booths = new LinkedList<>();
        this.patients = new LinkedList<>();
        this.appointments = new LinkedList<>();
    }



    /**
     *Patient Methods
     */

    public static LinkedList<Patient> patients;
    @FXML private TextField patientName,email,ppsNumber; //patient
    @FXML private DatePicker DOB; //patient
    @FXML private Label patientListNo;

    public LinkedList<Patient> getPatients() {
        return patients;
    }

    public void addPatient(Patient person) {
        patients.addElement(person);
    }

    public void deletePatient(int index) {
        patients.delete(index);
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
        patientListView.getItems().addAll(patientName.getText() + " " + myFormattedDate + " " + email.getText() + " " + ppsNumber.getText() + "\n" + appointments.printList());

        //backend adding of patients

        addPatient(new Patient(patientName.getText(),ppsNumber.getText(),email.getText(), DOB.getId(), appointments));
        System.out.println(patientName.getText()+"\n"+ppsNumber.getText()+"\n"+email.getText() +"\n"+ DOB.getId());

        //counts the patients
        numberOfPatients();
        patientListNo.setText("There are " + numberOfPatients() + " Patients");


        //adds the patients to the appointment tab
        patientChoiceBox.getItems().clear();
        for (int i = patients.listLength() - 1; i >=0; i-- ){ //reverse for loop

             patientChoiceBox.getItems().addAll(patients.get(i).name);
        }
    }

    /**
     * Delete patientDetails
     *
     * Removes from listview + removes object completely
     *
     */

    public void deletePatientDetails(){ //TODO
//
//          patientlistView    -- deletes listview
//
//        patientlistView.getSelectionModel().getSelectedIndex();

        patientListView.getSelectionModel().clearSelection();
        deletePatient(patientListView.getSelectionModel().getSelectedIndex());

    }

    public void resetPatients(){
        //frontend
        patientListView.getItems().clear();
        //backend
        deleteAllPatients();

        //update the counter (backend)
        numberOfPatients();
        //update the counter (frontend)
        patientListNo.setText("There are " + numberOfPatients() + " Patients");
    }

    public void refreshPatientDetails(){
        System.out.println(patientListView.getSelectionModel().getSelectedItem() + "\n" + appointments.printList());
    }


    /**
     *Booth Methods
     */

        public LinkedList<Booth> booths;

        @FXML private TextField boothNumber , floorLevel , accessibility; //booths
        @FXML private Label boothListNo;
        @FXML private ChoiceBox<Object> boothChoiceBox;



        public LinkedList<Booth> getBooths(){
            return booths;
        }

        public void addBooth(Booth booth){

            booths.addElement(booth);
        }

        public void deleteAllBooths(){
            booths.deleteList();
        }


        public int numberOfBooths(){
            int x = booths.listLength();
            return x;
        }


        @FXML
        ListView<String> boothListView;

        public void addBoothDetails(ActionEvent event) {
            //gui
            boothListView.getItems().addAll( "#"+boothNumber.getText() +" Floor "+ floorLevel.getText() + " " + accessibility.getText());
            //backend
            addBooth(new Booth(boothNumber.getLength(),floorLevel.getText(),accessibility.getText(),appointments));
            System.out.println(boothNumber.getText()+"\n"+floorLevel.getText()+"\n"+accessibility.getText());
            //Adds booth to the dropdown on patient menu
            boothChoiceBox.getItems().clear();
            for (int i = booths.listLength() - 1; i >=0; i-- ){ //reverse for loop

                boothChoiceBox.getItems().addAll(booths.get(i).boothNumber);
            }


            //counts how many booths there are
            numberOfBooths();
            boothListNo.setText("There are " + numberOfBooths() + " Booths");
        }



        public void resetBooths(){
            boothChoiceBox.getItems().clear();
            boothListView.getItems().clear();
            deleteAllBooths();
            //updates the number of booths and ChoiceBox in patients
            numberOfBooths();
            boothListNo.setText("There are " + numberOfBooths() + " Booths");

        }

    /**
     *Center Methods
     */

    public LinkedList<VaxCenter> vcenters;

        public LinkedList<VaxCenter> getVaxCenter() {

            return vcenters;
        }

        public void addVaxCenter(VaxCenter center){
            vcenters.addElement(center);
        }



        public void removeAllCenters(){
            vcenters.deleteList();
        }


        public int numberOfCenters(){
            int x = vcenters.listLength();
            return x;
        }

        @FXML private Label centerListNo;

        @FXML
        private TextField address, eircode,centerName;

        @FXML
        ListView<String> centerListView;


    @FXML public ChoiceBox<Object> centerChoiceBox;

        public void addCenterDetails(ActionEvent event) {

            centerListView.getItems().addAll( centerName.getText()+" "+address.getText() +" "+ eircode.getText() + " ");//+ parkingSpaces.getText());


            addVaxCenter(new VaxCenter(centerName.getText(),address.getText(),eircode.getText(),booths));

            System.out.println(centerName.getText()+"\n"+address.getText()+"\n"+eircode.getText()+ "\n" + booths.printList());//+"\n"+parkingSpaces.getText());


            centerChoiceBox.getItems().clear();
            for (int i = vcenters.listLength() - 1; i >=0; i-- ){ //reverse for loop

                centerChoiceBox.getItems().addAll(vcenters.get(i).centreName);
            }


            numberOfCenters();
            centerListNo.setText("There are " + numberOfCenters() + " Centers");


        }
        public void resetCenters(){
            centerChoiceBox.getItems().clear();
            centerListView.getItems().clear();
            removeAllCenters();
            //updates the number of booths
            numberOfCenters();
            centerListNo.setText("There are " + numberOfCenters() + " Centers");

        }

        public void refreshCenter(){

            System.out.println(centerListView.getSelectionModel().getSelectedItem() + "\n" + booths.printList());
            //System.out.println(centerName.getText()+"\n"+address.getText()+"\n"+eircode.getText()+ "\n" + booths.printList());

        }



        public void deleteEverything(){
            resetBooths();
            resetPatients();
            resetCenters();

        }


    /**
     *
     * Appointment methods
     */

    @FXML private ChoiceBox<String> timeChoiceBox;
    @FXML private ChoiceBox<Object> patientChoiceBox;
    @FXML private ChoiceBox<String> vaccineChoiceBox;

    public void timeSelection() {
        if (timeChoiceBox.getItems().isEmpty()){
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



    public void patientSelection(){
        //this is done in addPatient();
    }


    public void vaccineSelection(){
        if (vaccineChoiceBox.getItems().isEmpty()) {
            vaccineChoiceBox.getItems().add(0, "Phizer");
            vaccineChoiceBox.getItems().add(1, "Moderna");
            vaccineChoiceBox.getItems().add(2, "AstraZennica");
        }
    }


public void vaccineAndTime(){
        vaccineSelection();
        timeSelection();
    }


    public static LinkedList<Appointment> appointments;
    @FXML private ListView appointmentListView;

    public void addAppointment(Appointment appointment){
        appointments.addElement(appointment);
    }

    public void removeAllAppointments(){
        appointments.deleteList();
    }

    public void resetAppointments(){
        appointmentListView.getItems().clear();
        removeAllAppointments();
        //updates the number of booths

        //centerListNo.setText("There are " + numberOfCenters() + " Booths");


    }
    public void addAppointmentDetails(ActionEvent event){
        appointmentListView.getItems().addAll(patientChoiceBox.getSelectionModel().getSelectedItem()+" "+timeChoiceBox.getSelectionModel().getSelectedItem()+" "+vaccineChoiceBox.getSelectionModel().getSelectedItem());

        //backend
        addAppointment(new Appointment(Integer.parseInt(timeChoiceBox.getValue()),appointments.printList()));
        System.out.println(patientChoiceBox.getSelectionModel().getSelectedItem() +"\n"+ timeChoiceBox.getSelectionModel().getSelectedItem()  +"\n"+  vaccineChoiceBox.getSelectionModel().getSelectedItem());

    }
    /**
     *
     *Vaccination Record
     *  *search by pps number
     */
@FXML ListView searchListView;
@FXML TextField search;
    public void searchVaccinationRecord(){
        //have the button set the search variable to what's written
        searchListView.getItems().addAll(patients.toString().matches(ppsNumber.getText()));
    }

//    @FXML
//    public void addPatientMenu(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(Main.class.getResource("addpatient.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//
//    }
//
//    @FXML
//    public void addBoothMenu(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(Main.class.getResource("addBooth.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//
//    }
//
//    @FXML
//    public void addCenterMenu(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(Main.class.getResource("addCenter.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//
//    }
//
//
//
//
//    @FXML public void back(ActionEvent event)throws IOException{
//
//        Parent root = FXMLLoader.load(Main.class.getResource("main1.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    @FXML public void exit(){
//        System.exit(0);
//    }




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