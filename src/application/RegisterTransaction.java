package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bookkeeping.Book;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class RegisterTransaction extends ScrollPane implements ICenterScreen{

	@FXML
	private TextField titleText;
	@FXML
	private VBox fromPane;
	@FXML
	private VBox toPane;
	@FXML
	private DatePicker dateField;
	
	private List<RegisterInputField> fromInput;
	private List<RegisterInputField> toInput;
	
	public RegisterTransaction(){
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RegisterTransaction.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
        try {
        	fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	public void initialize(){
		fromInput = new ArrayList<>();
		toInput = new ArrayList<>();
		
		fromInput.add(new RegisterInputField());
		toInput.add(new RegisterInputField());
		
		fromPane.getChildren().setAll(fromInput);
		toPane.getChildren().setAll(toInput);

	}

	@Override
	public void setBook(Book book) {
		// TODO Auto-generated method stub
		
	}


}
