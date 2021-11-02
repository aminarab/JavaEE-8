package ir.amin.mavenbased.ejb.samples;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;

import ir.amin.mavenbased.ejb.samples.interfaces.QuartzLocal;
import ir.amin.mavenbased.ejb.samples.quartz.HelloJcgJob;
import ir.amin.mavenbased.ejb.samples.quartz.HelloJcgJobListener;

@Stateless
public class QuartzManager implements QuartzLocal {

//	@Inject
//	Scheduler scheduler;

	public void start(String jobKeyName) throws SchedulerException {
		final JobKey jobKey = new JobKey(jobKeyName, "group1");
		final JobDetail job = JobBuilder.newJob(HelloJcgJob.class).withIdentity(jobKey).build();

		final Trigger trigger = TriggerBuilder.newTrigger().withIdentity("SchedulerController", "group1")
				.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();

		final Scheduler scheduler = new StdSchedulerFactory().getScheduler();

		// Listener attached to jobKey
		scheduler.getListenerManager().addJobListener(new HelloJcgJobListener(), KeyMatcher.keyEquals(jobKey));

		scheduler.start();
		scheduler.scheduleJob(job, trigger);
	}

	public boolean stop(String jobKeyName) throws SchedulerException {

//		List<JobExecutionContext> currentlyExecuting = scheduler.getCurrentlyExecutingJobs();

		boolean result = false;
		// verifying if job is running
//		for (JobExecutionContext jobExecutionContext : currentlyExecuting) {
//			if (jobExecutionContext.getJobDetail().getKey().getName().equals(jobKeyName)) {
//				result = scheduler.interrupt(jobExecutionContext.getJobDetail().getKey());
//			}
//		}
		return result;
	}
}
