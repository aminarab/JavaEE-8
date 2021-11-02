package ir.amin.mavenbased.ejb.samples.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJcgJob implements Job {
    
   public void execute(JobExecutionContext context) throws JobExecutionException {
        
       System.out.println("Hello Java Code Geeks World!");
   }

}