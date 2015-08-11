package application;

import java.io.IOException;
import java.util.List;

import bookkeeping.Account;
import bookkeeping.Tag;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

public class RegisterInputField extends HBox{

	@FXML
	private DoubleTextField valueField;
	@FXML
	private ChoiceBox<Account> accountDropDown;
	@FXML
	private ListView<Tag> tagsPane;
	
	public RegisterInputField(List<Account> accounts){
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RegisterInputField.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
        try {
        	fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        updateAccounts(accounts);
	}
	
	public void updateAccounts(List<Account> newAccounts){
		accountDropDown.getItems().setAll(newAccounts);
	}
}
