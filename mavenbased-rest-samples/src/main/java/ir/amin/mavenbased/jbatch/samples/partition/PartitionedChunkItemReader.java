package ir.amin.mavenbased.jbatch.samples.partition;

import java.io.Serializable;
import java.util.Arrays;

import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.AbstractItemReader;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class PartitionedChunkItemReader extends AbstractItemReader {

	@Inject()
	@BatchProperty(name = "start")
	private String startProp;
	@Inject()
	@BatchProperty(name = "end")
	private String endProp;

	private Integer[] tokens;
	private Integer count;

	@Inject
	JobContext jobContext;

	@Override
	public Integer readItem() throws Exception {

		System.out.println(count +">=" + Integer.valueOf(startProp) + " && " + count + "<" + Integer.valueOf(endProp));
		if (count >= Integer.valueOf(startProp) && count < Integer.valueOf(endProp)) {
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
		System.out.println("Start Second Step : -----------------------------------------------------------------------------------------");
		
		tokens = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ,11,12,13,14,15,16,17,18,19,20,21,22,23};
		System.out.println("Reader open tokens : " + Arrays.toString(tokens));
		count = 0;
	}

	private void printCurrentThread() {
		Thread currentThread = Thread.currentThread();
		System.out.println(
				"currentReaderThread Name : " + currentThread.getName() + " - currentReaderThread Id : " + currentThread.getId());
	}

}