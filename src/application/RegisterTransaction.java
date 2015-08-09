package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class RegisterTransactionController extends ScrollPane{

	@FXML
	private TextField titleText;
	@FXML
	private VBox fromPane;
	@FXML
	private VBox toPane;
	@FXML
	private DatePicker dateField;
	
	private List<RegisterInputFieldController> fromInput;
	private List<RegisterInputFieldController> toInput;
	
	public RegisterTransactionController(){
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
		
		fromInput.add(new RegisterInputFieldController());
		fromInput.add(new RegisterInputFieldController());
		fromInput.add(new RegisterInputFieldController());
		fromInput.add(new RegisterInputFieldController());
		fromInput.add(new RegisterInputFieldController());
		fromInput.add(new RegisterInputFieldController());
		fromInput.add(new RegisterInputFieldController());
		toInput.add(new RegisterInputFieldController());
		
		fromPane.getChildren().setAll(fromInput);
		toPane.getChildren().setAll(toInput);

	}

}
