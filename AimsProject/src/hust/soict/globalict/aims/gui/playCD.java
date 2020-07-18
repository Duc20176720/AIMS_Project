package hust.soict.globalict.aims.gui;

import java.io.IOException;

import hust.soict.globalict.aims.media.CompactDisc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class playCD {
	@FXML
	private TextField titleTextField;
	@FXML
	private TextField lengthTextField;
	
	public void setCD(CompactDisc cd) {
		titleTextField.setText(cd.getTitle());
		lengthTextField.setText(String.valueOf(cd.getLength()));
		
		titleTextField.setEditable(false);
		lengthTextField.setEditable(false);
	}
	public void back(ActionEvent event) throws IOException {
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		
		stage.close();
	}
}
