package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainScreenController {

	//Panels
	@FXML
	private HBox titleBox;
	@FXML
	private HBox centerPanel;
	@FXML
	private GridPane bottomPanel;
	@FXML
	private VBox buttonPanel;
	
	//Controls
	@FXML
	private Label title;
	@FXML
	private Button registerButton;
	@FXML
	private Button historyButton;
	@FXML
	private Button graphButton;
	@FXML
	private Button settingsButton;
	
	public MainScreenController(){

	}
	
	public void initialize(){
		registerButton();
	}
	
	@FXML
	private void registerButton(){
		ScrollPane registerTransactionScreen = new RegisterTransactionController();
		centerPanel.getChildren().setAll(registerTransactionScreen);
	}
	
	@FXML
	private void historyButton(){
		
	}
	
	@FXML
	private void graphButton(){
		
	}
	
	@FXML
	private void settingsButton(){
		
	}
}
