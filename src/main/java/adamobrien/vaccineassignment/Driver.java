package adamobrien.vaccineassignment;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Driver extends Application {

   @Override
    public void start(Stage stage) throws IOException {
        try{
        FXMLLoader fxmlLoader = new FXMLLoader(Driver.class.getResource("main.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 600, 450);

        //fxmlLoader1.getController();
        stage.setTitle("Vaccination Center");
        stage.setScene(scene);

        stage.show();

        }catch (Exception e){
            e.printStackTrace();
        }
       System.out.println("Working!");
    }

    public static void main(String[] args) {
        launch();
    }
}