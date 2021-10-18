package ir.amin.mavenbased.ejb.samples;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import ir.amin.mavenbased.ejb.samples.interfaces.SingletoneSampleLocal;

@Singleton
@LocalBean
public class SingletoneSample implements SingletoneSampleLocal {

	private List<String> states = new ArrayList<String>();

	public void addState(String state) {
		states.add(state);
	}

	public String getStates() {
		return String.join("<br />", states);
	}
}
