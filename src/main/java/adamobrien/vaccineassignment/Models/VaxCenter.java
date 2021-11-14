package adamobrien.vaccineassignment.Models;


import adamobrien.vaccineassignment.ADT.LinkedList;
import adamobrien.vaccineassignment.Utils.Utilities;

public class VaxCenter {

    //public LinkedList<booths> booths = new LinkedList<>();
    //public int noOfParkingSpaces;
    public String centreName;
    public String address;
    public String eircode;
    public LinkedList<Booth> booths;

    // create linked list of booths for EACH vaccination center b = booth

    //public LinkedList Location = new LinkedList();


    public VaxCenter(String centerName,String address , String eircode , LinkedList booths) {
        //this.booths = booths;
        //this.noOfParkingSpaces = noOfParkingSpaces;
        if(Utilities.max15Chars(centerName)){
            this.centreName = centerName;
        }

        this.address = address;



       if(Utilities.validEircode(eircode)){
           this.eircode = eircode;
       } else{
           this.eircode = "invalid";
       }

       this.booths = booths;
    }

//    public LinkedList<models.booths> getBooths() {
//        return booths;
//    }
//
//    public void setBooths(LinkedList<models.booths> booths) {
//        this.booths = booths;
//    }

//    public int getNoOfParkingSpaces() {
//        return noOfParkingSpaces;
//    }
//
//    public void setNoOfParkingSpaces(int noOfParkingSpaces) {
//        this.noOfParkingSpaces = noOfParkingSpaces;
//    }


    public String getCentreName() {
        return centreName;
    }

    public void setCentreName(String centreName) {
        this.centreName = centreName;
    }

    public LinkedList<Booth> getBooths() {
        return booths;
    }

    public void setBooths(LinkedList<Booth> booths) {
        this.booths = booths;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEircode() {
        return eircode;
    }

    public void setEircode(String eircode) {
        this.eircode = eircode;
    }


    @Override
    public String toString() {
        return "vaxCenter{" +
                //"booths=" + booths +
               // ", noOfParkingSpaces=" + noOfParkingSpaces +
                ", address='" + address + '\'' +
                ", eircode='" + eircode + '\'' +
                '}';
    }


    /* no two locations can be the same
* use toUppercase when setting a location to combat case sensitivity
*
*
*
* */


}
