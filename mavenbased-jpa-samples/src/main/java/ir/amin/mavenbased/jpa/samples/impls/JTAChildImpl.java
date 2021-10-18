package ir.amin.mavenbased.jpa.samples.impls;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import ir.amin.mavenbased.jpa.samples.JTAChild;
import ir.amin.mavenbased.jpa.samples.JTADAO;


@Stateless
public class JTAChildImpl implements JTAChild{

	@Inject
	JTADAO jtadao;

	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void sendMessagesByMANDATORY(TransactionAttributeType transactionAttributeType) {
		jtadao.insertJTASample(transactionAttributeType, JTAChildImpl.class.getCanonicalName());
	}

	@TransactionAttribute(TransactionAttributeType.NEVER)
	public void sendMessagesByNEVER(TransactionAttributeType transactionAttributeType) {
		jtadao.insertJTASample(transactionAttributeType, JTAChildImpl.class.getCanonicalName());
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void sendMessagesByNOTSUPPORTED(TransactionAttributeType transactionAttributeType) {
		jtadao.insertJTASample(transactionAttributeType, JTAChildImpl.class.getCanonicalName());
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void sendMessagesByREQUIRED(TransactionAttributeType transactionAttributeType) {
		jtadao.insertJTASample(transactionAttributeType, JTAChildImpl.class.getCanonicalName());
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void sendMessagesByREQUIRESNEW(TransactionAttributeType transactionAttributeType) {
		jtadao.insertJTASample(transactionAttributeType, JTAChildImpl.class.getCanonicalName());
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public void sendMessagesBySUPPORTS(TransactionAttributeType transactionAttributeType) {
		jtadao.insertJTASample(transactionAttributeType, JTAChildImpl.class.getCanonicalName());
	}

}