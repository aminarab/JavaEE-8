package ir.amin.mavenbased.jpa.samples.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table
public class JTASample {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String typeName;

	@Column
	private String className;

	@Column
	private String currentThreadName;

	@Column
	private Long currentThreadId;

	@Column
	@CreationTimestamp
	private Date date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Long getCurrentThreadId() {
		return currentThreadId;
	}

	public void setCurrentThreadId(Long currentThreadId) {
		this.currentThreadId = currentThreadId;
	}

	public String getCurrentThreadName() {
		return currentThreadName;
	}

	public void setCurrentThreadName(String currentThreadName) {
		this.currentThreadName = currentThreadName;
	}

	@Override
	public String toString() {
		return "JTASample=[" + "id : " + id + " typeName : " + typeName + " className : " + className + " date : "
				+ date + "]";
	}
}
