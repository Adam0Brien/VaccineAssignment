module adamobrien.vaccineassignment {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires xstream;

    opens adamobrien.vaccineassignment to javafx.fxml, xstream;
    opens adamobrien.vaccineassignment.Controllers to javafx.fxml ,xstream;
    opens adamobrien.vaccineassignment.Models to javafx.fxml, xstream;
    opens adamobrien.vaccineassignment.Utils to javafx.fxml, xstream;
    opens adamobrien.vaccineassignment.ADT to javafx.fxml, xstream;

    exports adamobrien.vaccineassignment.Models;
    exports adamobrien.vaccineassignment.Utils;
    exports adamobrien.vaccineassignment.ADT;
    exports adamobrien.vaccineassignment.Controllers;
    exports adamobrien.vaccineassignment;
}