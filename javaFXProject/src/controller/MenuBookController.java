package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import model.Book;

import java.sql.Connection;

import application.Main;
import data.BookDAO;
import data.DatabaseConnection;

public class MenuBookController {

	@FXML
	private TextField txtTitle;

	@FXML
	private TextField txtAuthor;

	@FXML
	private TextField txtYear;

	@FXML
	private CheckBox chkAvailability;

	@FXML
	private TextField txtISBN;

	@FXML
	private Button btnRegister;

	@FXML
	private Button btnImprimir;

	@FXML
	private Button btnMenup;

	// Singleton Connection
	private Connection connection = DatabaseConnection.getInstance().getConnection();
	// BookDAO Instance
	private BookDAO bookDAO = new BookDAO(connection);

	@FXML
	void registerBook(ActionEvent event) {
		String titulo = txtTitle.getText().trim();
		String autor = txtAuthor.getText().trim();
		String añoStr = txtYear.getText().trim();
		String isbnStr = txtISBN.getText().trim();
		boolean disponible = chkAvailability.isSelected();

		if ((titulo.isEmpty() || autor.isEmpty()) || (añoStr.isEmpty() || isbnStr.isEmpty())) {
			mostrarAlerta("Error", "Campos vacíos", "Por favor, complete todos los campos.");
			return;
		}

		try {
			long ISBN = Long.parseLong(isbnStr);
			int año = Integer.parseInt(añoStr);

			if (!Book.validarISBN(ISBN)) {
				mostrarAlerta("Error", "ISBN inválido", "El ISBN debe tener 13 dígitos y comenzar con '978'.");
				return;
			}

			if (!Book.validarAño(año)) {
				mostrarAlerta("Error", "Año inválido", "El año debe estar entre 800 a. C. y 2025 d. C.");
				return;
			}

			if (bookDAO.authenticate(ISBN)) {
				mostrarAlerta("Error", "ISBN repetido", "El ISBN ya está registrado.");
				return;
			}

//			for (Book book : bookDAO.fetch()) {
//				if (book.getISBN() == ISBN) {
//					mostrarAlerta("Error", "ISBN repetido", "El ISBN ya está registrado.");
//					return;
//				}
//			}

			Book book = new Book(titulo, autor, ISBN, año, disponible);
			bookDAO.save(book);
			// bookManager.addBook(book);
			mostrarAlerta("Éxito", "Libro registrado", "El libro se ha registrado correctamente.");
			limpiarCampos();
		} catch (NumberFormatException e) {
			mostrarAlerta("Error", "Formato inválido", "El año y el ISBN deben ser números válidos.");
		}
	}

	@FXML
	void showAvailableBooks(ActionEvent event) {
		Main.loadScene("/view/LibroryVista.fxml");
	}

	@FXML
	void goToMainMenu(ActionEvent event) {
		Main.loadScene("/view/MenuPrincipal.fxml");
	}

	private void mostrarAlerta(String titulo, String cabecera, String mensaje) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(titulo);
		alert.setHeaderText(cabecera);
		alert.setContentText(mensaje);
		alert.showAndWait();
	}

	private void limpiarCampos() {
		txtTitle.clear();
		txtAuthor.clear();
		txtYear.clear();
		txtISBN.clear();
		chkAvailability.setSelected(false);
	}
}