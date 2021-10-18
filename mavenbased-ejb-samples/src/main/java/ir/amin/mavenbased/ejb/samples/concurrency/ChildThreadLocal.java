package ir.amin.mavenbased.ejb.samples.concurrency;

import javax.ejb.Local;

@Local
public interface ChildThreadLocal {

	public void sendMessagesByMANDATORY(Long id) ;
	public void sendMessagesByNEVER(Long id);
	public void sendMessagesByNOTSUPPORTED(Long id);
	public void sendMessagesByREQUIRED(Long id);
	public void sendMessagesByREQUIRESNEW(Long id);
	public void sendMessagesBySUPPORTS(Long id);
	public void sendMessagesByAsynchronous(Long id);
	
	
}
