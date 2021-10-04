package ir.amin.mavenbased.jbatch.samples.partition;


import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

@Named
public class PartitionedChunkItemProcessor implements ItemProcessor {

    public Integer processItem(Object t) {
    	printCurrentThread();
    	System.out.println("process : " + t);
    	
        return ((Integer) t).intValue() % 2 == 0 ? null : ((Integer) t).intValue();
    }
    

	private void printCurrentThread() {
		Thread currentThread = Thread.currentThread();
		System.out.println("currentProcessorThread Name : " + currentThread.getName()
				+ " - currentProcessorThread Id : " + currentThread.getId());
	}
	
}