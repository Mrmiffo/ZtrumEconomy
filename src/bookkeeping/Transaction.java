package bookkeeping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A Transaction is a class representing a registered transaction. The transaction contain one account which is 
 * @author Marvin
 *
 */
public class Transaction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4607059024467658524L;
	private static int createdTransactions;
	private final int id;
	private final Date date;
	private final String description;
	private final double value;
	private final List<Tag> tags = new ArrayList<>();
	
	public Transaction(String description, Date date, double value, List<Tag> tags) throws InvalidTransactionException{
		this.date = (Date) date.clone();
		this.description = description;
		this.value = value;
		tags.addAll(tags);
		createdTransactions++;
		id = createdTransactions;
	}
	
	

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return (Date)date.clone();
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	public String toString(){
		String toReturn = "ID: " + id + " Description: "+ description + " Date: " + date.toString() + " Value: " + value;;
		return toReturn;
	}



	/**
	 * @return the tags
	 */
	public List<Tag> getTags() {
		return tags;
	}
	
}
