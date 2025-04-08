package controller;

import java.sql.Connection;

import application.Main;
import data.BookDAO;
import data.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Book;

public class LibroryVistaController {

    @FXML
    private Button RetrocederAtras;

    @FXML
    private TableView<Book> TableView1;

    @FXML
    private Button btnMenup, Elimibook;
    
    @FXML
    private TableColumn<Book, String> colAutor;

    @FXML
    private TableColumn<Book, Long> colISBN;

    @FXML
    private TableColumn<Book, String> colTitulo;

    @FXML
    private TableColumn<Book, Integer> colYear;
    
    // Singleton Connection
 	private Connection connection = DatabaseConnection.getInstance().getConnection();
 	// BookDAO Instance
 	private BookDAO bookDAO = new BookDAO(connection);

    @FXML
    public void initialize() {
    	
    	ObservableList<Book> books = FXCollections.observableArrayList();
    	
    	for (Book book:bookDAO.fetch()) {
    		if (book.isDisponible()) {
    			books.add(book);
    		}
    	}
    	
    	colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
		colAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
		colISBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
		colYear.setCellValueFactory(new PropertyValueFactory<>("año"));
		TableView1.setItems(books);
    }
    
    @FXML
    public void BorrarBook(ActionEvent event) {
    	Book book = TableView1.getSelectionModel().getSelectedItem();
    	bookDAO.delete(book.getISBN());
    	initialize();
    }
    
    @FXML
    void OutBack(ActionEvent event) {
    	
    	Main.loadScene("/view/MenuBook.fxml");
    }

    @FXML
    void goToMainMenu(ActionEvent event) {
    	
    	Main.loadScene("/view/MenuPrincipal.fxml");
    }
}