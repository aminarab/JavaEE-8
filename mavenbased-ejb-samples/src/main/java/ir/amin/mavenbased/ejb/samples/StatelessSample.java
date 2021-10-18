package ir.amin.mavenbased.ejb.samples;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ir.amin.mavenbased.ejb.samples.interfaces.StatelessSampleLocal;

@Stateless
@LocalBean
public class StatelessSample implements StatelessSampleLocal {

	private List<String> states = new ArrayList<String>();

	public void addState(String state) {
		states.add(state);
	}

	public String getStates() {
		return String.join("<br />", states);
	}

	@PostConstruct
	public void construct() {
		System.out.println("construct StatelessSample " + states);
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("preDestroy StatelessSample " + states);
	}

}
