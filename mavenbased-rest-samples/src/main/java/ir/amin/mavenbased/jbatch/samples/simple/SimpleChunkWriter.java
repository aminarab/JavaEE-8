package ir.amin.mavenbased.jbatch.samples.simple;



import java.util.ArrayList;
import java.util.List;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;

@Named
public class SimpleChunkWriter extends AbstractItemWriter {
    List<Integer> processed = new ArrayList<Integer>();
    @Override
    public void writeItems(List<Object> items) throws Exception {
    	printCurrentThread();
    	System.out.println("Write tokens : " +   items);
        items.stream().map(Integer.class::cast).forEach(processed::add);
    }
    

	private void printCurrentThread() {
		Thread currentThread = Thread.currentThread();
		System.out.println("currentThread Name : " + currentThread.getName()
				+ " - currentThread Id : " + currentThread.getId());
	}
}