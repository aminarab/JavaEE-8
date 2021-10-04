package ir.amin.mavenbased.jbatch.samples;

import javax.batch.api.partition.PartitionMapper;
import javax.batch.api.partition.PartitionPlan;
import javax.batch.api.partition.PartitionPlanImpl;

public class SimplePartitionMapper implements PartitionMapper   {
	
	@Override
    public PartitionPlan mapPartitions() throws Exception {
        PartitionPlan plan = new PartitionPlanImpl();
        plan.setPartitions(3);
        plan.setThreads(3);
        return plan;
    }
	
}
