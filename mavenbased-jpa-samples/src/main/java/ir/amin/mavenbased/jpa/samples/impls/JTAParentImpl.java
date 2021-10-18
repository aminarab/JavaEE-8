package ir.amin.mavenbased.jpa.samples.impls;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import ir.amin.mavenbased.jpa.samples.JTAChild;
import ir.amin.mavenbased.jpa.samples.JTADAO;
import ir.amin.mavenbased.jpa.samples.JTAParent;


@Stateless
public class JTAParentImpl implements JTAParent{

	@Inject
	JTADAO jtadao;
	
	@Inject
	JTAChild jtaChild;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void sendMessagesByMANDATORY(TransactionAttributeType transactionAttributeType) {
		jtadao.insertJTASample(TransactionAttributeType.REQUIRED, JTAParentImpl.class.getCanonicalName());
		jtaChild.sendMessagesByMANDATORY(transactionAttributeType);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void sendMessagesByNEVER(TransactionAttributeType transactionAttributeType) {
		jtadao.insertJTASample(TransactionAttributeType.REQUIRED, JTAParentImpl.class.getCanonicalName());
		jtaChild.sendMessagesByNEVER(transactionAttributeType);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void sendMessagesByNOTSUPPORTED(TransactionAttributeType transactionAttributeType) {
		jtadao.insertJTASample(TransactionAttributeType.REQUIRED, JTAParentImpl.class.getCanonicalName());
		jtaChild.sendMessagesByNOTSUPPORTED(transactionAttributeType);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void sendMessagesByREQUIRED(TransactionAttributeType transactionAttributeType) {
		jtadao.insertJTASample(TransactionAttributeType.REQUIRED, JTAParentImpl.class.getCanonicalName());
		jtaChild.sendMessagesByREQUIRED(transactionAttributeType);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void sendMessagesByREQUIRESNEW(TransactionAttributeType transactionAttributeType) {
		jtadao.insertJTASample(TransactionAttributeType.REQUIRED, JTAParentImpl.class.getCanonicalName());
		jtaChild.sendMessagesByREQUIRESNEW(transactionAttributeType);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void sendMessagesBySUPPORTS(TransactionAttributeType transactionAttributeType) {
		jtadao.insertJTASample(TransactionAttributeType.REQUIRED, JTAParentImpl.class.getCanonicalName());
		jtaChild.sendMessagesBySUPPORTS(transactionAttributeType);
	}

}