package ir.amin.mavenbased.rest.samples.qualifier;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named("simpleCalculatorService")
public class SimpleCalculatorService implements CalculatorService{

	@Override
	public Integer sum(Integer a, Integer b) {
		System.out.println("simpleCalculatorService");
		return a+b;
	}

}
