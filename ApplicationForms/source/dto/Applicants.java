package dto;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Applicants {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int applicationId;
	private String fname;
	private String lname;
	private Date dob;
	private long contact;
	private String email;
	private String address;
	private String course;
	private String reference;
	
	public Applicants() {
	}

	public Applicants(String fname, String lname, Date dob, long contact, String email, String address, String course,
			String reference) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.contact = contact;
		this.email = email;
		this.address = address;
		this.course = course;
		this.reference = reference;
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
}
