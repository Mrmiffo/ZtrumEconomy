package application;

import bookkeeping.Book;
import javafx.scene.control.ScrollPane;

public abstract class AbstractCenterScreen extends ScrollPane {
	abstract public void setBook(Book book) throws NoSuchBookException;
}
