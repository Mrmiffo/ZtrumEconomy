package application;

import java.io.IOException;
import java.util.List;

import bookkeeping.Book;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainScreenController extends AnchorPane {

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
	private ChoiceBox<Book> bookMenu;

	
	public MainScreenController(List<Book> books){
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
        try {
        	fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        bookMenu.getItems().addAll(books);
        bookMenu.getSelectionModel().selectedIndexProperty().addListener(
    		new ChangeListener<Number>() {
            public void changed(ObservableValue ov, Number value, Number new_value) {
            	try {
					updateAllScreensWithBook(getSelectedBook());
				} catch (NoSuchBookException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
            }});       
        
	}
	
	public MainScreenController(List<Book> books, Book selectedBook){
		this(books);
		setSelectedBook(selectedBook);
	}
	
	public void initialize(){
//		registerButton();
	}
	
	public void setSelectedBook(Book book) {
		bookMenu.getSelectionModel().select(book);
	}
	
	/**
	 * Used by the BookMenu to update all screens with the new book.
	 * @param book
	 */
	private void updateAllScreensWithBook(Book book){
		if (bookMenu.getItems().contains(book)){
            if (centerPanel.getChildren().size() != 0){
            	try {
            		for (Node screen: centerPanel.getChildren())
					((AbstractCenterScreen)screen).setBook(getSelectedBook());
				} catch (NoSuchBookException e) {
					// TODO Error if no book exist.
					System.out.println(e.getMessage());
				}
            }
			
		}
	}
	
	private Book getSelectedBook() throws NoSuchBookException{
		if (bookMenu.getSelectionModel().getSelectedIndex() == -1){
			throw new NoSuchBookException("No book selected");
		}
		return bookMenu.getItems().get(bookMenu.getSelectionModel().getSelectedIndex());
	}

	@FXML
	private void registerButton(){
		ScrollPane registerTransactionScreen;
		try {
			registerTransactionScreen = new RegisterTransaction(getSelectedBook());
			centerPanel.getChildren().setAll(registerTransactionScreen);
		} catch (NoSuchBookException e) {
			// TODO Add error message
			e.printStackTrace();
		}
		
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
	
	@FXML
	private void menuButtonSelection(){

	}
}
