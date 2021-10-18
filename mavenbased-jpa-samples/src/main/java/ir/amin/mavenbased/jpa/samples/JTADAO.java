package ir.amin.mavenbased.jpa.samples;

import javax.ejb.TransactionAttributeType;

public interface JTADAO {
	public void insertJTASample(TransactionAttributeType transactionAttributeType , String className);
}
