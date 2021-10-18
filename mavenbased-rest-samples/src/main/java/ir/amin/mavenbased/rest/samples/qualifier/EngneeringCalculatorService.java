package ir.amin.mavenbased.rest.samples.qualifier;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named("engneeringCalculatorService")
public class EngneeringCalculatorService implements CalculatorService{

	@Override
	public Integer sum(Integer a, Integer b) {
		System.out.println("engneeringCalculatorService");
		return a+b;
	}

}
