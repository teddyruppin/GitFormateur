package myapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostUpdate;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity(name = "Person")
public class Personne implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Basic(optional = false)
	@Column(name = "first_name", length = 200, nullable = false, unique = true)
	private String firstName;
	@Basic()
	@Temporal(TemporalType.DATE)
	@Column(name = "birth_day")
	private Date birthDay;
	@Version()
	private long version = 0;
	@Transient
	public static long updateCounter = 0;

	public Personne() {
		super();
	}

	public Personne(String firstName, Date birthDay) {
		super();
		this.firstName = firstName;
		this.birthDay = birthDay;
	}

	@PreUpdate
	public void beforeUpdate() {
		System.err.println("PreUpdate of " + this);
	}

	@PostUpdate
	public void afterUpdate() {
		System.err.println("PostUpdate of " + this);
		updateCounter++;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
		Personne.updateCounter = updateCounter;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}