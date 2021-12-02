/**
 * @author Juan Gomez
 * @email jgomezblandon@mail.valenciacollege.edu
 * @date 10/27/2021
 * @repository https://github.com/jgomez-formus/TextCounterFx
 */
package sample;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


public class Controller implements Initializable{
    @FXML
    private Button findFrecuency;
    @FXML
    private TextField pathToFileField;
    @FXML
    private Label pathErrorLabel;
    @FXML
    private TableView tableFrecuency;


    private void findFrecuencyAction()
    {
        findFrecuency.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if(pathToFileField.getText() == ""){
                    pathErrorLabel.setVisible(true);
                    return;
                }
                // Call to process the file, using input as file path
                getFile(pathToFileField.getText());
            }
        });
    }


    public void getFile(String filePath) {
        try {
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            WordOcurrenceModel wordOcurrenceModel = new WordOcurrenceModel();
            HashMap<String, Integer> wordCountHolder = new HashMap<String, Integer>();
            AtomicInteger position = new AtomicInteger(1);

            // Evaluates every word in the file to fin frecuency
            while (sc.hasNext()) {

                String word = sc.next();
                // System.out.println("original string--> " + String.valueOf(word));
                word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                // System.out.println("clear string--> " + String.valueOf(word));
                if (wordCountHolder.containsKey(word)) {
                    wordCountHolder.put(word, wordCountHolder.get(word) + 1);
                } else {
                    wordCountHolder.put(word, 1);
                }

                // Insert Word to Database
                wordOcurrenceModel.insertWord(word);


            }
            wordOcurrenceModel.getResults();


            System.out.println("\n");
            System.out.println("   Word      Frecuency");
            System.out.println("______________________");
            wordCountHolder.entrySet().stream()
                    .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                    .forEach(k -> {
                        System.out.println(position + ". " + k.getKey() + "        " + k.getValue());
                        String frecuency = k.getValue() + "";
                        tableFrecuency.getItems().add(new WordOcurrence(position + ".", k.getKey(), frecuency));
                        position.getAndIncrement();
                    });

        } catch (Exception e) {
            System.out.println(e);

        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Set file path for debugging
        pathToFileField.setText("/Users/amy/Documents/Valencia College/Fall 2021/Mobile Dev/Week 2/TextCounterJuanGomez/poem.txt");

        // Initialize and add the columns with property values
        TableColumn<WordOcurrence, String> column1 = new TableColumn<>("#");
        column1.setCellValueFactory(new PropertyValueFactory<>("ranking"));

        TableColumn<WordOcurrence, String> column2 = new TableColumn<>("Word");
        column2.setCellValueFactory(new PropertyValueFactory<>("word"));

        TableColumn<WordOcurrence, String> column3 = new TableColumn<>("Frecuency");
        column3.setCellValueFactory(new PropertyValueFactory<>("wordCount"));

        tableFrecuency.getColumns().add(column1);
        tableFrecuency.getColumns().add(column2);
        tableFrecuency.getColumns().add(column3);

        findFrecuencyAction();
    }
}


