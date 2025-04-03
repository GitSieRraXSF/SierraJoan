package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MenuBibliotecaController {

    @FXML
    private Button btoArt;

    @FXML
    private Button btoBooK;

    @FXML
    private VBox root;

    @FXML
    void gotoMenuArticles(ActionEvent event) {

    	Main.loadScene("/view/MenuArticles.fxml");
    }

    @FXML
    void gotoMenuBook(ActionEvent event) {

    	Main.loadScene("/view/MenuBook.fxml");
    }

}