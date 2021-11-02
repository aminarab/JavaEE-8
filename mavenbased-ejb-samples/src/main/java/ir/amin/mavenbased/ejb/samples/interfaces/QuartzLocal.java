package ir.amin.mavenbased.ejb.samples.interfaces;

import org.quartz.SchedulerException;

public interface QuartzLocal {

	public void start(String jobKeyName) throws SchedulerException;
	public boolean stop(String jobKeyName) throws SchedulerException;
}
