package bookkeeping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Distribution {
	private final String name;
	private final Date date;
	private final Account account;
	private final double value;
	private final List<Tag> tags = new ArrayList<>();

	public Distribution(String name, Date date, Account account, double value, List<Tag> tags){
		this.name = name;
		this.date = (Date)date.clone();
		this.account = account;
		this.value = value;
		this.tags.addAll(tags);
	}

	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}
	
	public List<Tag> getTags(){
		List<Tag> toReturn = new ArrayList<>();
		toReturn.addAll(tags);
		return toReturn;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return (Date)date.clone();
	}
}
