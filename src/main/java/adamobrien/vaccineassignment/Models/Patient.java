    package adamobrien.vaccineassignment.Models;

    import adamobrien.vaccineassignment.ADT.LinkedList;
    import adamobrien.vaccineassignment.Utils.Utilities;
    import javafx.fxml.FXML;

    public  class Patient {

        public String name,DOB, email, ppsNumber;
        public LinkedList<VaccineRecord> vaccine;
        public LinkedList<VaccineRecord> record;




        // each patient will be assigned to an appointment

        // vr = vaccination record (each patient can have multiple vaccines)

        public Patient(String name,String DOB, String email, String ppsNumber) {
            if (Utilities.max15Chars(name)) {
                this.name = name;
            } else {
                this.name = "Invalid Name";
            }

            if (Utilities.validPPS(ppsNumber)) {
                this.ppsNumber = ppsNumber;
            } else {
                this.ppsNumber = "0000000XX";
            }

            if (Utilities.validEmail(email)) {
                this.email = email;
            } else {
                this.email = "Invalid email";
            }

            if(Utilities.max15Chars(DOB)){
                this.DOB=DOB;
            }else {
                this.DOB = "1-Jan-2000";
            }

            this.record = new LinkedList<>();



        }


        public String getName() {
            return name;
        }

        @FXML
        public void setName(String name) {
            this.name = name;
        }

        public String getDOB() {
            return DOB;
        }

        public void setDOB(String DOB) {
            this.DOB = DOB;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPpsNumber() {
            return ppsNumber;
        }

        public void setPpsNumber(String ppsNumber) {
            this.ppsNumber = ppsNumber;
        }



        @Override
        public String toString() {
            return "patient{" +
                    "name='" + name + '\'' +
                    ", DOB='" + DOB + '\'' +
                    ", email='" + email + '\'' +
                    ", ppsNumber='" + ppsNumber + '\'' +
                    '\'' +
                    '}';
        }
    }
