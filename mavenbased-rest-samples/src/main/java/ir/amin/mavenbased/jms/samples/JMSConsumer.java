package ir.amin.mavenbased.jms.samples;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Message-Driven Bean implementation class for: JmsConsumer
 */
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "ir/amin/jeesamples/dq"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") }, mappedName = "ir/amin/jeesamples/dq")
public class JMSConsumer implements MessageListener {

	/**
	 * Default constructor.
	 */
	public JMSConsumer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message message) {
		System.out.println("From JMS Consumer MDB:");
		
		try {
			System.out.println(message.getBody(String.class));
			System.out.println("Reply To : " + message.getJMSReplyTo());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
