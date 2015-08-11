package application;
	
import java.util.ArrayList;
import java.util.List;

import bookkeeping.AccountType;
import bookkeeping.Book;
import bookkeeping.InvalidAccountException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		// TODO remove test data.
		List<Book> toLaunch = new ArrayList<Book>();
		Book testBook = new Book("Test");
		try {
			testBook.addAccount("Test acc 1", 1, AccountType.CREDIT);
			testBook.addAccount("Test acc 2", 2, AccountType.EXPENSE);
		} catch (InvalidAccountException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		toLaunch.add(testBook);
		try {
			AnchorPane root = new MainScreenController(toLaunch);
			Scene scene = new Scene(root,800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
