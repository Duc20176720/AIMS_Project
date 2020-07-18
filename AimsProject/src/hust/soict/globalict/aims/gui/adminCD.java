package hust.soict.globalict.aims.gui;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class adminCD {
	@FXML
	TextField idTextField;
	@FXML
	TextField titleTextField;
	@FXML
	TextField categoryTextField;
	@FXML
	TextField costTextField;
	@FXML
	TextField directorTextField;
	@FXML
	TextField artistTextField;
	
	public void ok(ActionEvent e) throws IOException{
		File file = new File("/home/xuanduc/Documents/Eclipse/AimsProject/src/hust/soict/globalict/aims/gui/cd.txt");
		FileOutputStream output = new FileOutputStream(file, true);
		String dvdString = idTextField.getText()+"/"+titleTextField.getText()+"/"+categoryTextField.getText()+"/"+costTextField.getText()+"/"+directorTextField.getText()+"/"+artistTextField.getText()+"\n";
		byte buff[]=dvdString.getBytes();
		output.write(buff, 0, buff.length);
		
		idTextField.clear();
		titleTextField.clear();
		categoryTextField.clear();
		costTextField.clear();
		directorTextField.clear();
		artistTextField.clear();
		
		String output1 = new String(buff, 0, buff.length);
		System.out.println(output1);
	}
	
	public void exit(ActionEvent e) throws IOException{
		Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
		
		stage.close();
	}
}
