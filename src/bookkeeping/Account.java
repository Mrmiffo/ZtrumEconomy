package bookkeeping;

import java.io.Serializable;

public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4003528843342169804L;
	private int id;
	private String name;
	private final AccountType accType;
	
	public Account(String name, int id, AccountType accType){
		this.setId(id);
		this.setName(name);
		this.accType = accType;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the accType
	 */
	public AccountType getAccType() {
		return accType;
	}
	
	public boolean equals(Object o){
		if (this == o){
			return true;
		} else if (o.getClass() != Account.class){
			return false;
		} else if ((this.id == ((Account)o).id) && (this.name == ((Account)o).name) && (this.accType == ((Account)o).accType)){
			return true;
		}
		return false;
	}
}
