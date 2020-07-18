package hust.soict.globalict.aims.gui;

import java.io.IOException;

import hust.soict.globalict.aims.PlayerException;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.Track;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class cdDetail {
	private CompactDisc cd;
	@FXML
	private TextField idTextField;
	@FXML
	private TextField titleTextField;
	@FXML
	private TextField categoryTextField;
	@FXML
	private TextField costTextField;
	@FXML
	private TextField directorTextField;
	@FXML
	private TextField artistTextField;
	@FXML
	private TextField lengthTextField;
	
	public void setCD(CompactDisc cd) {
		idTextField.setText(cd.getId());
		titleTextField.setText(cd.getTitle());
		categoryTextField.setText(cd.getCategory());
		costTextField.setText(String.valueOf(cd.getCost()));
		directorTextField.setText(cd.getDirector());
		artistTextField.setText(cd.getArtist());
		lengthTextField.setText(String.valueOf(cd.getLength()));
		
		idTextField.setEditable(false);
		titleTextField.setEditable(false);
		categoryTextField.setEditable(false);
		costTextField.setEditable(false);
		directorTextField.setEditable(false);
		artistTextField.setEditable(false);
		lengthTextField.setEditable(false);
		this.cd = cd;
	}
	
	public void back(ActionEvent event) throws IOException {
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		
		stage.close();
	}
	public void play(ActionEvent e) throws PlayerException, IOException{
		if(cd.getLength()>0) {
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("playCD.fxml"));
			Pane layout = loader.load();
			Scene scene = new Scene(layout);
			
			playCD controller = loader.getController();
			controller.setCD(cd);
			java.util.Iterator iterator = cd.getTracks().iterator();
			Track nextTrack;
			while(iterator.hasNext()) {
				nextTrack = (Track) iterator.next();
				
				nextTrack.play();
			}
			stage.setScene(scene);
			stage.show();
		}
		else {
			throw new PlayerException("DVD length is non-positive");
		}
	}
}
