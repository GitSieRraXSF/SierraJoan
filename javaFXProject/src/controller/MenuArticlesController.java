package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class MenuArticlesController {

	@FXML
    private Button btnImprimir;

    @FXML
    private Button btnMenup;

    @FXML
    private Button btnRegister;

    @FXML
    private CheckBox chkAvailability;

    @FXML
    private TextField txtAuthorArt;

    @FXML
    private TextField txtISSNArt;

    @FXML
    private TextField txtTitleArt;

    @FXML
    private TextField txtYearArt;

    @FXML
    void goToMainMenu(ActionEvent event) {

    	
    }

    @FXML
    void registerArticle(ActionEvent event) {

    	String titulo = txtTitleArt.getText().trim();
    	String autor = txtAuthorArt.getText().trim();
    	String añoStr = txtYearArt.getText().trim();
    	String ISSNStr = txtISSNArt.getText().trim();
    	boolean disponible = chkAvailability.isSelected();
    	
    	if (titulo.isEmpty() || autor.isEmpty() || añoStr.isEmpty() || ISSNStr.isEmpty()) {
            mostrarAlerta("Error", "Campos vacíos", "Por favor, complete todos los campos.");
            return;
        }
    }

    @FXML
    void showAvailableArticles(ActionEvent event) {

    	
    }
    
    private void mostrarAlerta(String titulo, String cabecera, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(cabecera);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
}