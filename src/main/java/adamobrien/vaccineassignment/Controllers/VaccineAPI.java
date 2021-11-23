package adamobrien.vaccineassignment.Controllers;

import adamobrien.vaccineassignment.ADT.LinkedList;
import adamobrien.vaccineassignment.Models.VaccineRecord;

public class VaccineAPI {


        public static LinkedList<VaccineRecord> vaccines;

        public VaccineAPI(){
            this.vaccines = new LinkedList<>();

        }

        public LinkedList<VaccineRecord> getVaccines(){
            return vaccines;
        }

        public void addVaccine(VaccineRecord vaccine){
            vaccines.addElement(vaccine);
        }

        public void removeVaccine(int index){

            vaccines.delete(index);
        }

        public void removeAllVaccines(){
            vaccines.deleteList();
        }



    }
