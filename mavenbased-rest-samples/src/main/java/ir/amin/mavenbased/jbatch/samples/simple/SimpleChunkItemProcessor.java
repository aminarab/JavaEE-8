package ir.amin.mavenbased.jbatch.samples.simple;


import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

@Named
public class SimpleChunkItemProcessor implements ItemProcessor {

    public Integer processItem(Object t) {
    	printCurrentThread();
    	System.out.println("process : " + t);
    	
        return ((Integer) t).intValue() % 2 == 0 ? null : ((Integer) t).intValue();
    }
    

	private void printCurrentThread() {
		Thread currentThread = Thread.currentThread();
		System.out.println("currentThread Name : " + currentThread.getName()
				+ " - currentThread Id : " + currentThread.getId());
	}
	
}