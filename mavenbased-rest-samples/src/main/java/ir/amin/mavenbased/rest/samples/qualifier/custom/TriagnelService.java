package ir.amin.mavenbased.rest.samples.qualifier.custom;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class TriagnelService  implements ShapeService{

	@Override
	public String name() {
		return "Triagnel";
	}

}
