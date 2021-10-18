package ir.amin.mavenbased.ejb.samples;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;

import ir.amin.mavenbased.ejb.samples.interfaces.StatefullSampleLocal;

@Stateful
@LocalBean
public class StatefullSample implements StatefullSampleLocal {

	private List<String> states = new ArrayList<String>();

	public void addState(String state) {
		states.add(state);
	}

	public String getStates() {
		return String.join("<br />", states);
	}

	@PostConstruct
	public void construct() {
		System.out.println("construct StatefullSample " + states);
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("preDestroy StatefullSample " + states);
	}

	@PostActivate
	public void postActivate() {
		System.out.println("postActivate StatefullSample " + states);
	}

	@PrePassivate
	public void prePassivate() {
		System.out.println("prePassivate StatefullSample " + states);
	}
	
	@Remove
	public void remove() {
		System.out.println("remove StatefullSample " + states);
	}
	
}
