package adamobrien.vaccineassignment.Models;

import adamobrien.vaccineassignment.Utils.Utilities;

import java.util.Objects;

public class Appointment {


    public int time;
    public String vaccine;


    public Appointment(int time, String vaccine) {


        this.time = time;

        this.vaccine = vaccine;

    }





    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }




    @Override
    public String toString() {
        return "Appointment{" +
                ", time=" + time +
                ", vaccine='" + vaccine + '\'' +
                '}';
    }
}
