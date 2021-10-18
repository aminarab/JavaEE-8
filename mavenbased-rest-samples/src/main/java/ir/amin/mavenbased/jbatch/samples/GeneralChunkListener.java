package ir.amin.mavenbased.jbatch.samples;

import javax.batch.api.chunk.listener.AbstractChunkListener;
import javax.batch.api.chunk.listener.ChunkListener;
import javax.batch.runtime.context.JobContext;
import javax.batch.runtime.context.StepContext;
import javax.inject.Inject;

/**
 * @author A.arab
 */
@javax.inject.Named("generalChunkListener")
public class GeneralChunkListener extends AbstractChunkListener implements ChunkListener {

	@Inject
	private JobContext jobContext;

	@Inject
	private StepContext stepContext;


	public void beforeChunk() throws Exception {		
		System.out.println("Going to process chunk of job with name of : " + jobContext.getJobName());
	}

	public void afterChunk() throws Exception {
		System.out.println("after chunk process from step : " + stepContext.getStepName());
		if(stepContext.getException() != null) {			
			stepContext.getException().printStackTrace();
		}
		
	}

	public void getJobProgress() {
		
	}


	public void onError(Exception ex) throws Exception {
		ex.printStackTrace();
	}

}
