package adamobrien.vaccineassignment.Models;


import adamobrien.vaccineassignment.Utils.Utilities;

public class Vaccine{

        public String type;
        public int batchNo;

    /**
     *  If a patient has some sort of vaccine details searching for vaccinated patients would be easier
     *  because you could use .contains(batchNo)
     *
     * It would also be good to use this class for adding new vaccines when they are released
     *
     */




    public Vaccine( String type , int batchNo){


        if(Utilities.max15Chars(type)){
            this.type = type;
        }else{
            this.type = " ";
        }



        if(Utilities.validBatchNo(batchNo)){
            this.batchNo = batchNo;
        }else{
            this.batchNo = 0;
        }


    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(int batchNo) {
        this.batchNo = batchNo;
    }

    @Override
    public String toString() {
        return "Vaccine{" +
                "type='" + type + '\'' +
                ", batchNo=" + batchNo +
                '}';
    }
}
