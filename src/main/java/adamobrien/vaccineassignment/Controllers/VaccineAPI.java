package adamobrien.vaccineassignment.Controllers;

import adamobrien.vaccineassignment.ADT.LinkedList;
import adamobrien.vaccineassignment.Models.Vaccine;

public class VaccineAPI {


        public static LinkedList<Vaccine> vaccines;

        public VaccineAPI(){
            this.vaccines = new LinkedList<>();

        }

        public LinkedList<Vaccine> getVaccines(){
            return vaccines;
        }

        public void addVaccine(Vaccine vaccine){
            vaccines.addElement(vaccine);
        }

        public void removeVaccine(int index){

            vaccines.delete(index);
        }

        public void removeAllVaccines(){
            vaccines.deleteList();
        }



    }
