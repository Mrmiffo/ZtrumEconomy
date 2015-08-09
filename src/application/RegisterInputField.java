package application;

import java.io.IOException;

import bookkeeping.Account;
import bookkeeping.Tag;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

public class RegisterInputFieldController extends HBox{

	@FXML
	private DoubleTextField valueField;
	@FXML
	private ComboBox<Account> accountDropDown;
	@FXML
	private ListView<Tag> tagsPane;
	
	public RegisterInputFieldController(){
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RegisterInputField.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
        try {
        	fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
}
