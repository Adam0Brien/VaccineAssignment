package adamobrien.vaccineassignment.Utils;

public class Utilities {

    public static boolean max10Chars(String string) {
        return (string.length() <= 10) ? true : false;   // makes it so a string can only be 30 characters or less
    }

    public static boolean max15Chars(String string) {
        return string.length() <= 15;   // makes it so a string can only be 10 characters or less
    }

    public static boolean validPatientName(Object obj) {
        return obj.toString().length() <= 15;   // makes it so a string can only be 10 characters or less
    }

    public static boolean validPPS(String ppsNumber) {

        if (ppsNumber.length() == 9) {
            return ppsNumber.substring(0, 7).matches("[0-9]+") &&
                    (ppsNumber.substring(7, 9).matches("[A-Za-z]+"));


        }
        return false;// only want it to return true if it works
        //Used this to shorten code : https://en.wikipedia.org/wiki/Regular_expression#Patterns

   /* took code from onlyContainsNumbers from assignment 1 and and added a
      .substring to only make it apply to certain parts of the code then added a .length
       to make sure it an only be 9 characters long*/
    }

    public static boolean validEmail(String email) {

        if (email.contains("@") && (email.contains(".com")))
            return true;
        else {
            return false;
        }
    }


    public static boolean validEircode(String eircode){
        if(eircode.length() == 7 ){ //every eircode is
            return eircode.substring(1).matches("[A-Za-z]") && //first one must be letter
                    (eircode.substring(2,3).matches("[0-9]+"));//second 2 must be letters
        }
        return false;


    }

    public static boolean validBoothNumber(int booths){

        if(booths >0){
            return true;
        }
        return false;
    }

    public static boolean validAccesibility(String Accessibility){
        if (Accessibility.matches("Wheelchair Access Required")){
            return true;
        }
        if(Accessibility.matches("None")){
            return true;
        }
        return false;
    }

    public static boolean validFloorLevel(String Floor){
        if(Floor.matches("Ground")){
            return true;
        }
        if(Floor.matches("Floor 1")) {
        return true;
        }
        if(Floor.matches("Floor 2")) {
            return true;
        }
        if(Floor.matches("Floor 3")) {
            return true;
        }
        if(Floor.matches("Floor 4")) {
            return true;
        }
        return false;
    }


    public static boolean validBatchNo(int batchNo){

        if(batchNo < 10000){

            return true;
        }

        return false;

    }





}