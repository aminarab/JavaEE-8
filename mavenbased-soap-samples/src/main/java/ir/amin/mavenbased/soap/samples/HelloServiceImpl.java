package ir.amin.mavenbased.soap.samples;


import javax.ejb.EJB;
import javax.jws.WebService;

import ir.amin.mavenbased.ejb.samples.interfaces.HelloLocal;

@WebService(portName = "HelloServicePort", serviceName = "HelloServiceService", targetNamespace = "http://ir.amin.mavenbased.soap.samples/", endpointInterface = "ir.amin.mavenbased.soap.samples.HelloService")
public class HelloServiceImpl implements HelloService {

	@EJB
	private HelloLocal helloLocal;
	
	public String hello(String name) {
		return "Welcome "  + helloLocal.sayHello()  + " " + name;

	}
}
