package ir.amin.mavenbased.jpa.samples;

import javax.ejb.Local;

import ir.amin.mavenbased.jpa.samples.entity.Deposit;

@Local
public interface Intercept {

	public Long insertDeposit(Deposit deposit);

}
