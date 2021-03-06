package ir.amin.mavenbased.jbatch.samples.simple;



import java.io.Serializable;
import java.util.Arrays;

import javax.batch.api.chunk.AbstractItemReader;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SimpleChunkItemReader extends AbstractItemReader {
    private Integer[] tokens;
    private Integer count;
    
    @Inject
    JobContext jobContext;

    @Override
    public Integer readItem() throws Exception {
        if (count >= tokens.length) { 
            return null;
        }

        jobContext.setTransientUserData(count);
        Integer token = tokens[count++];
    	printCurrentThread();
        System.out.println("Read token : " + token);
        return token;
    }

    @Override
    public void open(Serializable checkpoint) throws Exception {
        tokens = new Integer[] { 1,2,3,4,5,6,7,8,9,10 };
        System.out.println("Reader open tokens : " + Arrays.toString(tokens));
        count = 0;
    }

	private void printCurrentThread() {
		Thread currentThread = Thread.currentThread();
		System.out.println("currentThread Name : " + currentThread.getName()
				+ " - currentThread Id : " + currentThread.getId());
	}
	
}