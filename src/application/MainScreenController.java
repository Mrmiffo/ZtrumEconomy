package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class MainScreenController {

	@FXML
	private Label title;
	@FXML
	private AnchorPane centerPanel;
	@FXML
	private ScrollPane rightPanel;
	@FXML
	private GridPane bottomPanel;
	
	private AnchorPane registerTransactionScreen;
	
	public MainScreenController(){
		try {
			registerTransactionScreen = FXMLLoader.load(getClass().getResource("RegisterTransaction.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("derp");
	}
	
	@FXML
	private void registerTransaction(){
		centerPanel.getChildren().setAll(registerTransactionScreen);
	}
}
