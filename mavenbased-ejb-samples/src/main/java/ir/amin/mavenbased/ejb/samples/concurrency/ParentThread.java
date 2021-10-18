package ir.amin.mavenbased.ejb.samples.concurrency;

import java.util.concurrent.Future;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.concurrent.ManagedThreadFactory;

@Stateless
@LocalBean
public class ParentThread implements ParentThreadLocal {

	@EJB
	private ChildThreadLocal childThreadLocal;


	@Override
	public void preparedMessage(Long id) {
		printCurrentThread(id);
		childThreadLocal.sendMessagesByMANDATORY(id);
		childThreadLocal.sendMessagesByREQUIRED(id);
		childThreadLocal.sendMessagesByREQUIRESNEW(id);
		childThreadLocal.sendMessagesBySUPPORTS(id);
		childThreadLocal.sendMessagesByNOTSUPPORTED(id);
		childThreadLocal.sendMessagesByNEVER(id);

	}

	public void asynchronousPreparedMessage(Long id) {
		printCurrentThread(id);
		childThreadLocal.sendMessagesByAsynchronous(id);
	}

	@Resource
	private ManagedExecutorService executorService;
	
	@Override
	public void preparedMessageByCallable(Long id) {
		printCurrentThread(id);
		CallableReportTask reportTask = new CallableReportTask();
		Future<Report> future = executorService.submit(reportTask);
		System.out.println("future.isDone : " + future.isDone());

	}

	@Resource
	private ManagedThreadFactory threadFactory;
	
	@Override
	public void preparedMessageByRunnable(Long id) {
		printCurrentThread(id);
		RunnableReportTask reportTask = new RunnableReportTask();
        Thread thread = threadFactory.newThread(reportTask);
        thread.start();
	}

	private void printCurrentThread(Long id) {
		Thread currentThread = Thread.currentThread();
		System.out.println("id : " + id + " -  currentThread Name : " + currentThread.getName()
				+ " - currentThread Id : " + currentThread.getId());
	}
}
