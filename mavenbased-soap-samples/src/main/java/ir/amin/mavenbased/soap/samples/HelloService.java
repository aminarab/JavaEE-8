package ir.amin.mavenbased.soap.samples;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name = "HelloService", targetNamespace = "http://ir.amin.mavenbased.soap.samples/")
public interface HelloService {

	@WebMethod(operationName = "hello")
	public String hello(String name);
}