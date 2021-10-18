package ir.amin.mavenbased.ejb.samples.interfaces;

import java.util.List;

import javax.ejb.Local;

import ir.amin.mavenbased.jar.samples.CatalogItem;

@Local
public interface CatalogLocal {

	public List<CatalogItem> getItems();
	
	public void addItem(CatalogItem item);
}
