package ir.amin.mavenbased.jbatch.samples.partition;

import java.util.ArrayList;
import java.util.List;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;

@Named
public class PartitionedChunkWriter extends AbstractItemWriter {
	List<Integer> processed = new ArrayList<Integer>();

	@Override
	public void writeItems(List<Object> items) throws Exception {
		printCurrentThread();
		System.out.println("Write tokens : " + items);
		items.stream().map(Integer.class::cast).forEach(processed::add);
	}

	private void printCurrentThread() {
		Thread currentThread = Thread.currentThread();
		System.out.println(
				"currentWriterThread Name : " + currentThread.getName() + " - currentWriterThread Id : " + currentThread.getId());
	}
}