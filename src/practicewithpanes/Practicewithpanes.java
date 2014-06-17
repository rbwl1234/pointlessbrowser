/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicewithpanes;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author rbwl1234
 */
public class Practicewithpanes extends Application {

    private static final String URL_REGEX = "[a-zA-Z]+://[\\.@\\-/_0-9a-zA-Z]+";

    @Override
    public void start(Stage primaryStage) {
        Image refresh = new Image(getClass().getResourceAsStream("refresh.png"));
        ImageView iv1 = new ImageView();
        iv1.setImage(refresh);
        iv1.setFitWidth(50);
        iv1.setPreserveRatio(true);
        WebView browser = new WebView();
        WebEngine webEngine = browser.getEngine();
        Button btn = new Button();
        btn.setGraphic(iv1);
        webEngine.reload();
        TextField addressField = new TextField();
        HBox.setHgrow(addressField, Priority.ALWAYS);
        webEngine.load(addressField.getText());

        btn.setOnAction((ActionEvent event) -> {
            webEngine.load(addressField.getText());
        });

        addressField.setOnAction((ActionEvent event) -> {
            if (!(addressField.getText().matches(URL_REGEX))){
                addressField.setText("http://" + addressField.getText());
            }
            webEngine.load(addressField.getText());

        });

        BorderPane border = new BorderPane();
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");
        border.setTop(hbox);
        hbox.getChildren().add(btn);
        hbox.getChildren().add(addressField);
        border.setCenter(browser);
        Scene scene = new Scene(border, 1000, 1000);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
