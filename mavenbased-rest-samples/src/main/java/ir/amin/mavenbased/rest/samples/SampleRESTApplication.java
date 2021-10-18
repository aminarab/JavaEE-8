package ir.amin.mavenbased.rest.samples;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import ir.amin.mavenbased.interceptor.samples.InterceptorController;
import ir.amin.mavenbased.jms.samples.JMSController;
import ir.amin.mavenbased.jta.samples.JTAController;
import ir.amin.mavenbased.rest.samples.controllers.BatchController;
import ir.amin.mavenbased.rest.samples.controllers.CarController;
import ir.amin.mavenbased.rest.samples.controllers.InventoryItemEndpoint;
import ir.amin.mavenbased.rest.samples.controllers.MultiThreadController;
import ir.amin.mavenbased.rest.samples.controllers.ScopesController;
import ir.amin.mavenbased.rest.samples.qualifier.QualifierController;

@ApplicationPath("/hsports/api")
public class SampleRESTApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new java.util.HashSet<>();
		addRestResourceClasses(resources);

		// Add Jackson feature.
		resources.add(org.glassfish.jersey.jackson.JacksonFeature.class);

		return resources;
	}

	private void addRestResourceClasses(Set<Class<?>> resources) {
		resources.add(BatchController.class);
		resources.add(CarController.class);
		resources.add(InventoryItemEndpoint.class);
		resources.add(MultiThreadController.class);
		resources.add(ScopesController.class);
		resources.add(QualifierController.class);
		resources.add(JMSController.class);
		resources.add(JTAController.class);
		resources.add(InterceptorController.class);
	}
}
