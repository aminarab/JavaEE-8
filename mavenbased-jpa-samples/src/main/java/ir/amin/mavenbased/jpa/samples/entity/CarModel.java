package ir.amin.mavenbased.jpa.samples.entity;

public enum CarModel {

	BMW(1), BENZ(2), FORD(3), AUDI(4);

	public final Integer order;

	private CarModel(Integer order) {
		this.order = order;
	}
}
