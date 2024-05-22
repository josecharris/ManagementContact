package co.edu.uptc.appcontact.model;

import java.io.Serializable;

public class Contact implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private String codDoc;
	private String phoneNumber;
	private String email;
	private String countryCode;
	
	/** Constructor vacío de la clase */
	public Contact() {
		/* Constructor vacío */
	}

	public Contact(String name, String codDoc, String phoneNumber, String email, String countryCode) {
		this.name = name;
		this.codDoc = codDoc;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.countryCode = countryCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCodDoc() {
		return codDoc;
	}

	public void setCodDoc(String codDoc) {
		this.codDoc = codDoc;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", codDoc=" + codDoc + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", countryCode=" + countryCode + "]";
	}
	
}
