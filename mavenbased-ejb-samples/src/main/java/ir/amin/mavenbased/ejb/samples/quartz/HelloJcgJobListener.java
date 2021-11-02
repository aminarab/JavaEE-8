package ir.amin.mavenbased.ejb.samples.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class HelloJcgJobListener implements JobListener {

   public String getName() {
       return "HelloJcgJobListener";
   }

   public void jobToBeExecuted(JobExecutionContext context) {

       final String jobName = context.getJobDetail().getKey().toString();
       System.out.println("jobToBeExecuted: " + jobName + " is starting...");

   }

   public void jobExecutionVetoed(JobExecutionContext context) {
       System.out.println("jobExecutionVetoed");
   }

   public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
       System.out.println("jobWasExecuted");

       final String jobName = context.getJobDetail().getKey().toString();
       System.out.println("Job : " + jobName + " is finished!!");

       if (!jobException.getMessage().equals("")) {
           System.out.println("Exception thrown by: " + jobName + " Exception: " + jobException.getMessage());
       }
   }
}