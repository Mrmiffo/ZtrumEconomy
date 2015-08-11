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

public class RegisterTransaction extends AbstractCenterScreen{

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
	
	private Book activeBook;
	
	public RegisterTransaction(Book book) throws NoSuchBookException{
		fromInput = new ArrayList<>();
		toInput = new ArrayList<>();
		setBook(book);
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
		
		fromInput.add(new RegisterInputField(activeBook.getAllAccounts()));
		toInput.add(new RegisterInputField(activeBook.getAllAccounts()));
		
		fromPane.getChildren().setAll(fromInput);
		toPane.getChildren().setAll(toInput);

	}
	@Override
	public void setBook(Book book) throws NoSuchBookException {
		if (book == null){
			throw new NoSuchBookException("Book can't be null");
		}
		activeBook = book;
		for (RegisterInputField input: fromInput){
			input.updateAccounts(activeBook.getAllAccounts());
		}
		for (RegisterInputField input: toInput){
			input.updateAccounts(activeBook.getAllAccounts());
		}
		
	}


}
