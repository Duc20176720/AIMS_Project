package hust.soict.globalict.aims.gui;

import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.Track;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class getTrack {
	private List<Track> listTrack = new ArrayList<Track>();
	private CompactDisc cd;
	@FXML
	private TextField trackField;
	
	public void listTrack() {
		Track tr1 = new Track("first", 17);
		Track tr2 = new Track("second", 12);
		Track tr3 = new Track("third", 15);
		listTrack.add(tr1);
		listTrack.add(tr2);
		listTrack.add(tr3);
	}
	
	public void setCD(CompactDisc cd) {
		this.cd= cd;
	}
	
	public void addTrack(ActionEvent event) {
		listTrack();
		String[] inputTrack = trackField.getText().split(" ");
		for(int i=0; i<inputTrack.length; i++) {
			for(Track t: listTrack) {
				if(t.getTitle().equals(inputTrack[i])) {
					cd.addTrack(t);
				}
			}
		}
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		
		stage.close();
	}
	
}
