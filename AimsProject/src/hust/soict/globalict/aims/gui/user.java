package hust.soict.globalict.aims.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class user {
	public void customer(ActionEvent e) throws IOException {
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("scene1.fxml"));
		Pane layout = loader.load();
		Scene scene = new Scene(layout);
		
		stage.setScene(scene);
		stage.show();
	}
	
	public void admin(ActionEvent e)throws IOException {
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("mediaManager.fxml"));
		Pane layout = loader.load();
		Scene scene = new Scene(layout);
		
		stage.setScene(scene);
		stage.show();
	}
	
	public void dvd(ActionEvent e)throws IOException {
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("adminDVD.fxml"));
		Pane layout = loader.load();
		Scene scene = new Scene(layout);
		
		stage.setScene(scene);
		stage.show();
	}
	
	public void cd(ActionEvent e)throws IOException {
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("adminCD.fxml"));
		Pane layout = loader.load();
		Scene scene = new Scene(layout);
		
		stage.setScene(scene);
		stage.show();
	}
	
	public void book(ActionEvent e)throws IOException {
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("adminBook.fxml"));
		Pane layout = loader.load();
		Scene scene = new Scene(layout);
		
		stage.setScene(scene);
		stage.show();
	}
	
	public void exit(ActionEvent e) throws IOException{
		Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
		
		stage.close();
	}
}
