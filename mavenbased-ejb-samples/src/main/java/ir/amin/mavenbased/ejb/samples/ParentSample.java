package ir.amin.mavenbased.ejb.samples;

import java.util.ArrayList;
import java.util.List;

public class ParentSample {

	private List<String> states = new ArrayList<String>();

	public void addState(String state) {
		states.add(state);
	}

	public String getStates() {
		return String.join("<br />", states); 
	}
}
