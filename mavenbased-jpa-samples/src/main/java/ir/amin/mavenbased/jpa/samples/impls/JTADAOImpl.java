package ir.amin.mavenbased.jpa.samples.impls;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttributeType;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.TransactionSynchronizationRegistry;

import ir.amin.mavenbased.jpa.samples.JTADAO;
import ir.amin.mavenbased.jpa.samples.entity.JTASample;

@Stateless
public class JTADAOImpl implements JTADAO{



	@PersistenceContext(unitName = "jeeHibernateSamples")
	EntityManager entityManager;

	public void insertJTASample(TransactionAttributeType transactionAttributeType , String className) {
		TransactionSynchronizationRegistry tsr;
		try {
			tsr = (TransactionSynchronizationRegistry)
					  new InitialContext().lookup("java:comp/TransactionSynchronizationRegistry");
			int status = tsr.getTransactionStatus();
			tsr.getTransactionKey();
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		JTASample jtaSample = new JTASample();
		jtaSample.setClassName(className);
		jtaSample.setTypeName(transactionAttributeType.name());
		Thread currentThread = Thread.currentThread();
		jtaSample.setCurrentThreadId(currentThread.getId());
		jtaSample.setCurrentThreadName(currentThread.getName());
		entityManager.persist(jtaSample);
		System.out.println(jtaSample);
	}
	
}
