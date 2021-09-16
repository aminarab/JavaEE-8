package ir.amin.mavenbased.jsf.samples;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ir.amin.mavenbased.jar.samples.CatalogItem;


@Named
@RequestScoped
public class CatalogItemDeleteBean {
	
	private long itemId;

	private CatalogItem item;

	@Inject
	private CatalogItemCRUDFormBean catalogItemCRUDFormBean; 

	public void fetchItem() {
		List<CatalogItem> items = this.catalogItemCRUDFormBean.getItems().stream().filter(i -> {
			return i.getItemId() == itemId;
		}).collect(Collectors.toList());

		if (items.isEmpty()) {
			this.item = null;
		} else {
			this.item = items.get(0);
		}

	}
	
	public String removeItem() {
		this.catalogItemCRUDFormBean.getItems().removeIf(item ->{
			return item.getItemId().equals(this.itemId);
		});
		return "crudlist?faces-redirect=true";
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public CatalogItem getItem() {
		return item;
	}

	public void setItem(CatalogItem item) {
		this.item = item;
	}

	public CatalogItemCRUDFormBean getCatalogItemCRUDFormBean() {
		return catalogItemCRUDFormBean;
	}

	public void setCatalogItemCRUDFormBean(CatalogItemCRUDFormBean catalogItemCRUDFormBean) {
		this.catalogItemCRUDFormBean = catalogItemCRUDFormBean;
	}

	


}
