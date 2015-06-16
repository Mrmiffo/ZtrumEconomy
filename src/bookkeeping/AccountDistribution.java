package bookkeeping;

public final class AccountDistribution {
	public final Account account;
	public final double value;
	
	public AccountDistribution(Account account, double value) throws InvalidValueException{
		if (value < 0){
			throw new InvalidValueException("The account distribution value can not be below 0");
		}
		this.account = account;
		this.value = value;
	}
	
	public String toString(){
		return "Account: " + account.getId() + " Value: " + value;
	}
}
