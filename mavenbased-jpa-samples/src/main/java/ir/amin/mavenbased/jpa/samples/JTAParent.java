package ir.amin.mavenbased.jpa.samples;

import javax.ejb.TransactionAttributeType;

public interface JTAParent {

	public void sendMessagesByMANDATORY(TransactionAttributeType transactionAttributeType);

	public void sendMessagesByNEVER(TransactionAttributeType transactionAttributeType);

	public void sendMessagesByNOTSUPPORTED(TransactionAttributeType transactionAttributeType);

	public void sendMessagesByREQUIRED(TransactionAttributeType transactionAttributeType);

	public void sendMessagesByREQUIRESNEW(TransactionAttributeType transactionAttributeType);

	public void sendMessagesBySUPPORTS(TransactionAttributeType transactionAttributeType);
}
