package ir.amin.mavenbased.ejb.samples.concurrency;

import javax.ejb.Local;

@Local
public interface ParentThreadLocal {

	public void preparedMessage(Long id);
	public void asynchronousPreparedMessage(Long id);
	public void preparedMessageByCallable(Long id);
	public void preparedMessageByRunnable(Long id);
	
}