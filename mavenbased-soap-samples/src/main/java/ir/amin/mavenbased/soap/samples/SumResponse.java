package ir.amin.mavenbased.soap.samples;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * @author A.arab
 *
 */
@XmlType(name="SumResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class SumResponse {

	public Integer total;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

}