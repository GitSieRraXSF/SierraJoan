package controller;

import application.Main;
import data.BookDataManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Articles;

public class ArticleVistaController {

    @FXML
    private Button RetrocederAtras;

    @FXML
    private TableView<?> TableView1;

    @FXML
    private Button btnMenup;

    @FXML
    private TableColumn<?, ?> colAutor;

    @FXML
    private TableColumn<?, ?> colISSN;

    @FXML
    private TableColumn<?, ?> colTitulo;

    @FXML
    private TableColumn<?, ?> colYear;
    
    private BookDataManager ArticlesManager = BookDataManager.getInstance();

    
    public void initialize() {
    	
    	ObservableList<Articles> Articulos = FXCollections.observableArrayList();
    }
    
    
    @FXML
    void OutBack(ActionEvent event) {

    	Main.loadScene("/view/MenuArticules.fxml");
    }

    @FXML
    void goToMainMenu(ActionEvent event) {

    	Main.loadScene("/view/MenuPrincipal.fxml");
    }
}