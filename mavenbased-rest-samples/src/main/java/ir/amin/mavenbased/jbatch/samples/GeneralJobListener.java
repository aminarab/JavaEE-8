package ir.amin.mavenbased.jbatch.samples;

import javax.batch.api.listener.AbstractJobListener;
import javax.batch.api.listener.JobListener;
import javax.batch.runtime.context.JobContext;
import javax.batch.runtime.context.StepContext;
import javax.inject.Inject;

/**
 * @author A.arab
 */
public class GeneralJobListener extends AbstractJobListener implements JobListener {


	@Inject
	private JobContext jobContext;
	
	@Inject
	private StepContext stepContext;

	public void beforeJob() throws Exception {
	}

	public void afterJob() throws Exception {
		System.out.println("Job " + jobContext.getJobName() + " is " + jobContext.getBatchStatus());
			
	}
	

}
