package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bookkeeping.Account;
import bookkeeping.Book;
import bookkeeping.Distribution;
import bookkeeping.Transaction;
import bookkeeping.TransactionFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
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
	
	@FXML
	private Button addFromButton;
	@FXML
	private Button addToButton;
	@FXML
	private Button saveButton;
	
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
		
		addFromField();
		addToField();
		verifyTransactionDetails();

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
	
	public void saveTransaction(){
		List<Distribution> fromAccounts = new ArrayList<>();
		List<Distribution> toAccounts = new ArrayList<>();
		if (dateField.getValue() != null && !titleText.getText().equals("")){
			@SuppressWarnings("deprecation")
			Date date = new Date(dateField.getValue().getYear(), dateField.getValue().getMonthValue(), dateField.getValue().getDayOfMonth());
			for (RegisterInputField input: fromInput){
				fromAccounts.add(new Distribution(titleText.getText(), date, input.getAccount(), input.getValue(), input.getTags()));
			}
			
			for (RegisterInputField input: toInput){
				toAccounts.add(new Distribution(titleText.getText(), date, input.getAccount(), input.getValue(), input.getTags()));
			}
			
			for (Account acc: activeBook.getAllAccounts()){
				for (Transaction tran: acc.getTransactions()){
					System.out.println(tran.toString());
				}
			}
		} else if (dateField.getValue() == null){
			//TODO cast error
			System.out.println("No date");
		} else if (titleText.getText().equals("")){
			//TODO cast error
			System.out.println("No title");
		}

	}
	
	@FXML
	private void addFromField(){
		RegisterInputField test = new RegisterInputField(activeBook.getAllAccounts());
		test.on
		fromInput.add(new RegisterInputField(activeBook.getAllAccounts()));
		fromPane.getChildren().setAll(fromInput);
	}
	
	@FXML
	private void addToField(){
		toInput.add(new RegisterInputField(activeBook.getAllAccounts()));
		toPane.getChildren().setAll(toInput);
	}
	
	@FXML
	private void verifyTransactionDetails(){
		System.out.println("Verifying");
		boolean setSave = false;
		if (dateField.getValue() != null && !titleText.getText().equals("")){
			//TODO add message for missing input
			for (RegisterInputField input: fromInput){
				if (input.getAccount() == null) {
					setSave = true;
					//TODO add message for missing input
				};
			}
			
			for (RegisterInputField input: toInput){
				if (input.getAccount() == null) {
					setSave = true;
					//TODO add message for missing input
				};
			}
		} else setSave = true;
		saveButton.setDisable(setSave);
	}
	



}
