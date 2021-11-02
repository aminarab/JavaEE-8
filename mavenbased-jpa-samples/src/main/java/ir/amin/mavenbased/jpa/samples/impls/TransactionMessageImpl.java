package ir.amin.mavenbased.jpa.samples.impls;

import java.rmi.RemoteException;

import javax.annotation.PreDestroy;
import javax.ejb.EJBException;
import javax.ejb.Remove;
import javax.ejb.SessionSynchronization;
import javax.ejb.Stateful;
import javax.inject.Inject;

import ir.amin.mavenbased.jpa.samples.JMSService;
import ir.amin.mavenbased.jpa.samples.TransactionMessage;

@Stateful
public class TransactionMessageImpl implements TransactionMessage, SessionSynchronization {

	private String message;

	@Inject
	JMSService jmsService;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void afterBegin() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	public void beforeCompletion() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	public void afterCompletion(boolean committed) throws EJBException, RemoteException {
		if (committed) {
			jmsService.send(message);
		}
	}

	@PreDestroy
	public void preDestory() {
		System.out.println("preDestory : " + message);
		message = null;
	}

	@Remove(retainIfException = false)
	public void remove() {
		System.out.println("remove : " + message);
		message = null;
	}
}
