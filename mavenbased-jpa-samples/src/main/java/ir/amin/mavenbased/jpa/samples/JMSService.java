package ir.amin.mavenbased.jpa.samples;


import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.TextMessage;

@ApplicationScoped
public class JMSService {

	@Resource(mappedName="ir/amin/jeesamples/dq")
	private Queue hsportsQueue;
	
	@Inject
	@JMSConnectionFactory("ir/amin/jeesamples/cf")
	private JMSContext context;
	
	
	public void send(String message) {
		
		try {
			TextMessage textMessage = context.createTextMessage(message);
			context.createProducer().send(this.hsportsQueue, textMessage);
			System.out.println("Message sent to queue by JMSService.");
			int a = 2/0;
			System.out.println("Exception Happen in JMSService");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("printStackTrace in JMSService");
		}
	}
	
	
	
	
	
}

