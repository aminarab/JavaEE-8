package ir.amin.mavenbased.ejb.samples.concurrency;

import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;


@Stateless
@LocalBean
public class ChildThread implements ChildThreadLocal{

	
	@Override
	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void sendMessagesByMANDATORY(Long id) {
		Thread currentThread = Thread.currentThread();
		System.out.println("MANDATORY id : " +  id + " -  currentThread Name : " + currentThread.getName()+" - currentThread Id : " + currentThread.getId());
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NEVER)
	public void sendMessagesByNEVER(Long id) {
		Thread currentThread = Thread.currentThread();
		System.out.println("NEVER id : " +  id + " -  currentThread Name : " + currentThread.getName()+" - currentThread Id : " + currentThread.getId());
	}
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void sendMessagesByNOTSUPPORTED(Long id) {
		Thread currentThread = Thread.currentThread();
		System.out.println("NOT_SUPPORTED id : " +  id + " -  currentThread Name : " + currentThread.getName()+" - currentThread Id : " + currentThread.getId());
	}
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void sendMessagesByREQUIRED(Long id) {
		Thread currentThread = Thread.currentThread();
		System.out.println("REQUIRED id : " +  id + " -  currentThread Name : " + currentThread.getName()+" - currentThread Id : " + currentThread.getId());
	}
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void sendMessagesByREQUIRESNEW(Long id) {
		Thread currentThread = Thread.currentThread();
		System.out.println("REQUIRES_NEW id : " +  id + " -  currentThread Name : " + currentThread.getName()+" - currentThread Id : " + currentThread.getId());
	}
	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public void sendMessagesBySUPPORTS(Long id) {
		Thread currentThread = Thread.currentThread();
		System.out.println("SUPPORTS id : " +  id + " -  currentThread Name : " + currentThread.getName()+" - currentThread Id : " + currentThread.getId());
	}

	@Asynchronous
	@Override
	public void sendMessagesByAsynchronous(Long id) {
		Thread currentThread = Thread.currentThread();
		System.out.println("Asynchronous id : " +  id + " -  currentThread Name : " + currentThread.getName()+" - currentThread Id : " + currentThread.getId());
		
	}
}
