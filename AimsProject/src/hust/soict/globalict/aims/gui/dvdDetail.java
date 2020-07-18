package hust.soict.globalict.aims.gui;

import java.io.IOException;

import hust.soict.globalict.aims.PlayerException;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class dvdDetail {
	private DigitalVideoDisc dvd;
	@FXML
	TextField idTextField;
	@FXML
	TextField titleTextField;
	@FXML
	TextField categoryTextField;
	@FXML
	TextField costTextField;
	@FXML
	TextField lengthTextField;
	@FXML
	TextField directorTextField;
	
	public void setDVD(DigitalVideoDisc dvd) {
		idTextField.setText(dvd.getId());
		titleTextField.setText(dvd.getTitle());
		categoryTextField.setText(dvd.getCategory());
		costTextField.setText(String.valueOf(dvd.getCost()));
		lengthTextField.setText(String.valueOf(dvd.getLength()));
		directorTextField.setText(dvd.getDirector());
		
		idTextField.setEditable(false);
		titleTextField.setEditable(false);
		categoryTextField.setEditable(false);
		costTextField.setEditable(false);
		lengthTextField.setEditable(false);
		directorTextField.setEditable(false);
		
		this.dvd = dvd;
	}
	
	public void back(ActionEvent event) throws IOException {
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		
		stage.close();
	}
	public void play(ActionEvent e) throws PlayerException, IOException{
		if(dvd.getLength()>0) {
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("playDVD.fxml"));
			Pane layout = loader.load();
			Scene scene = new Scene(layout);
			
			playDVD controller = loader.getController();
			controller.setDVD(dvd);
			stage.setScene(scene);
			stage.show();
		}
		else {
			throw new PlayerException("DVD length is non-positive");
		}
	}
}
