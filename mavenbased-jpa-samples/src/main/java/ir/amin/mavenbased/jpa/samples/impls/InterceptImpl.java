package ir.amin.mavenbased.jpa.samples.impls;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import ir.amin.mavenbased.jpa.samples.Intercept;
import ir.amin.mavenbased.jpa.samples.InterceptDAO;
import ir.amin.mavenbased.jpa.samples.InterceptorSample;
import ir.amin.mavenbased.jpa.samples.entity.Deposit;

@Stateless
@LocalBean
public class InterceptImpl  implements Intercept{
	
	@Inject
	InterceptDAO interceptDAO;
	
	
	@Interceptors(InterceptorSample.class)
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Long insertDeposit(Deposit deposit) {
		return interceptDAO.insertDeposit(deposit);
	}


	
}
