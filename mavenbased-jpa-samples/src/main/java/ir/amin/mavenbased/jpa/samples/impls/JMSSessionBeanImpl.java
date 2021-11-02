package ir.amin.mavenbased.jpa.samples.impls;

import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.TextMessage;

import ir.amin.mavenbased.jpa.samples.JMSSessionBean;


@Stateless
public class JMSSessionBeanImpl  implements JMSSessionBean{

	@Resource(mappedName="ir/amin/jeesamples/dq")
	private Queue hsportsQueue;
	
	@Inject
	@JMSConnectionFactory("ir/amin/jeesamples/cf")
	private JMSContext context;
	
//	@Asynchronous
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void send(String message) {
		
		try {
			TextMessage textMessage = context.createTextMessage(message);
			context.createProducer().send(this.hsportsQueue, textMessage);
			System.out.println("Message sent to queue by JMSSessionBeanImpl.");

			int a = 2/0;
			System.out.println("Exception Happen in JMSSessionBeanImpl");
		} catch (Exception e) {
//			context.rollback();
			e.printStackTrace();
			System.out.println("printStackTrace in JMSSessionBeanImpl");
			throw new RuntimeException("Please don't Send my message");
		}
		context.acknowledge();
	}
	
	
	
}
