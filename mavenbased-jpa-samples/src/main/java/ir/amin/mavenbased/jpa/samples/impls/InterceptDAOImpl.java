package ir.amin.mavenbased.jpa.samples.impls;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ir.amin.mavenbased.jpa.samples.InterceptDAO;
import ir.amin.mavenbased.jpa.samples.entity.Deposit;
import ir.amin.mavenbased.jpa.samples.entity.TransactionLog;

@Stateless
public class InterceptDAOImpl implements InterceptDAO{

	@PersistenceContext(unitName = "jeeHibernateSamples")
	EntityManager entityManager;

	public Long insertDeposit(Deposit deposit) {
		entityManager.persist(deposit);
		return deposit.getId();
	}

	public void insertTransactionLog(TransactionLog transactionLog) {
		entityManager.persist(transactionLog);
	}

}
