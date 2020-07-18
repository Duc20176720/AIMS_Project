package hust.soict.globalict.aims.gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Stream;

import hust.soict.globalict.aims.media.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class controller implements Initializable {
	@FXML
	private TableView<Media> table;
	@FXML
	private TableColumn<Media, String>  idColumn;
	@FXML
	private TableColumn<Media, String> titleColumn;
	@FXML
	private TableColumn<Media, String> categoryColumn;
	@FXML
	private TableColumn<Media, Double> costColumn;
	
	@FXML
	private TextField idTextField;
	
	private ObservableList<Media> orderList;
	
	private List<Media> listMedia = new ArrayList<Media>();
	private List<String> listID = new ArrayList<String>();
	private List<Track> listTrack = new ArrayList<Track>();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		orderList = FXCollections.observableArrayList();
		idColumn.setCellValueFactory(new PropertyValueFactory<Media, String>("id"));
		titleColumn.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		categoryColumn.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		costColumn.setCellValueFactory(new PropertyValueFactory<Media, Double>("cost"));
		table.setItems(orderList);
	}
	
	public void listMedia() {
		
		File fileDVD = new File("/home/xuanduc/Documents/Eclipse/AimsProject/src/hust/soict/globalict/aims/gui/dvd.txt");
		File fileCD = new File("/home/xuanduc/Documents/Eclipse/AimsProject/src/hust/soict/globalict/aims/gui/cd.txt");
		File fileBook = new File("/home/xuanduc/Documents/Eclipse/AimsProject/src/hust/soict/globalict/aims/gui/book.txt");
		
		try{
			FileInputStream input = new FileInputStream(fileDVD);
			byte buffDVD[]= new byte[1024];
			int length = input.read(buffDVD);
			String para = new String(buffDVD, 0, length);
			
			String line[]= para.split("\n");
			for(String l:line) {
				String words[] = l.split("/");
				DigitalVideoDisc dvd = new DigitalVideoDisc(words[0], words[1], words[2], Double.parseDouble(words[3]), Integer.parseInt(words[4]), words[5]);
				listMedia.add(dvd);
			}
			
			input = new FileInputStream(fileCD);
			byte buffCD[] = new byte[1024];
			length = input.read(buffCD);
			para = new String(buffCD, 0, length);
			
			String line1[]= para.split("\n");
			for(String l:line1) {
				String words[] = l.split("/");
				CompactDisc cd = new CompactDisc(words[0], words[1], words[2], Double.parseDouble(words[3]), words[4], words[5]);
				listMedia.add(cd);
			}
			
			input = new FileInputStream(fileBook);
			byte buffBook[] = new byte[1024];
			length = input.read(buffBook);
			para = new String(buffBook, 0, length);
			
			String line3[]= para.split("\n");
			for(String l:line3) {
				String words[] = l.split("/");
				Book b = new Book(words[0], words[1], words[2], Double.parseDouble(words[3]));
				b.addAuthor(words[4]);
				b.addAuthor(words[5]);
				b.addAuthor(words[6]);
				listMedia.add(b);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Track tr1 = new Track("first", 17);
		Track tr2 = new Track("second", 12);
		Track tr3 = new Track("third", 15);
		
		for (Media m:listMedia) {
			listID.add(m.getId());
		}
		
		listTrack.add(tr1);
		listTrack.add(tr2);
		listTrack.add(tr3);
		
	}
	
	public void add(ActionEvent event) {
		listMedia();
		String idInput = idTextField.getText();
		if(idInput.equals("")) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("NOTE");
			alert.setContentText("Please enter the ID item !");
			alert.show();
		}else {
			if(listID.contains(idInput)==false) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("NOTE");
				alert.setContentText("ID is not existed!");
				alert.show();
			}
			if(listID.contains(idInput)==true) {
				if(idInput.contains("dvd") || idInput.contains("b")) {
					for(Media m:listMedia) {
						if(m.getId().equals(idInput)) {
							orderList.add(m);
						}
					}
				}
				if(idInput.contains("cd")) {
					try {
						Stage stage = new Stage();
						FXMLLoader loader = new FXMLLoader();
						loader.setLocation(getClass().getResource("getTrack.fxml"));
						Pane layout = loader.load();
						Scene scene = new Scene(layout);
						getTrack data = loader.getController();
						
						for(Media m: listMedia) {
							if(m.getId().equals(idInput)) {
								CompactDisc cd = (CompactDisc) m;
								data.setCD(cd);
								orderList.add(cd);
							}
						}
						
						stage.setScene(scene);
						stage.show();
					} catch(Exception e) {
						e.printStackTrace();
					}
					
				}
			}
		}
		
		listMedia.clear();
	}
	
	public void remove(ActionEvent event) {
		listMedia();
		String idInput = idTextField.getText();
		if(idInput.equals("")) {
			
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("NOTE");
			alert.setContentText("Please enter the ID item !");
			alert.show();
		}else {
			if(listID.contains(idInput)==false) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("NOTE");
				alert.setContentText("ID is not existed!");
				alert.show();
			}
			if(listID.contains(idInput)==true) {
				for(int i = 0; i < orderList.size();i++) {
					if(orderList.get(i).getId().equals(idInput)) {
						for(Media m:listMedia) {
							if(m.getId().equals(idInput)) {
								orderList.remove(m);
							}
						}
					}else {
						Alert alert = new Alert(Alert.AlertType.INFORMATION);
						alert.setTitle("NOTE");
						alert.setContentText("ID is not existed in your list order!");
						alert.show();
					}
				}
			}
		}
		listMedia.clear();
	}
	
	public void totalCost(ActionEvent event) {
		Double total = 0.0;
		for(Media m: orderList) {
			total += m.getCost();
		}
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("NOTE");
		alert.setContentText("Total cost: "+ total);
		alert.show();
		
	}
	
	public void printMedia(ActionEvent event) {
		listMedia();
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("NOTE");
		alert.setContentText("The Lion King - dvd1"+ "\n"+
				"Star War - dvd2"+ "\n"+
				"Aladdin - dvd3"+"\n"+
				"Harry Potter - b1"+"\n"+
				"The Lightning Thief - b2"+"\n"+
				"Twilight - b3"+"\n"+
				"a - cd1"+"\n"+
				"b - cd2"+"\n"+
				"c - cd3"+ "\n"
				);
		alert.setHeaderText("List of Media and ID:");
		alert.show();
//		for(Media m:listMedia) {
//			System.out.println(m.getTitle() + " - " + m.getCost());
//		}
		listMedia.clear();
	}
	public void getDetail(ActionEvent event) throws IOException {
		Media selected = table.getSelectionModel().getSelectedItem();
		if(selected.getId().contains("dvd")) {
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("detailDVD.fxml"));
			Pane layout = loader.load();
			Scene scene = new Scene(layout);
			
			dvdDetail data = loader.getController();
			DigitalVideoDisc dvd =  (DigitalVideoDisc) selected;
			data.setDVD(dvd);

			stage.setScene(scene);
			stage.show();

		}
		if(selected.getId().contains("b")) {
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("detailBook.fxml"));
			Pane layout = loader.load();
			Scene scene = new Scene(layout);
			
			bookDetail controller = loader.getController();
			Book b =  (Book) selected;
			controller.setBook(b);
			stage.setScene(scene);
			stage.show();
			
		}
		if(selected.getId().contains("cd")) {
//			CompactDisc cd = (CompactDisc)selected;
//			System.out.println(cd.getLength());
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("detailCD.fxml"));
			Pane layout = loader.load();
			Scene scene = new Scene(layout);
			
			cdDetail controller = loader.getController();
			CompactDisc cd =  (CompactDisc) selected;
			controller.setCD(cd);;
			stage.setScene(scene);
			stage.show();
		}
	}
	
	public void exit(ActionEvent e) throws IOException{
		Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
		
		stage.close();
	}
}
