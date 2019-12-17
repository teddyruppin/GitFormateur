package myapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.PostUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity (name = "Person")
@Table (name = "TPerson")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Basic(optional = false)
	@Column(name = "first_name", length = 50, nullable = false, unique = true)
	private String firstname;

	@Basic(optional = false)
	@Temporal(TemporalType.DATE)
	@Column(name = "birth_day")
	private Date birthDay;

	@Version
	private long version = 0;

	@Transient
	public static long updateCounter = 0;

	public Person() {
		super();
	}

	public Person(String firsname, Date birthDay) {
		this.firstname = firsname;
		this.birthDay = birthDay;
	}

	@PreUpdate
	public void beforeUpdate() {
		System.out.println("PreUpdate of " + this);
	}

	@PostUpdate
	public void PostUpdate() {
		System.out.println("PostUpdate of " + this);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public static long getUpdateCounter() {
		return updateCounter;
	}

	public static void setUpdateCounter(long updateCounter) {
		Person.updateCounter = updateCounter;
	}

	public static final long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstname=" + firstname + ", birthDay=" + birthDay + ", version=" + version
				+ "]";
	}

}
