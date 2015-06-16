package bookkeeping;

import java.util.Comparator;

public class TransactionDateCompare implements Comparator<Transaction> {

	@Override
	public int compare(Transaction o1, Transaction o2) {
		if (o1.getDate().before(o2.getDate())){
			return 1;
		} else if (o1.getDate().after(o2.getDate())){
			return -1;
		}
		return 0;
	}


}
