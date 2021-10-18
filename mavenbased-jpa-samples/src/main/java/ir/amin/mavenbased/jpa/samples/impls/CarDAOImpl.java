package ir.amin.mavenbased.jpa.samples.impls;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ir.amin.mavenbased.jpa.samples.CarDAO;
import ir.amin.mavenbased.jpa.samples.entity.Car;
import ir.amin.mavenbased.jpa.samples.entity.CarModel;
import ir.amin.mavenbased.jpa.samples.entity.Document;
import ir.amin.mavenbased.jpa.samples.entity.Insurance;
import ir.amin.mavenbased.jpa.samples.entity.Person;

@Stateless
public class CarDAOImpl implements CarDAO {

	@PersistenceContext(unitName = "jeeHibernateSamples")
	EntityManager entityManager;

	public void insertSampleData() throws ParseException {
		
		/*
		 * cars
		 */
		Car bmw = new Car();
		bmw.setModel(CarModel.BMW);

		Car benz = new Car();
		benz.setModel(CarModel.BENZ);
		
		Car audi = new Car();
		audi.setModel(CarModel.AUDI);
		
		Car ford = new Car();
		ford.setModel(CarModel.FORD);
		
		
		/*
		 * persons
		 */
		Person amin = new Person();
		amin.setName("Amin");
		
		Person behzad = new Person();
		behzad.setName("Behzad");
		
		Person saman = new Person();
		saman.setName("Saman");
		
		/*
		 * documents
		 */
		Document document1 = new Document();
		document1.setProductionYear(new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2010"));
		
		Document document2 = new Document();
		document2.setProductionYear(new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2010"));
		
		Document document3 = new Document();
		document3.setProductionYear(new SimpleDateFormat("dd/MM/yyyy").parse("15/01/2015"));
		
		Document document4 = new Document();
		document4.setProductionYear(new SimpleDateFormat("dd/MM/yyyy").parse("15/01/2020"));
		
		/*
		 * insurances
		 */
		Insurance insurance1 = new Insurance();
		insurance1.setIssueDate(new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2011"));
		
		Insurance insurance2 = new Insurance();
		insurance2.setIssueDate(new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2015"));

		Insurance insurance3 = new Insurance();
		insurance3.setIssueDate(new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2021"));

		Insurance insurance4 = new Insurance();
		insurance4.setIssueDate(new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2021"));
		
		
		/*
		 * Complete Car entities as relationship owner 
		 */
		bmw.setDocument(document1);
		benz.setDocument(document2);
		audi.setDocument(document3);
		ford.setDocument(document4);
		
		
		Set<Person> bmwOwners = new HashSet<Person>();
		bmwOwners.add(saman);
		bmwOwners.add(behzad);
		bmw.setOwners(bmwOwners);
		

		Set<Person> benzOwners = new HashSet<Person>();
		benzOwners.add(saman);
		benzOwners.add(amin);
		benz.setOwners(benzOwners);
		

		Set<Person> audiOwners = new HashSet<Person>();
		audiOwners.add(saman);
		audiOwners.add(behzad);
		audiOwners.add(amin);
		audi.setOwners(audiOwners);


		Set<Person> fordOwners = new HashSet<Person>();
		fordOwners.add(amin);
		ford.setOwners(fordOwners);
		
		/*
		 * We need persist document before car (One to One relation owner)
		 * OR
		 * use @OneToOne(cascade = CascadeType.ALL)
		 */
//		entityManager.persist(document1);
//		entityManager.persist(document2);
//		entityManager.persist(document3);
//		entityManager.persist(document4);

		/*
		 * We need persist owners before car (One to One relation owner)
		 * OR
		 * use @ManyToMany(cascade = CascadeType.ALL)
		 */
//		entityManager.persist(amin);
//		entityManager.persist(behzad);
//		entityManager.persist(saman);
		
		insert(bmw);
		insert(benz);
		insert(ford);
		insert(audi);
		
		
		
		insurance1.setCar(bmw);
		entityManager.persist(insurance1);
		
		insurance2.setCar(ford);
		entityManager.persist(insurance2);
		
		insurance3.setCar(benz);
		entityManager.persist(insurance3);
		
		insurance4.setCar(benz);
		entityManager.persist(insurance4);

	}

	public Integer carCount() {
		Query query = entityManager.createQuery("select count(c) from Car c");
		Object singleResult = query.getSingleResult();
		return Integer.valueOf(singleResult.toString());
	}

	public void insert(Car car) {
		entityManager.persist(car);
	}

	public void update(Car car) {
		entityManager.merge(car);
	}

	public void delete(Car car) {
		entityManager.remove(car);
	}

	public List<Car> findAll() {
		Query query = entityManager.createQuery("Select c From Car c");
		List queryResultList = query.getResultList();
		TypedQuery<Car> typedQuery = entityManager.createQuery("Select c From Car c", Car.class);
		List<Car> typedResultList = typedQuery.getResultList();
		typedResultList.retainAll(queryResultList);
		return typedResultList;
	}

	public Car findById(Long id) {
		return entityManager.find(Car.class, id);
	}

	public List<Car> findByName(String name) {
		TypedQuery<Car> typedQuery = entityManager.createQuery("select c from Car c where c.model = ?1", Car.class);
		typedQuery.setParameter(1, CarModel.valueOf(name));
		return typedQuery.getResultList();
	}

	public List<Car> findByValidLicence() {
		TypedQuery<Car> typedQuery = entityManager
				.createQuery("select c from Car c JOIN c.insurances i where i.issueDate <= ?1", Car.class);
		Calendar prevYear = Calendar.getInstance();
		prevYear.add(Calendar.YEAR, -1);
		typedQuery.setParameter(1, prevYear.getTime());
		return typedQuery.getResultList();
	}

	public List<Car> findByOwnerName(String name) {
		TypedQuery<Car> typedQuery = entityManager
				.createQuery("select c from Car c JOIN c.owners o where o.name like CONCAT('%', :name, '%')", Car.class);
		typedQuery.setParameter("name", name);
		return typedQuery.getResultList();
		
	}

	public List<Car> findByProductionYear(Integer productionYear) {
		Date targetYearStart = new GregorianCalendar(productionYear, Calendar.JANUARY, 1).getTime();

		Calendar cal = Calendar.getInstance();
		cal.setTime(targetYearStart);
		cal.add(Calendar.YEAR, 1);
		
		
		
		Query nativeQuery = entityManager.createNativeQuery(
				"select c.* from Car c join OF1DOC doc on c.doc_id=doc.OF1001ID where doc.OF1001PROYEAR between ?1 and ?2", Car.class);
		nativeQuery.setParameter(1, targetYearStart);
		nativeQuery.setParameter(2, cal.getTime());
		List<Car> resultList = nativeQuery.getResultList();
		return resultList;
	}

}
