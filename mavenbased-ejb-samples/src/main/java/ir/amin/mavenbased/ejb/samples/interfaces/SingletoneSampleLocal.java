package ir.amin.mavenbased.ejb.samples.interfaces;

import javax.ejb.Local;

@Local
public interface SingletoneSampleLocal {

	public void addState(String state);

	public String getStates();
}
