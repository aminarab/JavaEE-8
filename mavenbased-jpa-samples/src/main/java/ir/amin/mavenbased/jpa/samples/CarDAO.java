package ir.amin.mavenbased.jpa.samples;

import java.text.ParseException;
import java.util.List;

import ir.amin.mavenbased.jpa.samples.entity.Car;

public interface CarDAO {
	
	public void insert(Car car);
	public void update(Car car);
	public void delete(Car car);
	public List<Car> findAll();
	public Car findById(Long id);
	public List<Car> findByName(String name);
	
	//One to Many
	public List<Car> findByValidLicence();
	
	//Many to Many
	public List<Car> findByOwnerName(String name);
	
	//One to One
	public List<Car> findByProductionYear(Integer productionYear);
	
	public void insertSampleData() throws ParseException;
	public Integer carCount();
}
