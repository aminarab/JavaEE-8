package ir.amin.mavenbased.soap.samples;


import javax.ejb.EJB;
import javax.jws.WebService;

import ir.amin.mavenbased.ejb.samples.Hello;

@WebService(portName = "HelloServicePort", serviceName = "HelloServiceService", targetNamespace = "http://ir.amin.mavenbased.soap.samples/", endpointInterface = "ir.amin.mavenbased.soap.samples.HelloService")
public class HelloServiceImpl implements HelloService {

	@EJB
	private Hello hello;
	
	public String hello(String name) {
		return "Welcome " + hello.sayHello() + " " + name;

	}
}
