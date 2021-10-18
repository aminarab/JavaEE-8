package ir.amin.mavenbased.rest.samples.qualifier.custom;

import javax.enterprise.context.RequestScoped;

@RequestScoped
@CustomQualifier
public class RectangleService implements ShapeService {

	@Override
	public String name() {
		return "Rectangle";
	}

}
