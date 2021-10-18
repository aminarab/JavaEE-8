package ir.amin.mavenbased.jpa.samples;

import ir.amin.mavenbased.jpa.samples.entity.Deposit;
import ir.amin.mavenbased.jpa.samples.entity.TransactionLog;

public interface InterceptDAO {

	public Long insertDeposit(Deposit deposit);
	
	public void insertTransactionLog(TransactionLog transactionLog);
	
}
