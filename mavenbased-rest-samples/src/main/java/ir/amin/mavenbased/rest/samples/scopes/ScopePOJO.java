package ir.amin.mavenbased.rest.samples.scopes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class ScopePOJO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<String> requests = new ArrayList<String>();

	public void addRequest(String request) {
		requests.add(request);
	}

	public String getRequests() {
		return String.join("<br />", requests); 
	}

}
