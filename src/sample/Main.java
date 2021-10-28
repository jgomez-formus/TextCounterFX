/**
 * @author Juan Gomez
 * @email jgomezblandon@mail.valenciacollege.edu
 * @date 10/27/2021
 * @repository https://github.com/jgomez-formus/TextCounterFx
 */
package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Word Occurrences");
        primaryStage.setScene(new Scene(root, 500, 800));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
