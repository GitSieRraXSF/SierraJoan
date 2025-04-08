package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Book;

public class BookDAO implements CRUD_Operation<Book, Long> {

	private Connection connection;

	public BookDAO(Connection connection, BookDAO bookDAO) {
		this.connection = connection;

	}

	public BookDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void save(Book book) {
		String sql = "INSERT INTO Book (title, author, ISBN) VALUES (?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, book.getTitulo());
			stmt.setString(2, book.getAutor());
			stmt.setLong(3, book.getISBN());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Book> fetch() {
		ArrayList<Book> books = new ArrayList<>();
		String sql = "SELECT * FROM Book";
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				String title = rs.getString("title");
				String author = rs.getString("author");
				int year = rs.getInt("year");
				boolean available = rs.getBoolean("available");
				long ISBN = rs.getLong("ISBN");
				books.add(new Book(title, author, ISBN, year, available));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public void update(Book book) {
		String sql = "UPDATE Book SET title=?, author=? WHERE ISBN=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, book.getTitulo());
			stmt.setString(2, book.getAutor());
			stmt.setLong(3, book.getISBN());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Long ISBN) {
		String sql = "DELETE FROM Book WHERE ISBN=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, ISBN);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}