package ir.amin.mavenbased.jpa.samples;

import javax.annotation.Resource;
import javax.ejb.AfterCompletion;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.transaction.Status;
import javax.transaction.TransactionSynchronizationRegistry;

import ir.amin.mavenbased.jpa.samples.entity.TransactionLog;

public class InterceptorSample {

	@Inject
	InterceptDAO interceptDAO;

//	@Inject
//	JMSService jmsService;
	
	@Inject
	JMSSessionBean jmsSessionBean;

//	@Inject
//	TransactionMessage transactionMessage;

	//	@Resource(mappedName="java:comp/TransactionSynchronizationRegistry")
	@Resource(lookup="java:comp/TransactionSynchronizationRegistry")
	TransactionSynchronizationRegistry tsr;
		
	@AroundInvoke
	public Object methodInterceptor(InvocationContext ctx) throws Exception {
		 
		 StringBuilder called = calledSignature(ctx);

		TransactionLog transactionLog = new TransactionLog();
		transactionLog.setTransactionName("methodInterceptor -> " +called.toString());

		interceptDAO.insertTransactionLog(transactionLog);
//		transactionMessage.setMessage(parameterString(ctx));
		
		Object proceed = null;
		try {
			proceed = ctx.proceed();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("tsr.getTransactionKey() : " + tsr.getTransactionKey());
		System.out.println("tsr.getTransactionStatus() : " + tsr.getTransactionStatus());
		
		
		if(tsr.getTransactionStatus() == Status.STATUS_ACTIVE) {
//			jmsService.send(called.toString());
			jmsSessionBean.send(called.toString());
		}

//		interceptDAO.insertTransactionLog(transactionLog);
		return proceed;
	}


	private StringBuilder calledSignature(InvocationContext ctx) {
		StringBuilder called = new StringBuilder();
		called.append(ctx.getTarget().getClass().getCanonicalName() + "." + ctx.getMethod().getName() + "(");
		called.append(parameterString(ctx));
		called.append(")");
		return called;
	}


	private String parameterString(InvocationContext ctx) {
		StringBuilder stringBuilder = new StringBuilder();
		Object[] params = ctx.getParameters();
		if (params != null) {
			for (Object param : params) {
				stringBuilder.append(param + ",");
			}
		}
		return stringBuilder.toString();
	}
	
	
	@AfterCompletion
    public void AfterCompletion(final InvocationContext invocationContext) throws Exception {
		StringBuilder calledSignature = calledSignature(invocationContext);

		TransactionLog transactionLog = new TransactionLog();
		transactionLog.setTransactionName("AfterCompletion -> " + calledSignature.toString());
		interceptDAO.insertTransactionLog(transactionLog);
    }
 
	
	

}
