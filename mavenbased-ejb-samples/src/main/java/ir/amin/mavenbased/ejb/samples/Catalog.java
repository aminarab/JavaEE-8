package ir.amin.mavenbased.ejb.samples;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import ir.amin.mavenbased.ejb.samples.interfaces.CatalogLocal;
import ir.amin.mavenbased.jar.samples.CatalogItem;

/**
 * Session Bean implementation class Catalog
 */
@Singleton
@LocalBean
public class Catalog implements CatalogLocal {

	private List<CatalogItem> items = new ArrayList<>();
    /**
     * Default constructor. 
     */
    public Catalog() {
    }

	@Override
	public List<CatalogItem> getItems() {
		return this.items; 
	}

	@Override
	public void addItem(CatalogItem item) {
		this.items.add(item);
	}

}
