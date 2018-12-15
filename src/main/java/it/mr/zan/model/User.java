package it.mr.zan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * la classe di modello User gestita con JPA
 */
@Entity
@Table(name = "USERS")
@ApiModel(description = "L'entità User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(position=0, notes = "L'identificativo unico", required = false, allowEmptyValue = false)
	private long id;

	@NotNull
	@Size(min = 2, max = 100)
	@Column(name = "first_name")
	@ApiModelProperty(position=1, notes = "Nome (da 2 a 100 caratteri)", required = true, allowEmptyValue = false)
	private String firstName;

	@NotNull
	@Size(min = 2, max = 100)
	@Column(name = "last_name")
	@ApiModelProperty(position=2,notes = "Cognome (da 2 a 100 caratteri)", required = true, allowEmptyValue = false)
	private String lastName;

	@Email
	@Column(name = "email")
	@ApiModelProperty(position=3,notes = "Indirizzo email", required = false, allowEmptyValue = false)
	private String email;

	public long getId() {
		return id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}