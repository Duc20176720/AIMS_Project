package hust.soict.globalict.aims;

import javafx.scene.control.Alert;

public class PlayerException extends Exception {

	public PlayerException() {
		// TODO Auto-generated constructor stub
	}

	public PlayerException(String message) {
		super(message);
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("ERROR");
		alert.setHeaderText("NOTE");
		alert.setContentText("DVD length is non-positive");
		alert.show();
		
	}

	public PlayerException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public PlayerException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PlayerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
