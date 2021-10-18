package ir.amin.mavenbased.ejb.samples.interfaces;

import javax.ejb.Local;

@Local
public interface StatefullSampleLocal {

	public void addState(String state);

	public String getStates();
}
