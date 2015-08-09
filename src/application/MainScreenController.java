package application;

import java.util.List;

import bookkeeping.Book;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
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
	
	@FXML
	private MenuButton bookMenu;
	
	public MainScreenController(){

	}
	
	public MainScreenController(List<Book> books){
		
	}
	
	public void initialize(){
		registerButton();
	}
	
	@FXML
	private void registerButton(){
		ScrollPane registerTransactionScreen = new RegisterTransaction();
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
