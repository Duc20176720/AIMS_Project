package hust.soict.globalict.aims.gui;

import java.io.IOException;

import hust.soict.globalict.aims.media.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class bookDetail {
	@FXML
	private TextField idTextField;
	@FXML
	private TextField titleTextField;
	@FXML
	private TextField categoryTextField;
	@FXML
	private TextField costTextField;
	@FXML
	private TextField author1TextField;
	@FXML
	private TextField author2TextField;
	@FXML
	private TextField author3TextField;
	
	public void setBook(Book book) {
		idTextField.setText(book.getId());
		titleTextField.setText(book.getTitle());
		categoryTextField.setText(book.getCategory());
		costTextField.setText(String.valueOf(book.getCost()));
		author1TextField.setText(book.getAuthors().get(0));
		author2TextField.setText(book.getAuthors().get(1));
		author3TextField.setText(book.getAuthors().get(2));
		
		idTextField.setEditable(false);
		titleTextField.setEditable(false);
		categoryTextField.setEditable(false);
		costTextField.setEditable(false);
		author1TextField.setEditable(false);
		author2TextField.setEditable(false);
		author3TextField.setEditable(false);
	}
	
	public void back(ActionEvent event) throws IOException {
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		
		stage.close();
	}
}
